package com.etlsolutions.jlrmena.tests.excel;

import java.util.*;

public class DataRow {
        
    private String id;
    private String studentName;
    private String courseName;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.studentName);
        hash = 89 * hash + Objects.hashCode(this.emailAddress);
        hash = 89 * hash + Objects.hashCode(this.supervisorName);
        hash = 89 * hash + Objects.hashCode(this.secondMarkerName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final DataRow other = (DataRow) obj;
        
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        
        if (!Objects.equals(this.studentName, other.studentName)) {
            return false;
        }
        
        if (!Objects.equals(this.courseName, other.courseName)) {
            return false;
        }
        
        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }
                
        if (!Objects.equals(this.supervisorName, other.supervisorName)) {
            return false;
        }
        
        return Objects.equals(this.secondMarkerName, other.secondMarkerName);
    }    
}
