package it.unisa.dottorato.phdClass;

import java.io.Serializable;

/**
 *
 * @author Elisa D'Eugenio
 */
public class PhdClass implements Serializable{
    
    private int idClass;
    private int FK_PhdCycle;
    private String FK_PhdCurriculum;

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idPhdClass) {
        this.idClass = idPhdClass;
    }

    public int getFK_PhdCycle() {
        return FK_PhdCycle;
    }

    public void setFK_PhdCycle(int FK_PhdCycle) {
        this.FK_PhdCycle = FK_PhdCycle;
    }

    public String getFK_PhdCurriculum() {
        return FK_PhdCurriculum;
    }

    public void setFK_PhdCurriculum(String FK_PhdCurriculum) {
        this.FK_PhdCurriculum = FK_PhdCurriculum;
    }
    
}
