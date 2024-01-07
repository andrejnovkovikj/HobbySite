package com.example.hobbysite.model;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ACTIVITY")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NUMBER")
    private Long number;

    @Column(name = "DAYSAVAILABLE")
    private String daysAvailable;

    @Column(name = "IMAGE_URL")
    private String image_url;

    @Column(name = "OPEN_TIME")
    private LocalTime openTime;

    @Column(name = "CLOSE_TIME")
    private LocalTime closeTime;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private ActivityCategory category;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private ActivityLocation location;

    public Activity(Long id, String name, String description, String address, String email, Long number, String daysAvailable, String image_url, LocalTime openTime, LocalTime closeTime, ActivityCategory category, Company company, ActivityLocation location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.email = email;
        this.number = number;
        this.daysAvailable = daysAvailable;
        this.image_url = image_url;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.category = category;
        this.company = company;
        this.location = location;
    }

    public Activity(String name, String description, String address, String email, Long number, String daysAvailable, String image_url, LocalTime openTime, LocalTime closeTime, ActivityCategory category, Company company, ActivityLocation location) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.email = email;
        this.number = number;
        this.daysAvailable = daysAvailable;
        this.image_url = image_url;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.category = category;
        this.company = company;
        this.location = location;
    }

    public Activity () {}

    public String getDaysAvailable() {
        return daysAvailable;
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

    public void setDaysAvailable(String daysAvailable) {
        this.daysAvailable = daysAvailable;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public ActivityCategory getCategory() {
        return category;
    }

    public void setCategory(ActivityCategory category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ActivityLocation getLocation() {
        return location;
    }

    public void setLocation(ActivityLocation location) {
        this.location = location;
    }
}
