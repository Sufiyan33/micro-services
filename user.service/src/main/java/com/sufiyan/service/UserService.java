package com.sufiyan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sufiyan.modal.User;
import com.sufiyan.repository.UserRepository;
import com.sufiyan.valueobject.Department;
import com.sufiyan.valueobject.ResponseTemplate;

@Service
@Component
@Repository
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private RestTemplate restTemplate;

	public User save(User user) {
		return repository.save(user);
	}

	public User fetchUser(long userId) {
		return repository.findByUserId(userId);
	}

	public List<User> fetchAllUser() {
		return repository.findAll();
	}

	public ResponseTemplate getUserWithDepartment(Long userId) {
		ResponseTemplate rt = new ResponseTemplate();
		User user = repository.findByUserId(userId);
		Department department = restTemplate
				.getForObject("http://localhost:8080/department/fetchDepartment/" + user.getUserId(), Department.class);
		rt.setUser(user);
		rt.setDepartment(department);
		return rt;
	}
}
