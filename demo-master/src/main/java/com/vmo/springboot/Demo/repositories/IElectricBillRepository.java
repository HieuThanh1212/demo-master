package com.vmo.springboot.Demo.repositories;

import com.vmo.springboot.Demo.model.ElectricBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IElectricBillRepository extends JpaRepository<ElectricBill, Integer> {
    ElectricBill findByNameAndAndStatus(String name, int status);

    ElectricBill findByName(String name);

    ElectricBill findByIdAndStatus(int id, int status);

}
