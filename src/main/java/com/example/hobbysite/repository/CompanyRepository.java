package com.example.hobbysite.repository;

import com.example.hobbysite.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{
    Company findByName(String name);
}
