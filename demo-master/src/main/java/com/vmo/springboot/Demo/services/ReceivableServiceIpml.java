package com.vmo.springboot.Demo.services;

import com.vmo.springboot.Demo.constant.EProcess;
import com.vmo.springboot.Demo.dto.Request.ReceivableRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ReceivableResponseDto;
import com.vmo.springboot.Demo.model.*;
import com.vmo.springboot.Demo.repositories.IReceivableRepository;
import com.vmo.springboot.Demo.services.Interface.IGenericService;
import com.vmo.springboot.Demo.services.mail.MailService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@Service
public class ReceivableServiceIpml  {
    @Autowired
    IReceivableRepository iReceivableRepository;
    @Autowired
    ElectricBillServiceIpml electricBillService;

    @Autowired
    WaterBillServiceIpml waterBillService;

   @Autowired
   MailService emailService;

    @Autowired
    ServiceOtherServicesIpml serviceOtherService;

    public int separatePricing(int oldNumber, int newNumber, int unit) {
        int calculate = (newNumber - oldNumber) * unit;
        return calculate;
    }

    @Transactional
    public Receivable createReceivable(ReceivableRequestDto receivableRequestDto, Leases leases) {
        ElectricBill electricBill = electricBillService.getByNameAndStatus(receivableRequestDto.getName(), EProcess.PROCESSING.getId());
        if (electricBill == null) {
            electricBill = new ElectricBill().builder()
                    .name("elec_" + receivableRequestDto.getName())
                    .status(EProcess.PROCESSING.getId())
                    .build();
        }

        WaterBill waterBill = waterBillService.getByNameAndStatus(receivableRequestDto.getName(), EProcess.PROCESSING.getId());
        if (waterBill == null) {
            waterBill = new WaterBill().builder()
                    .name("water_" + receivableRequestDto.getName())
                    .status(EProcess.PROCESSING.getId())
                    .build();
        }
        int electricPayment = separatePricing(electricBill.getOldBillE(), electricBill.getNewBillE(), electricBill.getUnit());

        int waterPayment = separatePricing(waterBill.getOldBillW(), waterBill.getNewBillW(), waterBill.getUnit());

        Set<ServiceOther> serviceOthers = serviceOtherService.getServiceListById(
                receivableRequestDto.getServices()
        );
        //tính tổng tiền những service đã chọn
        int servicePayment = serviceOtherService.getTotalServicePriceIn(serviceOthers);

        //tính tổng tiền tất cả phải chi
        int calculationPayment = electricPayment + waterPayment + leases.getApartment().getPrice()
                + servicePayment;

        Receivable receivable = new Receivable().builder()
                .name(receivableRequestDto.getName())
                .payment(calculationPayment)
                .status(EProcess.PROCESSING.getId())
                .service(serviceOthers)
                .electricBill(electricBill)
                .waterBill(waterBill)
                .leases(leases)
                .build();

        iReceivableRepository.save(receivable);

        return receivable;
    }

    public int calculatePayment(ElectricBill electricBill, WaterBill waterBill, Receivable receivable, Leases leases) {
        int electricPayment = separatePricing(electricBill.getOldBillE(), electricBill.getNewBillE(), electricBill.getUnit());

        int waterPayment = separatePricing(waterBill.getOldBillW(), waterBill.getNewBillW(), waterBill.getUnit());

        //tính tổng tiền những service đã chọn
        int servicePayment = serviceOtherService.getTotalServicePriceIn(receivable.getService());

        //tính tổng tiền tất cả phải chi

        return electricPayment + waterPayment + leases.getApartment().getPrice()
                + servicePayment;
    }

    // Tính tiền của bill
    public String calculatePaymentForm(ElectricBill electricBill, WaterBill waterBill, Receivable receivable, Leases leases) {
        int electricPayment = separatePricing(electricBill.getOldBillE(),electricBill.getNewBillE() , electricBill.getUnit());

        int waterPayment = separatePricing(waterBill.getOldBillW(),waterBill.getNewBillW() , waterBill.getUnit());

        //tính tổng tiền những service đã chọn
        int servicePayment = serviceOtherService.getTotalServicePriceIn(receivable.getService());
        int apartmentPayment = leases.getApartment().getPrice();

        //tính tổng tiền
        int calculationPayment = electricPayment + waterPayment + apartmentPayment
                + servicePayment;

        return createBillForm(servicePayment, electricPayment, waterPayment, apartmentPayment, calculationPayment);
    }

    //tạo bill form
    public String createBillForm(int servicePayment, int electricPayment, int waterPayment, int calculationPayment, int apartmentPayment) {
        return "\n\tHoá đơn\n"
                + "\ntiền nhà: " + apartmentPayment
                + "\ntiền điện: " + electricPayment
                + "\ntiền nước: " + waterPayment
                + "\ntiền dịch vụ: " + servicePayment
                + "\nthanh toán: " + calculationPayment;
    }


    public Receivable getByIdReceivable(int id) {
        if (iReceivableRepository.findById(id).isPresent()) {
            return iReceivableRepository.findById(id).get();
        }
        return null;
    }

    public Receivable getByNameReceivable(String name) {
        return iReceivableRepository.findByName(name);
    }

