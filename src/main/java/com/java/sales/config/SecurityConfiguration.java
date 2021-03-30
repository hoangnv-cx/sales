package com.java.sales.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;

import com.java.sales.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Transactional
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	       auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().
		exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		
		.antMatchers("/authenticate").permitAll().and()
		.authorizeRequests()
		
		.antMatchers("/login","/api/web/help").permitAll().and()
		
		.authorizeRequests().antMatchers("/api/admin/user","/admin/user/**","/web**").hasAnyRole("ADMIN-USER","ADMIN-ALL").and()
		.authorizeRequests().antMatchers("/web/user/name").hasAnyRole("USER").and()
		.authorizeRequests().antMatchers("/api/admin/item").hasAnyRole("ADMIN-ITEM","ADMIN-ALL").and()
		.authorizeRequests().antMatchers("/api/admin/help","/admin/help**").hasAnyRole("ADMIN-HELP","ADMIN-ALL").and()
		.authorizeRequests().antMatchers("/web/item/**").permitAll()
		.antMatchers("/api/admin/classify").hasRole("ADMIN-ALL")
		.antMatchers("/api/web/comment/**").authenticated()
		.antMatchers("/admin/comment/**").hasAnyRole("ADMIN-COMMENT","ADMIN-ALL")
		.anyRequest().permitAll();
		
		//http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		//.antMatchers("/web/user/name").authenticated()

 }
		
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/Template/**");
	}

}
