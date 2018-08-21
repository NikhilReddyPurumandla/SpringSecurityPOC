package com.example.security.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.model.CustomUserDetails;
import com.example.security.model.Users;
import com.example.security.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	private CustomUserDetails customUserDetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> optionalUsers = usersRepository.findByName(username);
		
		if (!optionalUsers.isPresent()) {
			throw new UsernameNotFoundException("UserName not found!!");
		}

		return optionalUsers
                .map(CustomUserDetails::new).get();

	}
}
