package com.vmo.springboot.Demo.controllers;

import com.vmo.springboot.Demo.dto.Request.ElectricBillRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import com.vmo.springboot.Demo.model.ElectricBill;
import com.vmo.springboot.Demo.services.ElectricBillServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.vmo.springboot.Demo.controllers.ResponseController.responseUtil;

@RestController
@RequestMapping("/api")
public class ElectricController {
    @Autowired
    ElectricBillServiceIpml iElectricServices;

    @PostMapping("/lec/add")
    public ResponseEntity<ResponseDto> createElectricBill(@Valid @RequestBody ElectricBillRequestDto electricBillRequestDto) {

            ElectricBill electricBill = iElectricServices.createElectricBill(electricBillRequestDto);
            return responseUtil.getSuccessResponse(electricBill);


    }

    @PutMapping(value = "/lec/{id}")
    public ResponseEntity<ResponseDto> updateElectricBill(@Valid @RequestBody ElectricBillRequestDto electricBillRequestDto, @PathVariable Integer id) {
            ElectricBill electricBill = iElectricServices.getById(id);
            ElectricBill result = iElectricServices.updateElectricBill(electricBillRequestDto, electricBill);
            return responseUtil.getSuccessResponse(result);

    }

    @GetMapping(value = "/lec/all")
    public ResponseEntity<ResponseDto> getAllElectricBill() {
        try {
            List<ElectricBill> electricBills =iElectricServices.getAllElectricBill();
            return responseUtil.getSuccessResponse(electricBills);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(value = "lec/{id}")
    public ResponseEntity<ResponseDto> deleteElectricBill(@PathVariable Integer id) {
        try {
            ElectricBill electricBill = iElectricServices.getById(id);
            iElectricServices.disableElectricBill(electricBill);
            return responseUtil.getSuccessResponse(electricBill);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
