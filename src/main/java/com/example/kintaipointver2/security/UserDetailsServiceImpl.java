package com.example.kintaipointver2.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.kintaipointver2.entity.Employee;
import com.example.kintaipointver2.repository.EmployeeRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final EmployeeRepository employeeRepository;
	
	public UserDetailsServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			Employee employee = employeeRepository.findByEmail(email);
			String userRoleName = employee.getRole().getName();
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(userRoleName));
			return new UserDetailsImpl(employee, authorities);
		} catch (Exception e) {
			throw new UsernameNotFoundException("ユーザーが見つかりません");
		}
	}
}
