package com.vmo.springboot.Demo.repositories;

import com.vmo.springboot.Demo.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITenantRepository extends JpaRepository<Tenant, Integer> {
  //public Tenant  findbyidcard(String idcard);
}
