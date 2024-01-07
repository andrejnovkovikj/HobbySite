package com.example.hobbysite.service;

import com.example.hobbysite.model.Company;

import java.util.List;

public interface CompanyService {
    Company findById(Long id);
    Company findByName (String name);
    List<Company> listAll();
    Company create(String name, String description, String email, String address);
    Company update(Long id,String name, String description, String email, String address);
    Company delete (Long id);
}
