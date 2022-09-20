package com.vmo.springboot.Demo.repositories;

import com.vmo.springboot.Demo.model.WaterBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWaterBillRepository extends JpaRepository<WaterBill, Integer> {
    WaterBill findByName(String name);

    WaterBill findByNameAndStatus(String name, int status);

    WaterBill findByIdAndStatus(int id, int status);
}
