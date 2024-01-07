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

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    private final ActivityService activityService;
    private final ActivityCategoryService activityCategoryService;
    private final ActivityLocationService activityLocationService;
    private final CompanyService companyService;

    public HomeController(ActivityService activityService, ActivityCategoryService activityCategoryService, ActivityLocationService activityLocationService, CompanyService companyService) {
        this.activityService = activityService;
        this.activityCategoryService = activityCategoryService;
        this.activityLocationService = activityLocationService;
        this.companyService = companyService;
    }


    @GetMapping(path = {"/","/home"})
    public String home (){
        return "home.html";
    }
}
