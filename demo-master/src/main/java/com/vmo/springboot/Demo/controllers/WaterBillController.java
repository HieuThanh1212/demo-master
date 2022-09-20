package com.vmo.springboot.Demo.controllers;

import com.vmo.springboot.Demo.dto.Request.WaterBillRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import com.vmo.springboot.Demo.model.WaterBill;
import com.vmo.springboot.Demo.services.WaterBillServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.vmo.springboot.Demo.controllers.ResponseController.responseUtil;

@RestController
@RequestMapping("/api")
public class WaterBillController {

    @Autowired
    WaterBillServiceIpml waterBillServiceIpml;

    @PostMapping("/wat/add")
    public ResponseEntity<ResponseDto> createElectricBill(@Valid @RequestBody WaterBillRequestDto waterBillRequestDto) {

        WaterBill waterBill = waterBillServiceIpml.createWaterBill(waterBillRequestDto);
        return responseUtil.getSuccessResponse(waterBill);


    }

    @PutMapping(value = "/wat/{id}")
    public ResponseEntity<ResponseDto> updateElectricBill(@Valid @RequestBody WaterBillRequestDto waterBillRequestDto, @PathVariable Integer id) {
        WaterBill waterBill = waterBillServiceIpml.getByIdWaterBill(id);
        WaterBill result = waterBillServiceIpml.updateWaterBill(waterBillRequestDto, waterBill);
        return responseUtil.getSuccessResponse(result);

    }

    @GetMapping(value = "/wat/all")
    public ResponseEntity<ResponseDto> getAllElectricBill() {
        try {
            List<WaterBill> waterBills =waterBillServiceIpml.getAllWaterBill();
            return responseUtil.getSuccessResponse(waterBills);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(value = "/wat/{id}")
    public ResponseEntity<ResponseDto> deleteElectricBill(@PathVariable Integer id) {
        try {
            WaterBill waterBill = waterBillServiceIpml.getByIdWaterBill(id);
            waterBillServiceIpml.disableWaterBill(waterBill);
            return responseUtil.getSuccessResponse(waterBill);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
