package com.vmo.springboot.Demo.repositories;

import com.vmo.springboot.Demo.model.ERole;
import com.vmo.springboot.Demo.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
