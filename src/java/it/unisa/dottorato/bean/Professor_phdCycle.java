package it.unisa.dottorato.bean;

import java.io.Serializable;

public class Professor_phdCycle implements Serializable{
    
    private int FK_Professor;
    private int FK_PhdCycle;

    public int getFK_Professor() {
        return FK_Professor;
    }

    public void setFK_Professor(int FK_Professor) {
        this.FK_Professor = FK_Professor;
    }

    public int getFK_PhdCycle() {
        return FK_PhdCycle;
    }

    public void setFK_PhdCycle(int FK_PhdCycle) {
        this.FK_PhdCycle = FK_PhdCycle;
    }
    
}
