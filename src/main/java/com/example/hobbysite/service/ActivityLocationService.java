package com.example.hobbysite.service;

import com.example.hobbysite.model.ActivityLocation;

import java.util.List;

public interface ActivityLocationService {
    ActivityLocation findById(Long id);

    ActivityLocation findByName(String name);
    List<ActivityLocation> listAll();
    ActivityLocation create(String name);
    ActivityLocation update(Long id,String name);
    ActivityLocation delete(Long id);
}
