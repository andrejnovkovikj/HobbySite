package com.example.hobbysite.repository;
import com.example.hobbysite.model.ActivityLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityLocationRepository extends  JpaRepository<ActivityLocation,Long>{
    Optional<ActivityLocation> findById(Long id);
    ActivityLocation findByName(String name);
}
