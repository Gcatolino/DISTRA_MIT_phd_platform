package it.unisa.dottorato.bean;

import java.io.Serializable;

public class Event_professor implements Serializable{
    
    private int FK_Event;
    private int FK_Professor;

    public int getFK_Event() {
        return FK_Event;
    }

    public void setFK_Event(int FK_Event) {
        this.FK_Event = FK_Event;
    }

    public int getFK_Professor() {
        return FK_Professor;
    }

    public void setFK_Professor(int FK_Professor) {
        this.FK_Professor = FK_Professor;
    }
    
}
