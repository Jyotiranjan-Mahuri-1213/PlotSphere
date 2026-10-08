package com.plotsphere.plotspherelandservice.service;

import com.plotsphere.plotspherelandservice.entity.Land;
import com.plotsphere.plotspherelandservice.repository.LandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandService {

    private final LandRepository landRepository;

    public LandService(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    public Land addLand(Land land) {

        if (landRepository.existsBySurveyNumber(land.getSurveyNumber())) {
            throw new RuntimeException("Survey number already exists");
        }

        if (land.getStatus() == null || land.getStatus().isBlank()) {
            land.setStatus("ACTIVE");
        }

        return landRepository.save(land);
    }

    public List<Land> getAllLands() {
        return landRepository.findAll();
    }

    public Land getLandById(Long id) {

        return landRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Land not found with id: " + id));
    }

    public List<Land> getLandsByOwner(Long ownerId) {
        return landRepository.findByOwnerId(ownerId);
    }

    public Land updateLand(Long id, Land updatedLand) {

        Land existingLand = getLandById(id);

        existingLand.setSurveyNumber(updatedLand.getSurveyNumber());
        existingLand.setLocation(updatedLand.getLocation());
        existingLand.setDistrict(updatedLand.getDistrict());
        existingLand.setTehsil(updatedLand.getTehsil());
        existingLand.setVillage(updatedLand.getVillage());
        existingLand.setArea(updatedLand.getArea());
        existingLand.setLandType(updatedLand.getLandType());
        existingLand.setOwnerId(updatedLand.getOwnerId());
        existingLand.setStatus(updatedLand.getStatus());

        return landRepository.save(existingLand);
    }

    public void deleteLand(Long id) {

        Land land = getLandById(id);

        landRepository.delete(land);
    }
}