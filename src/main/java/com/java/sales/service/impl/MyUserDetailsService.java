package com.java.sales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.sales.entity.RoleEntity;
import com.java.sales.entity.UserEntity;
import com.java.sales.repository.IUserRepository;
@Service

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserRepository userRepository;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		UserEntity entitys=userRepository.findByUserName(username);	
		

		
		if (entitys == null) {
            throw new UsernameNotFoundException("User not found");
        }		
		List<RoleEntity> roleEntities=entitys.getRoles();
			List<String> roleCode=new ArrayList<>();
			for(RoleEntity entity:roleEntities) {
				roleCode.add(entity.getCode());				
			}		
		List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
		 if(roleCode!= null)  {
	           for(String role:roleCode) {        	
	        	   GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" +role);
	                grantList.add(authority);
	           }           
	        }	
		 UserDetails userDetails = (UserDetails) new User(entitys.getUserName(), 
				 entitys.getPassword(),grantList);
		
		return userDetails;
	}

}
