package com.example.hobbysite.model.dto;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Data
public class ActivityDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String email;
    private Long number;
    private String imageUrl;
    private String DaysAvailable;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Long categoryId;
    private Long companyId;
    private Long locationId;

    public ActivityDto() {
    }

    public ActivityDto(Long id, String name, String description, String address, String email, Long number, String imageUrl, String daysAvailable, LocalTime openTime, LocalTime closeTime, Long categoryId, Long companyId, Long locationId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.email = email;
        this.number = number;
        this.imageUrl = imageUrl;
        DaysAvailable = daysAvailable;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.categoryId = categoryId;
        this.companyId = companyId;
        this.locationId = locationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDaysAvailable() {
        return DaysAvailable;
    }

    public void setDaysAvailable(String daysAvailable) {
        DaysAvailable = daysAvailable;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
