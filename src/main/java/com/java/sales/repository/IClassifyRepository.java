package com.java.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.ClassifyEntity;

public interface IClassifyRepository extends JpaRepository<ClassifyEntity, Long>{
	ClassifyEntity findOneById(Long id);
	ClassifyEntity findByCode(String code);
}
