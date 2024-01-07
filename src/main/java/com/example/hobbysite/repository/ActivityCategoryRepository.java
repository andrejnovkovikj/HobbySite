package com.example.hobbysite.repository;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.model.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory,Long>{
        ActivityCategory findByName(String name);
}
