package com.plotsphere.plotsphere_auth_service.dto;

public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String mobileNo;
    private String role;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String email,
                        String mobileNo, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getRole() {
        return role;
    }
}