package com.plotsphere.plotspheremutationservice.service;

import com.plotsphere.plotspheremutationservice.entity.Mutation;
import com.plotsphere.plotspheremutationservice.repository.MutationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutationService {

    private final MutationRepository mutationRepository;

    public MutationService(MutationRepository mutationRepository) {
        this.mutationRepository = mutationRepository;
    }

    public Mutation submitMutation(Mutation mutation) {

        if (mutation.getStatus() == null ||
                mutation.getStatus().isBlank()) {

            mutation.setStatus("PENDING");
        }

        return mutationRepository.save(mutation);
    }

    public List<Mutation> getAllMutations() {
        return mutationRepository.findAll();
    }

    public Mutation getMutationById(Long id) {

        return mutationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Mutation not found with id: " + id
                        ));
    }

    public List<Mutation> getMutationsByApplicant(Long applicantId) {
        return mutationRepository.findByApplicantId(applicantId);
    }

    public List<Mutation> getMutationsByStatus(String status) {
        return mutationRepository.findByStatus(status);
    }

    public Mutation approveMutation(Long id, String remarks) {

        Mutation mutation = getMutationById(id);

        mutation.setStatus("APPROVED");
        mutation.setRemarks(remarks);

        return mutationRepository.save(mutation);
    }

    public Mutation rejectMutation(Long id, String remarks) {

        Mutation mutation = getMutationById(id);

        mutation.setStatus("REJECTED");
        mutation.setRemarks(remarks);

        return mutationRepository.save(mutation);
    }
}