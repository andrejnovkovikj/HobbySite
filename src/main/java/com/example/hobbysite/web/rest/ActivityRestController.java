package com.example.hobbysite.web.rest;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.model.dto.ActivityDto;
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
@RequestMapping("/api/activities")
public class ActivityRestController {
    private final ActivityService activityService;
    private final ActivityCategoryService activityCategoryService;
    private final ActivityLocationService activityLocationService;
    private final CompanyService companyService;

    public ActivityRestController(ActivityService activityService, ActivityCategoryService activityCategoryService, ActivityLocationService activityLocationService, CompanyService companyService) {
        this.activityService = activityService;
        this.activityCategoryService = activityCategoryService;
        this.activityLocationService = activityLocationService;
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities(@RequestParam(required = false) String error) {
        List<Activity> activities = this.activityService.listAll();

        if (error != null && !error.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(activities);
        } else {
            return ResponseEntity.ok(activities);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Optional<Activity> activity = this.activityService.findById(id);

        return activity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}


