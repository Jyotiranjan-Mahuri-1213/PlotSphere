package com.plotsphere.plotspheresurveyservice.controller;

import com.plotsphere.plotspheresurveyservice.entity.Survey;
import com.plotsphere.plotspheresurveyservice.service.SurveyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    // Create survey
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(surveyService.createSurvey(survey));
    }

    // Get all surveys
    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }

    // Get survey by ID
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        return ResponseEntity.ok(surveyService.getSurveyById(id));
    }

    // Get surveys by land ID
    @GetMapping("/land/{landId}")
    public ResponseEntity<List<Survey>> getSurveysByLandId(
            @PathVariable Long landId) {
        return ResponseEntity.ok(
                surveyService.getSurveysByLandId(landId));
    }

    // Get surveys by surveyor ID
    @GetMapping("/surveyor/{surveyorId}")
    public ResponseEntity<List<Survey>> getSurveysBySurveyorId(
            @PathVariable Long surveyorId) {
        return ResponseEntity.ok(
                surveyService.getSurveysBySurveyorId(surveyorId));
    }

    // Get surveys by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Survey>> getSurveysByStatus(
            @PathVariable String status) {
        return ResponseEntity.ok(
                surveyService.getSurveysByStatus(status.toUpperCase()));
    }

    // Assign surveyor
    @PutMapping("/{id}/assign")
    public ResponseEntity<Survey> assignSurveyor(
            @PathVariable Long id,
            @RequestBody Map<String, Long> request) {

        Long surveyorId = request.get("surveyorId");

        return ResponseEntity.ok(
                surveyService.assignSurveyor(id, surveyorId));
    }

    // Complete survey
    @PutMapping("/{id}/complete")
    public ResponseEntity<Survey> completeSurvey(
            @PathVariable Long id,
            @RequestBody Survey surveyDetails) {

        return ResponseEntity.ok(
                surveyService.completeSurvey(id, surveyDetails));
    }


}
