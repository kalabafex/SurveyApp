package com.example.surveys.model;

import com.opencsv.bean.CsvBindByName;

public class Status {
    @CsvBindByName(column = "Status Id")
    private int statusId;

    @CsvBindByName(column = "Name")
    private String statusDescription;
    public Status() {}
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
