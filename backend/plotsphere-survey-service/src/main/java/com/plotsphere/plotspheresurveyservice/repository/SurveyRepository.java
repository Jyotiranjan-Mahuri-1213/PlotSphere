package com.plotsphere.plotspheresurveyservice.repository;

import com.plotsphere.plotspheresurveyservice.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {


    List<Survey> findByLandId(Long landId);

    List<Survey> findBySurveyorId(Long surveyorId);

    List<Survey> findByStatus(String status);

}
