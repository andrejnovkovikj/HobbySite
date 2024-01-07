package com.example.hobbysite.web.controller;

import com.example.hobbysite.model.Activity;
import com.example.hobbysite.service.ActivityCategoryService;
import com.example.hobbysite.service.ActivityLocationService;
import com.example.hobbysite.service.ActivityService;
import com.example.hobbysite.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityCategoryService activityCategoryService;
    private final ActivityLocationService activityLocationService;
    private final CompanyService companyService;

    public ActivityController(ActivityService activityService, ActivityCategoryService activityCategoryService, ActivityLocationService activityLocationService, CompanyService companyService) {
        this.activityService = activityService;
        this.activityCategoryService = activityCategoryService;
        this.activityLocationService = activityLocationService;
        this.companyService = companyService;
    }

    @GetMapping(path = {"/activities"})
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Activity> activity = this.activityService.listAll();
        model.addAttribute("activity", activity);
        model.addAttribute("bodyContent", "activity");
        return "activityFiltered.html";
    }


    @GetMapping(path={"/activity/{id}"})
    public String showProduct(@PathVariable Long id, Model model){
        Optional<Activity> activity = this.activityService.findById(id);
        model.addAttribute("activity",activity);
        return "singleActivity.html";
    }

}