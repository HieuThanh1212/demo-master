package com.vmo.springboot.Demo.services;


import com.vmo.springboot.Demo.constant.Status;
import com.vmo.springboot.Demo.dto.Request.LeasesRequestDto;
import com.vmo.springboot.Demo.model.Apartment;
import com.vmo.springboot.Demo.model.Leases;
import com.vmo.springboot.Demo.model.Tenant;
import com.vmo.springboot.Demo.repositories.ILeasesRepository;
import com.vmo.springboot.Demo.repositories.ITenantRepository;
import com.vmo.springboot.Demo.services.Interface.ILeases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeasesServiceIpml  {
    @Autowired
    ILeasesRepository leasesRepository;

    @Autowired
    ITenantRepository tenantRepository;

    public List<Leases> getAllLeases() {
        List<Leases> leases = leasesRepository.findAll();
        return leases;
    }

    public Leases createLeases(LeasesRequestDto leasesRequestDto, Apartment apartment, Tenant tenant) {

        Leases leases = new Leases(
                leasesRequestDto.getDate(),
                leasesRequestDto.getStatus(),
                leasesRequestDto.getPrice(),
                apartment,
                tenant);
        System.out.println(leases);
        leasesRepository.save(leases);
        return leases;
    }

    public Leases updateLeases(LeasesRequestDto leasesRequestDto, Leases leases, Apartment apartment, Tenant tenant) {
        leases.setDate(leasesRequestDto.getDate());
        leases.setStatus(leasesRequestDto.getStatus());
        leases.setPrice(leasesRequestDto.getPrice());
        leases.setApartment(apartment);
        leases.setTenant(tenant);
        leasesRepository.save(leases);
        return leases;
    }

    public Leases getByIdLeases(Integer id) {
        if (leasesRepository.findById(id).isPresent()) {
            return leasesRepository.findById(id).get();
        }
        return null;
    }

    public void deleteLeases(Leases leases) {
        leases.setStatus(Status.DISABLE.getId());
        leasesRepository.save(leases);
    }

    public List<Leases> checkByApartmentAndStatus(Apartment apartment, int status) {
        return leasesRepository.findAllByApartmentAndStatus(apartment, status);
    }
}
