package com.java.sales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.sales.Utils.SecurityUtils;
import com.java.sales.converter.RoleConverter;
import com.java.sales.converter.UserConverter;
import com.java.sales.dto.RoleDTO;
import com.java.sales.dto.UserDTO;
import com.java.sales.entity.RoleEntity;
import com.java.sales.entity.UserEntity;
import com.java.sales.repository.IRoleRepository;
import com.java.sales.repository.IUserRepository;
import com.java.sales.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private IRoleRepository roleRepository;
	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public UserDTO save(UserDTO dto) {
		UserEntity entityItem=new UserEntity();
		
		if(dto.getId() != null) {
			UserEntity entity=userRepository.findOneById(dto.getId());
			//if(entity.getUserName().equals(SecurityUtils.getName())) {
				
			//}
			
			entityItem=userConverter.dtoToEntity(dto, entity);		
		}else {	
			UserEntity entity=userRepository.findByUserName(dto.getUserName());
			if (entity != null) {
	            return null;
	        }else {
	        	entityItem=userConverter.dtoToEntity(dto);
	          }
			
		}
		List<RoleEntity> roleEntities=new ArrayList<>();
		for(RoleDTO dtoRole:dto.getRoleCodes()) {
			RoleEntity roleEntity=roleRepository.findByCode(dtoRole.getCode());
			roleEntities.add(roleEntity);
		}
		entityItem.setRoles(roleEntities);		
		userRepository.save(entityItem);
		return userConverter.entityToDto(entityItem);
	}

	@Override
	public void delete(long[] ids) {
		for(Long id:ids)
		{
			userRepository.deleteById(id);
		}		
	}

	@Override
	public UserDTO findOneById(Long id) {
		UserEntity entityUser=userRepository.findOneById(id);
		UserDTO dto=new UserDTO();
		dto=userConverter.entityToDto(entityUser);
		List<RoleDTO> dtos=new ArrayList<RoleDTO>();
		for(RoleEntity entityRole:entityUser.getRoles()) {
			RoleDTO dtoRole=new RoleDTO();
			dtoRole=roleConverter.entityToDto(entityRole);
			dtos.add(dtoRole);	
		}
		dto.setRoleCodes(dtos);
		return dto;
	}

	@Override
	public List<UserDTO> findAllByOrderByIdDesc(Pageable pageable) {
		List<UserEntity> entities=userRepository.findAllByOrderByIdDesc(pageable);
		List<UserDTO> dtos=new ArrayList<UserDTO>();
		for(UserEntity entity:entities) {
			UserDTO dto=new UserDTO();
			dto=userConverter.entityToDto(entity);
			List<RoleDTO> dtosRole=new ArrayList<RoleDTO>();
			for(RoleEntity entityRole:entity.getRoles()) {
				RoleDTO dtoRole=new RoleDTO();
				dtoRole=roleConverter.entityToDto(entityRole);
				dtosRole.add(dtoRole);		
			}
			dto.setRoleCodes(dtosRole);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int count() {
		
		return (int) userRepository.count();
	}

	@Override
	public List<UserDTO> findAllByOrderByIdDesc() {
		List<UserEntity> entities=userRepository.findAll();
		List<UserDTO> dtos=new ArrayList<UserDTO>();
		for(UserEntity entity:entities) {
			UserDTO dto=new UserDTO();
			dto=userConverter.entityToDto(entity);
			
			
			List<RoleDTO> dtosRole=new ArrayList<RoleDTO>();
			for(RoleEntity entityRole:entity.getRoles()) {
				RoleDTO dtoRole=new RoleDTO();
				dtoRole=roleConverter.entityToDto(entityRole);
				dtosRole.add(dtoRole);		
			}
			dto.setRoleCodes(dtosRole);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public UserDTO findOneByName(String name) {
		UserEntity entity=userRepository.findByUserName(name);
		
		if(entity.getUserName().equals(SecurityUtils.getName())) {
			UserDTO dto=new UserDTO();
			dto=userConverter.entityToDto(entity);
			return dto;
		}
		
		
		return null;
	}

	@Override
	public List<UserDTO> findAllByRoleCode(String roleCode) {
		RoleEntity roleEntity=roleRepository.findByCode(roleCode);
		List<UserEntity> userEntities=roleEntity.getUsers();
		List<UserDTO> userDTOs=new ArrayList<UserDTO>();
		for(UserEntity entity:userEntities) {
			UserDTO dto=new UserDTO();
			dto=userConverter.entityToDto(entity);
			userDTOs.add(dto);
		}
		return userDTOs;
	}

}