    public Receivable getByNameReceivableAndStatus(String name, int status) {
        return iReceivableRepository.findByNameAndStatus(name, status);
    }

    public ReceivableResponseDto getDetailById(int id) {
        Receivable receivable = getByIdReceivable(id);
        if (receivable == null) {
            return null;
        }

        String payment = calculatePaymentForm(receivable.getElectricBill(), receivable.getWaterBill(), receivable, receivable.getLeases());

        ReceivableResponseDto receivableResponseDto = new ReceivableResponseDto(
                receivable.getId(),
                receivable.getName(),
                receivable.getCreate_at(),
                receivable.getUpdate_at(),
                receivable.getStatus(),
                receivable.getService(),
                receivable.getElectricBill(),
                receivable.getWaterBill(),
                receivable.getLeases(),
                payment
        );

        return receivableResponseDto;
    }

    public Receivable updateReceivable(ReceivableRequestDto receivableRequestDto, Receivable receivable) {
        int payment = calculatePayment(receivable.getElectricBill(), receivable.getWaterBill(), receivable, receivable.getLeases());

        if (!receivable.getName().equalsIgnoreCase(receivableRequestDto.getName()) && receivable.getStatus() == EProcess.PROCESSING.getId()) {
            if (checkDuplicateNameAtProcessing(receivableRequestDto.getName(), EProcess.PROCESSING.getId()) == true) {
                return null;
            }
            receivable.setName(receivableRequestDto.getName());
            receivable.setCreate_at(receivable.getCreate_at());
            receivable.setUpdate_at(receivableRequestDto.getUpdateAt());
            receivable.setPayment(payment);
            iReceivableRepository.save(receivable);
        }

        receivable.setName(receivableRequestDto.getName());
        receivable.setPayment(payment);
        iReceivableRepository.save(receivable);

        return receivable;
    }

    public boolean checkDuplicateNameAtProcessing(String name, int status) {
        if (iReceivableRepository.findByNameAndStatus(name, status) != null) {
            return true;
        }
        return false;
    }

    public void disableReceivable(Receivable receivable) {
        receivable.setStatus(EProcess.DONE.getId());
        waterBillService.disableWaterBill(receivable.getWaterBill());
        electricBillService.disableElectricBill(receivable.getElectricBill());
        iReceivableRepository.save(receivable);
    }

    public List<Receivable> findAllReceivables() {
        return iReceivableRepository.findAll();
    }

    public List<Receivable> findAllReceivablesByName(String name) {
        return iReceivableRepository.findAllByName(name);
    }


    public String listServiceOtherOnAReservation(Receivable receivable) {
        String s = "";
        for (ServiceOther serviceOther : receivable.getService()) {
            s += serviceOther.toString();
        }
        return s;
    }


        public void sendMailToUser(Receivable receivable)  {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
        System.out.println("Test: " + timeStamp);
            try {
                emailService.sendEmail(
                        receivable.getLeases().getTenant().getEmail(),
                        timeStamp + "[#Phong_" + receivable.getLeases().getApartment().getName() + "] HOÁ ĐƠN CẦN THANH TOÁN ",
                        formatEmailReceivable(receivable)
                );
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    @Transactional
    public String formatEmailReceivable(Receivable receivable) {
        return
                "PHÍ DỊCH VỤ CĂN HỘ " + receivable.getLeases().getApartment().getName() +
                        "\nTên chủ hộ: " + receivable.getLeases().getTenant().getName() +
                        "\nNội dung cần thanh toán: \n" +
                        "\n- Giá phòng: " + receivable.getLeases().getApartment().getPrice() + "VND" +
                        "\n- Giá điện: " + receivable.getElectricBill().getUnit() + " (Số cũ: " + receivable.getElectricBill().getOldBillE() + "Số mới:" + receivable.getElectricBill().getOldBillE() + ")" +
                        "\n- Thành tiền: " + separatePricing(receivable.getElectricBill().getOldBillE(), receivable.getElectricBill().getNewBillE(), receivable.getElectricBill().getUnit()) +
                        "\n- Giá nước sạch: " + receivable.getWaterBill().getUnit() + " (Số cũ: " + receivable.getWaterBill().getOldBillW() + "Số mới:" + receivable.getWaterBill().getNewBillW() + ")" +
                        "\n- Thành tiền: " + separatePricing(receivable.getWaterBill().getOldBillW(), receivable.getWaterBill().getNewBillW(), receivable.getWaterBill().getUnit()) +
                        "\n- Các chi phí dịch phụ khác : " +
                        "\t" +
                        listServiceOtherOnAReservation(receivable) +
                        "\n=> TỔNG CỘNG: " + calculatePayment(
                        receivable.getElectricBill(), receivable.getWaterBill(), receivable, receivable.getLeases()
                ) + " VND"
                ;
    }


    @Scheduled(cron = "0 0 9 15 * ?") // 9h hang thang
 @Scheduled(fixedDelay = 1000)
    private void reminderPaid() {
        List<Receivable> receivables = iReceivableRepository.findAllByStatus(EProcess.PROCESSING.getId());
        for (Receivable receivable : receivables) {
            sendMailToUser(receivable);
        }
    }
}
