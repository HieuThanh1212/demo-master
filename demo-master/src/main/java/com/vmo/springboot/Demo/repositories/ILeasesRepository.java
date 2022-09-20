package com.vmo.springboot.Demo.repositories;

import com.vmo.springboot.Demo.model.Apartment;
import com.vmo.springboot.Demo.model.Leases;
import com.vmo.springboot.Demo.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILeasesRepository extends JpaRepository<Leases, Integer> {
    Leases findByApartmentAndTenant(Apartment apartment, Tenant tenant);
    List<Leases> findAllByApartmentAndStatus(Apartment apartment, int status);

}
