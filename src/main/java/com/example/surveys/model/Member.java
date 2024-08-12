package com.example.surveys.model;

import com.opencsv.bean.CsvBindByName;

    public class Member {
    @CsvBindByName(column = "Member Id")
    private String memberId;

    @CsvBindByName(column = "Full name")
    private String name;

    @CsvBindByName(column = "E-mail address")
    private String email;

    @CsvBindByName(column = "Is Active")
    private boolean active;

    public Member() {}
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}