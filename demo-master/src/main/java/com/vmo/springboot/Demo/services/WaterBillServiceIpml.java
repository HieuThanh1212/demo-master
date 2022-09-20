package com.vmo.springboot.Demo.services;

import com.vmo.springboot.Demo.constant.EProcess;
import com.vmo.springboot.Demo.dto.Request.WaterBillRequestDto;
import com.vmo.springboot.Demo.model.WaterBill;
import com.vmo.springboot.Demo.repositories.IWaterBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WaterBillServiceIpml  {

    @Autowired
    IWaterBillRepository waterBillRepository;

    public boolean checkDuplicateName(String name) {
        if (waterBillRepository.findByName(name) != null) {
            return true;
        }
        return false;
    }

    public boolean checkDuplicateNameAtProcessing(String name, int status) {
        if (waterBillRepository.findByNameAndStatus(name, status) != null) {
            return true;
        }
        return false;
    }

    @Transactional
    public WaterBill createWaterBill(WaterBillRequestDto waterBillRequestDto, String nameReceivable) {
        WaterBill waterBill = new WaterBill().builder()
                .name(nameReceivable)
                .newBillW(waterBillRequestDto.getWaterNumberNew())
                .unit(waterBillRequestDto.getUnit())
                .status(EProcess.PROCESSING.getId())
                .build();
        waterBillRepository.save(waterBill);
        return waterBill;
    }

    @Transactional
    public WaterBill createWaterBill(WaterBillRequestDto waterBillRequestDto) {
        WaterBill waterBill = new WaterBill().builder()
                .name("water_" + waterBillRequestDto.getName())
                .oldBillW(0)
                .newBillW(waterBillRequestDto.getWaterNumberNew())
                .unit(waterBillRequestDto.getUnit())
                .status(EProcess.PROCESSING.getId())
                .build();
        waterBillRepository.save(waterBill);
        return waterBill;
    }

    @Transactional
    public WaterBill updateWaterBill(WaterBillRequestDto waterBillRequestDto, WaterBill waterBill) {
        if (!waterBill.getName().equalsIgnoreCase(waterBillRequestDto.getName()) && waterBill.getStatus() == EProcess.PROCESSING.getId()) {
            if (checkDuplicateNameAtProcessing(waterBillRequestDto.getName(), EProcess.PROCESSING.getId()) == true) {
                return null;
            }
            waterBill.update(waterBillRequestDto, waterBill);
            waterBillRepository.save(waterBill);
        }
        waterBill.update(waterBillRequestDto, waterBill);
        waterBillRepository.save(waterBill);

        return waterBill;
    }

    @Transactional
    public void disableWaterBill(WaterBill waterBill) {
        waterBill.setStatus(EProcess.DONE.getId());
        waterBillRepository.save(waterBill);
    }

    public WaterBill getByIdWaterBill(Integer id) {
        if (waterBillRepository.findById(id).isPresent()) {
            return waterBillRepository.findById(id).get();
        }
        return null;
    }

    public WaterBill getByIdAndStatus(int id, int status) {
        WaterBill waterBill = waterBillRepository.findByIdAndStatus(id, status);
        return waterBill;
    }

    public WaterBill getByName(String name) {
        WaterBill waterBill = waterBillRepository.findByName(name);
        return waterBill;
    }

    public WaterBill getByNameAndStatus(String name, int status) {
        WaterBill waterBill = waterBillRepository.findByNameAndStatus(name, status);
        return waterBill;
    }

    public List<WaterBill> getAllWaterBill() {
        return waterBillRepository.findAll();
    }



}
