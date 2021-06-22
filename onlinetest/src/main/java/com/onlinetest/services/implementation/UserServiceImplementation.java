package com.onlinetest.services.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetest.entity.User;
import com.onlinetest.entity.UserRole;
import com.onlinetest.repository.RoleRepository;
import com.onlinetest.repository.UserRepository;
import com.onlinetest.services.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			System.out.println("User already exist !!");
			throw new Exception("User alreay present !!");
		}else {
			for(UserRole role : userRoles) {
				roleRepository.save(role.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

}
