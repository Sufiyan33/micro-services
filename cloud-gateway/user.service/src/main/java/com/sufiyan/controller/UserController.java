package com.sufiyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sufiyan.modal.User;
import com.sufiyan.service.UserService;
import com.sufiyan.valueobject.ResponseTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.save(user);
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") long userId) {
		return service.fetchUser(userId);
	}

	@GetMapping("/du/{id}")
	public ResponseTemplate fetchUserWithDepartment(@PathVariable("id") long userId) {
		return service.getUserWithDepartment(userId);
	}

	@GetMapping("/alluser")
	public List<User> getAllUser() {
		return service.fetchAllUser();
	}
}
