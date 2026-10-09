package com.plotsphere.plotspheremutationservice.controller;

import com.plotsphere.plotspheremutationservice.entity.Mutation;
import com.plotsphere.plotspheremutationservice.service.MutationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
@RestController
@RequestMapping("/api/mutations")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)
public class MutationController {

    private final MutationService mutationService;

    public MutationController(MutationService mutationService) {
        this.mutationService = mutationService;
    }

    @PostMapping
    public ResponseEntity<Mutation> submitMutation(
            @RequestBody Mutation mutation) {

        return ResponseEntity.ok(
                mutationService.submitMutation(mutation)
        );
    }

    @GetMapping
    public ResponseEntity<List<Mutation>> getAllMutations() {

        return ResponseEntity.ok(
                mutationService.getAllMutations()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mutation> getMutationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                mutationService.getMutationById(id)
        );
    }

    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<Mutation>> getByApplicant(
            @PathVariable Long applicantId) {

        return ResponseEntity.ok(
                mutationService.getMutationsByApplicant(applicantId)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Mutation>> getByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                mutationService.getMutationsByStatus(status)
        );
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Mutation> approveMutation(
            @PathVariable Long id,
            @RequestParam String remarks) {

        return ResponseEntity.ok(
                mutationService.approveMutation(id, remarks)
        );
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Mutation> rejectMutation(
            @PathVariable Long id,
            @RequestParam String remarks) {

        return ResponseEntity.ok(
                mutationService.rejectMutation(id, remarks)
        );
    }
}