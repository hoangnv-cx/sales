package com.java.sales.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneById(Long id);
	List<UserEntity> findAllByOrderByIdDesc(Pageable pageable);
	UserEntity findByUserName(String name);
	
}
