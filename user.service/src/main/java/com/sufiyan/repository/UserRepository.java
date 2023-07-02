package com.sufiyan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sufiyan.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(long userId);
}
