package com.example.hobbysite.service.impl;

import com.example.hobbysite.model.Company;
import com.example.hobbysite.model.exception.GlobalException;
import com.example.hobbysite.repository.CompanyRepository;
import com.example.hobbysite.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }
    @Override
    public Company findById(Long id){
        return this.companyRepository.findById(id).orElseThrow(GlobalException::new);
    }
    @Override
    public Company findByName(String name){
        return this.companyRepository.findByName(name);
    }
    @Override
    public List<Company> listAll(){
        return this.companyRepository.findAll();
    }
    @Override
    public Company create(String name,String description,String email,String address){
        Company company = new Company(name,description,email,address);
        return this.companyRepository.save(company);
    }
    @Override
    public Company update(Long id,String name,String description,String email,String address){
        Company company = findById(id);
        company.setName(name);
        company.setDescription(description);
        company.setEmail(email);
        company.setAddress(address);
        return this.companyRepository.save(company);
    }
    @Override
    public Company delete(Long id){
        Company company = findById(id);
        this.companyRepository.delete(company);
        return company;
    }

}
