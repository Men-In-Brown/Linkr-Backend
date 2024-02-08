package com.nighthawk.spring_portfolio.mvc.linkr;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String position;
    private String email;
    private Long companyId;

    public EmployeeDTO() {
        // Default constructor
    }

    public EmployeeDTO(Long id, String name, String position, String email, Long companyId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.email = email;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}