package com.example.hobbysite.service.impl;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.model.ActivityCategory;
import com.example.hobbysite.model.ActivityLocation;
import com.example.hobbysite.model.Company;
import com.example.hobbysite.model.dto.ActivityDto;
import com.example.hobbysite.model.exception.GlobalException;
import com.example.hobbysite.repository.ActivityCategoryRepository;
import com.example.hobbysite.repository.ActivityLocationRepository;
import com.example.hobbysite.repository.ActivityRepository;
import com.example.hobbysite.repository.CompanyRepository;
import com.example.hobbysite.service.ActivityCategoryService;
import com.example.hobbysite.service.ActivityLocationService;
import com.example.hobbysite.service.ActivityService;
import com.example.hobbysite.service.CompanyService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {
    public final ActivityRepository activityRepository;
    public final ActivityCategoryRepository activityCategoryRepository;
    public final ActivityLocationRepository activityLocationRepository;
    public final CompanyRepository companyRepository;
    public final ActivityCategoryService activityCategoryService;
    public final ActivityLocationService activityLocationService;
    public final CompanyService companyService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ActivityServiceImpl(ActivityRepository activityRepository, ActivityCategoryRepository activityCategoryRepository, ActivityLocationRepository activityLocationRepository, CompanyRepository companyRepository, ActivityCategoryService activityCategoryService, ActivityLocationService activityLocationService, CompanyService companyService, ApplicationEventPublisher applicationEventPublisher) {
        this.activityRepository = activityRepository;
        this.activityCategoryRepository = activityCategoryRepository;
        this.activityLocationRepository = activityLocationRepository;
        this.companyRepository = companyRepository;
        this.activityCategoryService = activityCategoryService;
        this.activityLocationService = activityLocationService;
        this.companyService = companyService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Optional<Activity> findById(Long id){
        return this.activityRepository.findById(id);
    }
    @Override
    public Optional<Activity> findByName(String name){
        return this.activityRepository.findByName(name);
    }
    @Override
    public List<Activity> listAll(){
        return this.activityRepository.findAll();
    }
    @Override
    public List<Activity> findAllByCategoryName(Optional<String> name) {
        if (name.isPresent()) {
            return activityRepository.findAllByCategoryName(name.get());
        } else {
            return activityRepository.findAll();
        }
    }
    @Override
    public List<Activity> filter(Optional<String> category, Optional<String> location) {
        String categoryValue = category.orElse(null);
        String locationValue = location.orElse(null);

        if (categoryValue != null && locationValue != null) {
            return activityRepository.findByCategoryNameAndLocationName(categoryValue, locationValue);
        } else if (categoryValue != null) {
            return activityRepository.findAllByCategoryName(categoryValue);
        } else if (locationValue != null) {
            return activityRepository.findAllByLocationName(locationValue);
        } else {
            return activityRepository.findAll();
        }
    }
    @Override
    @Transactional
    public Optional<Activity> save(String name, String description,String address,String email,Long number, String image_url,String daysAvailable, LocalTime openTime, LocalTime closeTime, Long categoryId, Long companyId, Long locationId){
        ActivityLocation activityLocation = this.activityLocationRepository.findById(locationId).orElseThrow(GlobalException::new);
        ActivityCategory activityCategory = this.activityCategoryRepository.findById(categoryId).orElseThrow(GlobalException::new);
        Company company = this.companyRepository.findById(companyId).orElseThrow(GlobalException::new);

        this.activityRepository.deleteByName(name);
        Activity activity = new Activity(name,description,address,email,number,image_url,daysAvailable,openTime,closeTime,activityCategory,company,activityLocation);
        this.activityRepository.save(activity);

        return Optional.of(activity);

    }
    @Override
    public Optional<Activity> save(ActivityDto activityDto){
        ActivityCategory activityCategory = this.activityCategoryRepository.findById(activityDto.getCategoryId()).orElseThrow(GlobalException::new);
        ActivityLocation activityLocation = this.activityLocationRepository.findById(activityDto.getLocationId()).orElseThrow(GlobalException::new);
        Company company = this.companyRepository.findById(activityDto.getCompanyId()).orElseThrow(GlobalException::new);

        this.activityRepository.deleteByName(activityDto.getName());
        Activity activity = new Activity(activityDto.getName(),activityDto.getDescription(),activityDto.getAddress(),activityDto.getEmail(),activityDto.getNumber(),activityDto.getImageUrl(),activityDto.getDaysAvailable(),activityDto.getOpenTime(),activityDto.getCloseTime(),activityCategory,company,activityLocation);
        this.activityRepository.save(activity);
        return Optional.of(activity);
    }

    @Override
    @Transactional
    public Optional<Activity> edit (Long id, String name, String description, String address, String email, Long number, String image_url,String daysAvailable, LocalTime openTime, LocalTime closeTime,  Long categoryId, Long companyId,Long locationId){
        Activity activity = this.activityRepository.findById(id).orElseThrow(GlobalException::new);

        activity.setName(name);
        activity.setDescription(description);
        activity.setAddress(address);
        activity.setEmail(email);
        activity.setNumber(number);
        activity.setImage_url(image_url);
        activity.setDaysAvailable(daysAvailable);
        activity.setOpenTime(openTime);
        activity.setCloseTime(closeTime);

        ActivityLocation activityLocation = this.activityLocationRepository.findById(locationId).orElseThrow(GlobalException::new);

        activity.setLocation(activityLocation);

        ActivityCategory activityCategory = this.activityCategoryRepository.findById(categoryId).orElseThrow(GlobalException::new);

        activity.setCategory(activityCategory);

        Company company = this.companyRepository.findById(companyId).orElseThrow(GlobalException::new);

        activity.setCompany(company);

        this.activityRepository.save(activity);
        return Optional.of(activity);
    }
    @Override
    public Optional<Activity> edit(Long id,ActivityDto activityDto){
        Activity activity = this.activityRepository.findById(id).orElseThrow(GlobalException::new);

        activity.setName(activityDto.getName());
        activity.setDescription(activityDto.getDescription());
        activity.setImage_url(activityDto.getImageUrl());
        activity.setOpenTime(activityDto.getOpenTime());
        activity.setCloseTime(activityDto.getCloseTime());

        ActivityCategory activityCategory = this.activityCategoryRepository.findById(activityDto.getCategoryId()).orElseThrow(GlobalException::new);
        ActivityLocation activityLocation = this.activityLocationRepository.findById(activityDto.getLocationId()).orElseThrow(GlobalException::new);
        Company company = this.companyRepository.findById(activityDto.getCompanyId()).orElseThrow(GlobalException::new);

        this.activityRepository.save(activity);
        return Optional.of(activity);

    }

    @Override
    public void delete(Long id){
        this.activityRepository.deleteById(id);
    }






}
