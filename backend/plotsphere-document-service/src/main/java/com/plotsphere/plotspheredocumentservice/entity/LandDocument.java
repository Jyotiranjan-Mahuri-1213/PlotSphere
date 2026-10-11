
package com.plotsphere.plotspheredocumentservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "land_documents")
public class LandDocument {

    @Id
    private String id;

    private String landId;
    private String documentName;
    private String documentType;
    private String fileUrl;

    public LandDocument() {
    }

    public LandDocument(String landId, String documentName,
                        String documentType, String fileUrl) {
        this.landId = landId;
        this.documentName = documentName;
        this.documentType = documentType;
        this.fileUrl = fileUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandId() {
        return landId;
    }

    public void setLandId(String landId) {
        this.landId = landId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}