package it.unisa.dottorato.bean;

import java.io.Serializable;

public class Class implements Serializable{
    
    private int FK_PhdCycle;
    private int FK_PhdCurriculum;

    public int getFK_PhdCycle() {
        return FK_PhdCycle;
    }

    public void setFK_PhdCycle(int FK_PhdCycle) {
        this.FK_PhdCycle = FK_PhdCycle;
    }

    public int getFK_PhdCurriculum() {
        return FK_PhdCurriculum;
    }

    public void setFK_PhdCurriculum(int FK_PhdCurriculum) {
        this.FK_PhdCurriculum = FK_PhdCurriculum;
    }
    
}
