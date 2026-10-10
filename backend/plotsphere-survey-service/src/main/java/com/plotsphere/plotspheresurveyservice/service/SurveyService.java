package com.plotsphere.plotspheresurveyservice.service;

import com.plotsphere.plotspheresurveyservice.entity.Survey;
import com.plotsphere.plotspheresurveyservice.repository.SurveyRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    // Create a new survey
    public Survey createSurvey(Survey survey) {
        if (survey.getLandId() == null) {
            throw new IllegalArgumentException("Land ID is required.");
        }

        survey.setId(null);
        survey.setStatus("ASSIGNED");

        return surveyRepository.save(survey);
    }

    // Get all surveys
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    // Get survey by ID
    public Survey getSurveyById(Long id) {
        return surveyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Survey not found with ID: " + id));
    }

    // Get surveys by land ID
    public List<Survey> getSurveysByLandId(Long landId) {
        return surveyRepository.findByLandId(landId);
    }

    // Get surveys by surveyor ID
    public List<Survey> getSurveysBySurveyorId(Long surveyorId) {
        return surveyRepository.findBySurveyorId(surveyorId);
    }

    // Get surveys by status
    public List<Survey> getSurveysByStatus(String status) {
        return surveyRepository.findByStatus(status);
    }

    // Assign a surveyor
    public Survey assignSurveyor(Long id, Long surveyorId) {
        if (surveyorId == null) {
            throw new IllegalArgumentException("Surveyor ID is required.");
        }

        Survey survey = getSurveyById(id);
        survey.setSurveyorId(surveyorId);
        survey.setStatus("ASSIGNED");

        return surveyRepository.save(survey);
    }

    // Complete a survey
    public Survey completeSurvey(Long id, Survey surveyDetails) {
        Survey survey = getSurveyById(id);

        survey.setSurveyDate(surveyDetails.getSurveyDate());
        survey.setSurveyType(surveyDetails.getSurveyType());
        survey.setFindings(surveyDetails.getFindings());
        survey.setAreaVerified(surveyDetails.getAreaVerified());
        survey.setRemarks(surveyDetails.getRemarks());
        survey.setStatus("COMPLETED");

        return surveyRepository.save(survey);
    }


}
