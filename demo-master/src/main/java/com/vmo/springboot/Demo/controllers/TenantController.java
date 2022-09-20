package com.vmo.springboot.Demo.controllers;

import com.vmo.springboot.Demo.dto.Request.TenantRequestDto;
import com.vmo.springboot.Demo.dto.Respone.ResponseDto;
import com.vmo.springboot.Demo.model.Tenant;
import com.vmo.springboot.Demo.services.ApartmentSeviceImpl;
import com.vmo.springboot.Demo.services.TenantServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.vmo.springboot.Demo.controllers.ResponseController.responseUtil;

@RestController
@RequestMapping("/api")
public class TenantController {
    @Autowired
    TenantServiceIpml iServicetenant;

    @Autowired
    ApartmentSeviceImpl apartmentService;

    @PostMapping("/ten/add")
    public ResponseEntity<ResponseDto> createTenant(@Valid @RequestBody TenantRequestDto tenantRequestDto) {
        try {
            Tenant tenant = iServicetenant.Createtenant(tenantRequestDto);
            return responseUtil.getSuccessResponse(tenant);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/ten/all")
    public ResponseEntity<ResponseDto> getAllTenant() {
        try {
            List<Tenant> tenants = iServicetenant.getall();
            return responseUtil.getSuccessResponse(tenants);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(value = "/ten/{id}")
    public ResponseEntity<ResponseDto> getTenant(@PathVariable("id") Integer id) {
        try {
            Tenant tenant = iServicetenant.getByIdTenant(id);
            if (tenant == null) {
                return null;
            }
            return responseUtil.getSuccessResponse(tenant);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping(value = "/ten/{id}")
    public ResponseEntity<ResponseDto> deleteTenant(@PathVariable("id") Integer id) {
        try {
            Tenant tenant = iServicetenant.getByIdTenant(id);
            if (tenant == null) {
                return null;
            }
            iServicetenant.Delete(tenant);
            return responseUtil.getSuccessResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping(value = "/ten/{id}")
    public ResponseEntity<ResponseDto> updateTenant(@PathVariable("id") Integer id, @RequestBody TenantRequestDto tenantRequestDto) {
        try {
            Tenant tenant = iServicetenant.getByIdTenant(id);
            if (tenant == null) {
                return null;
            }
            Tenant result = iServicetenant.updateTenant(tenantRequestDto, tenant);
            if (result == null) {
                return null;
            }
            return responseUtil.getSuccessResponse(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
