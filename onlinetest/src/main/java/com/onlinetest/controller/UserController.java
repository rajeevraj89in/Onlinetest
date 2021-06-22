package com.onlinetest.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetest.entity.Role;
import com.onlinetest.entity.User;
import com.onlinetest.entity.UserRole;
import com.onlinetest.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// Creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("default.jpg");
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Role role = new Role();
		role.setRoleId(2L);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		Set<UserRole> userRoleSet = new HashSet<>();
		userRoleSet.add(userRole);
		
		return this.userService.createUser(user, userRoleSet);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	
}
