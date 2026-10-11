
package com.plotsphere.plotspheredocumentservice.service;

import com.plotsphere.plotspheredocumentservice.entity.LandDocument;
import com.plotsphere.plotspheredocumentservice.repository.LandDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandDocumentService {

    private final LandDocumentRepository landDocumentRepository;

    public LandDocumentService(
            LandDocumentRepository landDocumentRepository) {
        this.landDocumentRepository = landDocumentRepository;
    }

    public LandDocument uploadDocument(LandDocument document) {
        return landDocumentRepository.save(document);
    }

    public List<LandDocument> getAllDocuments() {
        return landDocumentRepository.findAll();
    }

    public Optional<LandDocument> getDocumentById(String id) {
        return landDocumentRepository.findById(id);
    }

    public List<LandDocument> getDocumentsByLandId(String landId) {
        return landDocumentRepository.findByLandId(landId);
    }

    public void deleteDocument(String id) {
        landDocumentRepository.deleteById(id);
    }
}