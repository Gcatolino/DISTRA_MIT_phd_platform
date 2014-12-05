package it.unisa.dottorato.bean;

import java.io.Serializable;

public class Class_event implements Serializable {
    
    private int FK_Class;
    private int FK_Event;

    public int getFK_Class() {
        return FK_Class;
    }

    public void setFK_Class(int FK_Class) {
        this.FK_Class = FK_Class;
    }

    public int getFK_Event() {
        return FK_Event;
    }

    public void setFK_Event(int FK_Event) {
        this.FK_Event = FK_Event;
    }
   
}
