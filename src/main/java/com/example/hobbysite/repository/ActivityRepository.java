package com.example.hobbysite.repository;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.model.ActivityCategory;
import com.example.hobbysite.model.ActivityLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long>{
    Optional<Activity> findByName(String name);
    List<Activity> findAllByCategoryName(String category);
    List<Activity> findAllByCategoryName(Optional<String> category);
    List<Activity> findAllByLocationName(String location);
    List<Activity> findAllByLocationName(Optional<String> location);
    List<Activity> findByCategoryNameAndLocationName(String category, String location);
    List<Activity> findByCategoryNameAndLocationName(Optional<String> category, Optional<String> location);
    void deleteByName(String name);
}
