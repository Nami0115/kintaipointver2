package com.example.kintaipointver2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kintaipointver2.entity.Company;

public interface CompanyRepository extends JpaRepository <Company, Integer> {

}
