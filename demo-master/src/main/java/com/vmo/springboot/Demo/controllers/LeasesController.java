package com.vmo.springboot.Demo.controllers;


import com.vmo.springboot.Demo.dto.Request.LeasesRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import com.vmo.springboot.Demo.model.Apartment;
import com.vmo.springboot.Demo.model.Leases;
import com.vmo.springboot.Demo.model.Tenant;
import com.vmo.springboot.Demo.services.ApartmentSeviceImpl;
import com.vmo.springboot.Demo.services.LeasesServiceIpml;
import com.vmo.springboot.Demo.services.TenantServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LeasesController  extends  ResponseController{
    @Autowired
    TenantServiceIpml tenantService;
    @Autowired
    LeasesServiceIpml leasesService;
    @Autowired
    ApartmentSeviceImpl apartmentService;

    @PostMapping("lea/add")
    public HttpEntity<ResponseDto> createLeases(@Valid @RequestBody LeasesRequestDto leasesRequestDto) {
        try {
            Apartment apartment = apartmentService.getByIdApartment(leasesRequestDto.getApartmentId());

            Tenant tenant = tenantService.getByIdTenant(leasesRequestDto.getTenantId());


            Leases leases = leasesService.createLeases(leasesRequestDto, apartment, tenant);

            return responseUtil.getSuccessResponse(leases);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @PutMapping(value = "lea/{id}")
    public ResponseEntity<ResponseDto> updateLeases(@PathVariable("id") Integer id, @RequestBody LeasesRequestDto leasesRequestDto) {
        try {
            Leases leases = leasesService.getByIdLeases(id);

            Apartment apartment = apartmentService.getByIdApartment(leasesRequestDto.getApartmentId());

            Tenant tenant = tenantService.getByIdTenant(leasesRequestDto.getTenantId());
            if (tenant == null) {
                return null;
            }

            leasesService.updateLeases(leasesRequestDto, leases, apartment, tenant);
            return responseUtil.getSuccessResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(value = "lea/{id}")
    public ResponseEntity<ResponseDto> deleteLease(@PathVariable("id") Integer id) {
        try {
            Leases leases = leasesService.getByIdLeases(id);
            if (leases == null) {
                return null;
            }
            leasesService.deleteLeases(leases);
            return responseUtil.getSuccessResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "lea/{id}")
    public ResponseEntity<ResponseDto> getByIdLeases(@PathVariable("id") Integer id) {
        try {
            Leases leases = leasesService.getByIdLeases(id);

            return responseUtil.getSuccessResponse(leases);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("lea/all")
    public ResponseEntity<ResponseDto> getAllLeases() {
        try {
            List<Leases> leases = leasesService.getAllLeases();
            return responseUtil.getSuccessResponse(leases);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
