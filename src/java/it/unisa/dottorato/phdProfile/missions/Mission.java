package it.unisa.dottorato.phdProfile.missions;

import java.io.Serializable;
import java.util.Date;

public class Mission implements Serializable{
    
    private int idMission;
    private String place;
    private String description;
    private Date startDate;
    private Date endDate;
    private String FK_Student;

    public int getIdMission() {
        return idMission;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFK_Student() {
        return FK_Student;
    }

    public void setFK_Student(String FK_Student) {
        this.FK_Student = FK_Student;
    }  
    
}
