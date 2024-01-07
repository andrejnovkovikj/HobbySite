package com.example.hobbysite.service.impl;

import com.example.hobbysite.model.ActivityCategory;
import com.example.hobbysite.model.exception.GlobalException;
import com.example.hobbysite.repository.ActivityCategoryRepository;
import com.example.hobbysite.service.ActivityCategoryService;
import com.example.hobbysite.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {
    private final ActivityCategoryRepository activityCategoryRepository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository activityCategoryRepository) {
        this.activityCategoryRepository = activityCategoryRepository;
    }

    @Override
    public ActivityCategory findById(Long id){
        return this.activityCategoryRepository.findById(id).orElseThrow(GlobalException::new);
    }
    @Override
    public ActivityCategory findByName(String name){
        return this.activityCategoryRepository.findByName(name);
    }

    @Override
    public List<ActivityCategory> listAll(){
        return this.activityCategoryRepository.findAll();
    }
    @Override
    public ActivityCategory create (String name){
        ActivityCategory activityCategory = new ActivityCategory(name);
        return this.activityCategoryRepository.save(activityCategory);
    }
    @Override
    public ActivityCategory update (Long id, String name){
        ActivityCategory activityCategory=findById(id);
        activityCategory.setName(name);
        return this.activityCategoryRepository.save(activityCategory);
    }
    @Override
    public ActivityCategory delete(Long id){
        ActivityCategory activityCategory = findById(id);
        this.activityCategoryRepository.delete(activityCategory);
        return activityCategory;
    }
}
