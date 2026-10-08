package com.plotsphere.plotspherelandservice.repository;

import com.plotsphere.plotspherelandservice.entity.Land;
import com.plotsphere.plotspherelandservice.entity.Land;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LandRepository extends JpaRepository<Land, Long> {

    List<Land> findByOwnerId(Long ownerId);

    boolean existsBySurveyNumber(String surveyNumber);
}