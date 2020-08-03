package com.java.sales.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.HelpEntity;

public interface IHelpRepository extends JpaRepository<HelpEntity, Long>{
	HelpEntity findOneById(Long id);
	List<HelpEntity> findAllByOrderByIdDesc();
	List<HelpEntity> findAllByOrderByIdDesc(Pageable pageable);
}
