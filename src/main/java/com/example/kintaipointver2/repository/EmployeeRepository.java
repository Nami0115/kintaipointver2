package com.example.kintaipointver2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintaipointver2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
