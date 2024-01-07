package com.example.hobbysite.service;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.model.ActivityCategory;
import com.example.hobbysite.model.Company;
import com.example.hobbysite.model.dto.ActivityDto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ActivityService {
    Optional<Activity> findById(Long id);
    Optional<Activity> findByName(String name);
    List<Activity> listAll();
    List<Activity> findAllByCategoryName(Optional<String> name);
    List<Activity> filter(Optional<String> category, Optional<String> location);
    Optional<Activity> save (String name, String description, String address, String email, Long number, String image_url,String daysAvailable, LocalTime openTime, LocalTime closeTime, Long categoryId, Long companyId, Long locationId);
    Optional<Activity> save(ActivityDto activityDto);

    Optional<Activity> edit (Long id, String name, String description, String address, String email, Long number, String image_url,String daysAvailable, LocalTime openTime, LocalTime closeTime,  Long categoryId, Long companyId,Long locationId);

    Optional<Activity> edit(Long id,ActivityDto activityDto);
    void delete(Long id);
}
