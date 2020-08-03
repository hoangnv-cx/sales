package com.java.sales.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.java.sales.dto.UserDTO;

public interface IUserService {

	UserDTO save(UserDTO dto);
	void delete(long[] ids);
	UserDTO findOneById(Long id);
	List<UserDTO> findAllByOrderByIdDesc(Pageable pageable); 
	int count();
	List<UserDTO> findAllByOrderByIdDesc(); 
	UserDTO findOneByName(String name);
	List<UserDTO> findAllByRoleCode(String roleCode);
}
