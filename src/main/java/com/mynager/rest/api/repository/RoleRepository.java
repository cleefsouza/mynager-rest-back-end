package com.mynager.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mynager.rest.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
