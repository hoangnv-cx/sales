package com.java.sales.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sales.entity.ClassifyEntity;
import com.java.sales.entity.ItemEntity;

public interface IItemRepository extends JpaRepository<ItemEntity, Long>{
	ItemEntity findOneById(Long id);
	List<ItemEntity> findAllByOrderByIdDesc(Pageable pageable);
	List<ItemEntity> findAllByOrderByIdDesc();
	List<ItemEntity> findAllByClassifyOrderByIdDesc(ClassifyEntity entity);
}
