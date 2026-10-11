
package com.plotsphere.plotspheredocumentservice.controller;

import com.plotsphere.plotspheredocumentservice.entity.LandDocument;
import com.plotsphere.plotspheredocumentservice.service.LandDocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/documents")
public class LandDocumentController {

    private final LandDocumentService landDocumentService;

    public LandDocumentController(
            LandDocumentService landDocumentService) {
        this.landDocumentService = landDocumentService;
    }

    @PostMapping
    public ResponseEntity<LandDocument> uploadDocument(
            @RequestBody LandDocument document) {

        LandDocument savedDocument =
                landDocumentService.uploadDocument(document);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedDocument);
    }

    @GetMapping
    public ResponseEntity<List<LandDocument>> getAllDocuments() {
        return ResponseEntity.ok(
                landDocumentService.getAllDocuments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LandDocument> getDocumentById(
            @PathVariable String id) {

        Optional<LandDocument> document =
                landDocumentService.getDocumentById(id);

        return document.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/land/{landId}")
    public ResponseEntity<List<LandDocument>> getDocumentsByLandId(
            @PathVariable String landId) {

        return ResponseEntity.ok(
                landDocumentService.getDocumentsByLandId(landId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(
            @PathVariable String id) {

        if (!landDocumentService.getDocumentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        landDocumentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}