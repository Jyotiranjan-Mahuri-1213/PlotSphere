
package com.plotsphere.plotspheredocumentservice.repository;

import com.plotsphere.plotspheredocumentservice.entity.LandDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LandDocumentRepository
        extends MongoRepository<LandDocument, String> {

    List<LandDocument> findByLandId(String landId);

}