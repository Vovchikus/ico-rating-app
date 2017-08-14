package com.project.rating.model;

import org.springframework.data.annotation.Id;

public class Offering {
    @Id
    private String id;

    private Company company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
