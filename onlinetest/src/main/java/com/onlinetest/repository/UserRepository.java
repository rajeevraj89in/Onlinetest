package com.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinetest.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
}
