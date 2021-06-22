package com.onlinetest.services;

import java.util.Set;

import com.onlinetest.entity.User;
import com.onlinetest.entity.UserRole;

public interface UserService {
	
	// Create User
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	// Get User By Name
	public User getUser(String username);
	
	// Delete User
	public void deleteUser(Long userId);
	

}
