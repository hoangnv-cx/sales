package com.java.sales.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.sales.api.output.UserOutput;
import com.java.sales.dto.RoleDTO;
import com.java.sales.dto.UserDTO;
import com.java.sales.service.IUserService;
@RestController
public class UserAPI {

	@Autowired
	IUserService userService;
	//get danh sách user
	@GetMapping(value = "/admin/user/list")
	public UserOutput getListUser(@RequestParam(value = "page",required = false) Integer page,
									@RequestParam(value = "limit",required = false)Integer limit) {
		UserOutput resault=new UserOutput();
		if(page != null & limit != null) {
			Pageable pageable=PageRequest.of(page-1,limit);
			resault.setResaults(userService.findAllByOrderByIdDesc(pageable));
			resault.setTotalPgae((int) Math.ceil(userService.count())/limit);
			resault.setPage(page);
		}else {
			resault.setResaults(userService.findAllByOrderByIdDesc());
		}		
		return resault;
	}
	//get user by id
	@GetMapping(value = "/admin/user/id")
	public UserDTO getUserById(@RequestParam("id") Long id) {		
		return userService.findOneById(id);
	}
	//get user by name
	@GetMapping(value = "/web/user/name")
	public UserDTO getUserByUserName(@RequestParam("username") String userName) {		
		return userService.findOneByName(userName);
	}
	//get user by role
	@GetMapping(value = "/admin/user/role")
	public UserOutput getItem(@RequestParam("roleCode") String roleCode) {	
		UserOutput results=new UserOutput();
		results.setResaults(userService.findAllByRoleCode(roleCode));
		return results;
	}
	
	
	//add user với quyền người dùng
	@PostMapping(value = "/login")
	public UserDTO addUserWeb(@RequestBody UserDTO dto) {		
		List<RoleDTO> roleDTOs=new ArrayList<RoleDTO>();
		RoleDTO roleDTO=new RoleDTO();
		roleDTO.setCode("USER");
		roleDTOs.add(roleDTO);
		dto.setRoleCodes(roleDTOs);
		return userService.save(dto);
	}
	//update user quyền người dùng
	@PutMapping(value = "/api/web/user")
	public UserDTO updateUserWeb(@RequestBody UserDTO dto) {
		List<RoleDTO> roleDTOs=new ArrayList<RoleDTO>();
		RoleDTO roleDTO=new RoleDTO();
		roleDTO.setCode("USER");
		roleDTOs.add(roleDTO);
		dto.setRoleCodes(roleDTOs);
		return userService.save(dto);
	}
	//add user admin
	@PostMapping(value = "/api/admin/user")
	public UserDTO addUserAdmin(@RequestBody UserDTO dto) {		
		return userService.save(dto);
	}
	//update theo quyền admin
	@PutMapping(value = "/api/admin/user")
	public UserDTO updateUserAdmin(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	//xóa user
	@DeleteMapping(value = "/api/admin/user")
	public void deleteUserAdmin(@RequestBody long[] ids) {
		userService.delete(ids);
	}
	
}
