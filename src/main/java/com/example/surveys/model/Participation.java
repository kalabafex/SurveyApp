package com.example.surveys.model;

import com.opencsv.bean.CsvBindByName;

public class Participation {
    @CsvBindByName(column = "Member Id")
    private String memberId;

    @CsvBindByName(column = "Survey Id")
    private String surveyId;

    @CsvBindByName(column = "Status")
    private int statusId;

    @CsvBindByName(column = "Length")
    private int length;
    private int points;  // This field is calculated, not read from CSV
    public Participation() {}
    // Constructor with all fields for testing
    public Participation(String memberId, String surveyId, int statusId, int length) {
        this.memberId = memberId;
        this.surveyId = surveyId;
        this.statusId = statusId;
        this.length = length;
    }
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}
