package com.etlsolutions.jlrmena.tests.excel;

import java.util.List;

public class DataRow {
        
    private String id;
    private String studentName;
    private String emailAddress;
    private String supervisorName;
    private String secondMarkerName;


    public DataRow() {
    }

    public DataRow(String id, String studentName, String emailAddress, String supervisorName, String secondMarkerName) {
        this.id = id;
        this.studentName = studentName;
        this.emailAddress = emailAddress;
        this.supervisorName = supervisorName;
        this.secondMarkerName = secondMarkerName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSecondMarkerName() {
        return secondMarkerName;
    }

    public void setSecondMarkerName(String secondMarkerName) {
        this.secondMarkerName = secondMarkerName;
    }



}
