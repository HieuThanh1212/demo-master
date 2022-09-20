package com.vmo.springboot.Demo.services;

import com.vmo.springboot.Demo.constant.Status;
import com.vmo.springboot.Demo.dto.Request.TenantRequestDto;
import com.vmo.springboot.Demo.model.Apartment;
import com.vmo.springboot.Demo.model.Tenant;
import com.vmo.springboot.Demo.repositories.ITenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TenantServiceIpml {
    @Autowired
    ITenantRepository iTenantRepository;

    public Tenant Createtenant(TenantRequestDto tenantRequestDto){
            Tenant tenant = new Tenant(
                    tenantRequestDto.getName(),
                    tenantRequestDto.getEmail(),
                    tenantRequestDto.getPhone(),
                    tenantRequestDto.getGender(),
                    tenantRequestDto.getDob(),
                    tenantRequestDto.getAge(),
                    tenantRequestDto.getIdCard(),
                    tenantRequestDto.getStatus()
            );
        iTenantRepository.save(tenant);
        return tenant;
    }

    @Transactional
    public Tenant updateTenant(TenantRequestDto tenantRequestDto, Tenant tenant) {
        if (!tenant.getId_cart().equalsIgnoreCase(tenantRequestDto.getIdCard()) == true) {

            tenant.update(tenantRequestDto);
            iTenantRepository.save(tenant);
            return tenant;
        }
        tenant.update(tenantRequestDto);
        iTenantRepository.save(tenant);
        return tenant;
    }

    public Tenant getByIdTenant(Integer id) {
        if (iTenantRepository.findById(id).isPresent()) {
            return iTenantRepository.findById(id).get();
        }
        return null;
    }

    public void Delete(Tenant tenant){
        tenant.setStatus(Status.DISABLE.getId());
        iTenantRepository.save(tenant);
    }

    public List<Tenant> getall() {

        return iTenantRepository.findAll();
    }

//    public Boolean checkDuplicateIdCard(String idCard) {
//        if (iTenantRepository.findbyidcard(idCard) != null) {
//            return false;
//        }
//        return true;
//    }

}
