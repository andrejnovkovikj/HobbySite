package com.example.hobbysite.service.impl;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.model.ActivityLocation;
import com.example.hobbysite.model.exception.GlobalException;
import com.example.hobbysite.repository.ActivityCategoryRepository;
import com.example.hobbysite.repository.ActivityLocationRepository;
import com.example.hobbysite.service.ActivityCategoryService;
import com.example.hobbysite.service.ActivityLocationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityLocationServiceImpl implements ActivityLocationService {
    private final ActivityLocationRepository activityLocationRepository;

    public ActivityLocationServiceImpl(ActivityLocationRepository activityLocationRepository) {
        this.activityLocationRepository = activityLocationRepository;
    }
    @Override
    public ActivityLocation findById(Long id){
        return this.activityLocationRepository.findById(id).orElseThrow(GlobalException::new);
    }
    @Override
    public ActivityLocation findByName(String name){
        return this.activityLocationRepository.findByName(name);
    }
    @Override
    public List<ActivityLocation> listAll(){
        return this.activityLocationRepository.findAll();
    }
    @Override
    public ActivityLocation create(String name){
        ActivityLocation activityLocation = new ActivityLocation(name);
        return this.activityLocationRepository.save(activityLocation);
    }
    @Override
    public ActivityLocation update(Long id,String name){
        ActivityLocation activityLocation=findById(id);
        activityLocation.setName(name);
        return this.activityLocationRepository.save(activityLocation);
    }
    @Override
    public ActivityLocation delete(Long id){
        ActivityLocation activityLocation=findById(id);
        this.activityLocationRepository.delete(activityLocation);
        return activityLocation;
    }
}
