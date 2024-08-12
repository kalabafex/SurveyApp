package com.example.surveys.model;

import com.opencsv.bean.CsvBindByName;

public class Survey {
    @CsvBindByName(column = "Survey Id")
    private String surveyId;

    @CsvBindByName(column = "Name")
    private String surveyName;

    @CsvBindByName(column = "Expected completes")
    private int expectedCompletes;

    @CsvBindByName(column = "Completion points")
    private int completionPoints;

    @CsvBindByName(column = "Filtered points")
    private int filteredPoints;
    public Survey() {}
    // Constructor with all fields for testing
    public Survey(String surveyId, String surveyName, int expectedCompletes, int completionPoints, int filteredPoints) {
        this.surveyId = surveyId;
        this.surveyName = surveyName;
        this.expectedCompletes = expectedCompletes;
        this.completionPoints = completionPoints;
        this.filteredPoints = filteredPoints;
    }
    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public int getExpectedCompletes() {
        return expectedCompletes;
    }

    public void setExpectedCompletes(int expectedCompletes) {
        this.expectedCompletes = expectedCompletes;
    }

    public int getCompletionPoints() {
        return completionPoints;
    }

    public void setCompletionPoints(int completionPoints) {
        this.completionPoints = completionPoints;
    }

    public int getFilteredPoints() {
        return filteredPoints;
    }

    public void setFilteredPoints(int filteredPoints) {
        this.filteredPoints = filteredPoints;
    }
}
