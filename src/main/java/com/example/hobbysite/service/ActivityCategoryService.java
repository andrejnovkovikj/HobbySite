package com.example.hobbysite.service;

import com.example.hobbysite.model.ActivityCategory;

import java.util.List;

public interface ActivityCategoryService {
    ActivityCategory findById(Long id);
    ActivityCategory findByName(String name);
    List<ActivityCategory> listAll();
    ActivityCategory create(String name);
    ActivityCategory update(Long id,String name);
    ActivityCategory delete(Long id);

}
