package com.java.sales.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.java.sales.dto.ItemDTO;

public interface IItemService {

	ItemDTO save(ItemDTO dto);
	void delete(long[] ids);
	ItemDTO findOneById(Long id);
	List<ItemDTO> findAllByOrderByIdDesc(Pageable pageable); 
	int count();
	List<ItemDTO> findAllByOrderByIdDesc(); 
	List<ItemDTO> findAllByClassifysOrderByIdDesc(String classifyCode); 
}
