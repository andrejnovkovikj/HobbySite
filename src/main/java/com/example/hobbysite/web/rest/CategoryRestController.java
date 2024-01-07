package com.example.hobbysite.web.rest;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.model.ActivityCategory;
import com.example.hobbysite.service.ActivityCategoryService;
import com.example.hobbysite.service.ActivityLocationService;
import com.example.hobbysite.service.ActivityService;
import com.example.hobbysite.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final ActivityService activityService;
    private final ActivityCategoryService activityCategoryService;
    private final ActivityLocationService activityLocationService;
    private final CompanyService companyService;

    public CategoryRestController(ActivityService activityService, ActivityCategoryService activityCategoryService, ActivityLocationService activityLocationService, CompanyService companyService) {
        this.activityService = activityService;
        this.activityCategoryService = activityCategoryService;
        this.activityLocationService = activityLocationService;
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAllCategories(@RequestParam(required = false) String error) {
        List<ActivityCategory> activityCategories = this.activityCategoryService.listAll();

        if (error != null && !error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(activityCategories);
        } else {
            return ResponseEntity.ok(activityCategories);
        }
    }
    @GetMapping("/{category}")
    public ResponseEntity<List<Activity>> getActivitiesByCategory(@PathVariable String category) {
        List<Activity> activities = this.activityService.findAllByCategoryName(Optional.of(category));

        if (activities.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(activities);
        }
    }
}
