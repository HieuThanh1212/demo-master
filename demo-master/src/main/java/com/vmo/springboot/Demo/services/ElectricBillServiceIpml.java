package com.vmo.springboot.Demo.services;

import com.vmo.springboot.Demo.constant.EProcess;
import com.vmo.springboot.Demo.dto.Request.ElectricBillRequestDto;
import com.vmo.springboot.Demo.model.ElectricBill;
import com.vmo.springboot.Demo.repositories.IElectricBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ElectricBillServiceIpml {

    @Autowired
    IElectricBillRepository electricBillRepository;


    public boolean checkDuplicateNameAtProcessing(String name, int status) {
        return electricBillRepository.findByNameAndAndStatus(name, status) != null;
    }


    public ElectricBill createElectricBill(ElectricBillRequestDto electricBillRequestDto, String nameReceivable) {
        ElectricBill electricBill =  new ElectricBill().builder()
                .name(nameReceivable)
                .newBillE(electricBillRequestDto.getElectricNumberNew())
                .unit(electricBillRequestDto.getUnit())
                .status(EProcess.PROCESSING.getId())
                .build();
        electricBillRepository.save(electricBill);
        return electricBill;
    }

    public ElectricBill createElectricBill(ElectricBillRequestDto electricBillRequestDto) {
        ElectricBill electricBill =  new ElectricBill().builder()
                .name("elec" + electricBillRequestDto.getName())
                .createE(new java.util.Date())
                .oldBillE(0)
                .newBillE(electricBillRequestDto.getElectricNumberNew())
                .unit(electricBillRequestDto.getUnit())
                .status(EProcess.PROCESSING.getId())
                .build();
        electricBillRepository.save(electricBill);
        return electricBill;
    }

    @Transactional
    public ElectricBill updateElectricBill(ElectricBillRequestDto electricBillRequestDto, ElectricBill electricBill) {
        if (!electricBill.getName().equalsIgnoreCase(electricBillRequestDto.getName()) && electricBill.getStatus() == EProcess.PROCESSING.getId()) {
            if (checkDuplicateNameAtProcessing(electricBill.getName(), EProcess.PROCESSING.getId()) == true) {
                return null;
            }
            electricBill.update(electricBillRequestDto, electricBill);
            electricBillRepository.save(electricBill);
        }
        electricBill.update(electricBillRequestDto, electricBill);
        electricBillRepository.save(electricBill);
        return electricBill;
    }

    @Transactional
    public void disableElectricBill(ElectricBill electricBill) {
        electricBill.setStatus(EProcess.DONE.getId());
        electricBillRepository.save(electricBill);
    }

    public ElectricBill getById(Integer id) {
        if (electricBillRepository.findById(id).isPresent()) {
            return electricBillRepository.findById(id).get();
        }
        return null;
    }

    public ElectricBill getByIdAndStatus(int id, int status) {
        ElectricBill electricBill = electricBillRepository.findByIdAndStatus(id, status);
        return electricBill;
    }


    public ElectricBill getByNameAndStatus(String name, int status) {
        ElectricBill electricBill = electricBillRepository.findByNameAndAndStatus(name, status);
        return electricBill;
    }

    public List<ElectricBill> getAllElectricBill() {
        return electricBillRepository.findAll();
    }
}
