package com.example.kintaipointver2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintaipointver2.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
}
