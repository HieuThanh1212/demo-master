package com.vmo.springboot.Demo.repositories;

import com.vmo.springboot.Demo.model.Receivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReceivableRepository extends JpaRepository<Receivable, Integer> {
    Receivable findByName(String name);

    List<Receivable> findAllByName(String name);

    Receivable findByNameAndStatus(String name, int status);

    List<Receivable> findAllByStatus(int statusId);
}
