package it.unisa.dottorato.bean;

import java.io.Serializable;
import java.util.Date;

public class Lesson implements Serializable{
    
    private int idLesson;
    private String name;
    private String speaker;
    private Date date;
    private Date startTime;
    private Date endTime;
    private String place;
    private int FK_Event;

    public int getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(int idLesson) {
        this.idLesson = idLesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getFK_Event() {
        return FK_Event;
    }

    public void setFK_Event(int FK_Event) {
        this.FK_Event = FK_Event;
    }
    
}
