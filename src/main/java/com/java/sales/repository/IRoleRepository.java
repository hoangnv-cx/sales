package com.java.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.RoleEntity;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findByCode(String code);
}
