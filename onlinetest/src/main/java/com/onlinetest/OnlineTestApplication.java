package com.onlinetest;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.onlinetest.entity.Role;
import com.onlinetest.entity.User;
import com.onlinetest.entity.UserRole;
import com.onlinetest.services.UserService;

@SpringBootApplication
public class OnlineTestApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OnlineTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting Code");
//		User user = new User();
//		user.setFirstname("Rajeev");
//		user.setLastname("Raj");
//		user.setUsername("raj89in");
//		user.setPassword(bCryptPasswordEncoder.encode("12345"));
//		user.setEmail("raj89in@gmail.com");
//		user.setProfile("default.png");
//
//		Role role = new Role();
//		role.setRoleId(1L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
	}

}
