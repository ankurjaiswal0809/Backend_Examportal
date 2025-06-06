package com.examportal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examportal.helper.UserNotFoundException;
import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {	
		
		Set<UserRole> roles=new HashSet<>();
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();		
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		User user2 = this.userService.createUser(user,roles);		
		return user2;	
		
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {		
		User userById = this.userService.getUserById(id);
		return userById;
	}
	
	@GetMapping("/")
	public List<User> getAllUser(User user){		
		List<User> allUser = this.userService.getAllUser(user);
		return allUser;		
	}	

	@GetMapping("/{userName}")
	public User getUserByUserName(@PathVariable String userName) {		
		User userByName = this.userService.getUserbyUserName(userName);
		return userByName;
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		this.userService.deleteUser(id);
	}
	
	
//	public ResponseEntity<?> exceptionHandler(UserNotFoundException ex){
//		return ResponseEntity.
//	}
//	
		
}
