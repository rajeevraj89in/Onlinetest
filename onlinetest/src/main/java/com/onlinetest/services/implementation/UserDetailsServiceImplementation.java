package com.onlinetest.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlinetest.entity.User;
import com.onlinetest.repository.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		if(user == null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("No user found !!");
		}
		return user;
	}

}
