package com.java.sales.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.java.sales.dto.HelpDTO;

public interface IHelpService {
	HelpDTO save(HelpDTO dto);
	List<HelpDTO> findAllByOrderByIdDesc();
	List<HelpDTO> findAllByOrderByIdDesc(Pageable pageable);
	HelpDTO findOneById(Long id);
	int count();

}
