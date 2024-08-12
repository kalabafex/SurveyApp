package com.example.surveys.model;

public class SurveyStatistics {

    private String surveyId;
    private String surveyName;
    private long completedCount;
    private long filteredCount;
    private long rejectedCount;
    private double averageLength;

    public SurveyStatistics(String surveyId, String surveyName, long completedCount, long filteredCount, long rejectedCount, double averageLength) {
        this.surveyId = surveyId;
        this.surveyName = surveyName;
        this.completedCount = completedCount;
        this.filteredCount = filteredCount;
        this.rejectedCount = rejectedCount;
        this.averageLength = averageLength;
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

    public long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(long completedCount) {
        this.completedCount = completedCount;
    }

    public long getFilteredCount() {
        return filteredCount;
    }

    public void setFilteredCount(long filteredCount) {
        this.filteredCount = filteredCount;
    }

    public long getRejectedCount() {
        return rejectedCount;
    }

    public void setRejectedCount(long rejectedCount) {
        this.rejectedCount = rejectedCount;
    }

    public double getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }
}