package com.plotsphere.plotspheremutationservice.repository;

import com.plotsphere.plotspheremutationservice.entity.Mutation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MutationRepository extends JpaRepository<Mutation, Long> {

    List<Mutation> findByApplicantId(Long applicantId);

    List<Mutation> findByStatus(String status);
}