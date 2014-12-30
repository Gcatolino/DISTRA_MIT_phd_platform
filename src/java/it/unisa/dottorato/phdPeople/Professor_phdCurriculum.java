package it.unisa.dottorato.phdPeople;

import java.io.Serializable;

/**
 *
 * @author Elisa D'Eugenio
 */
public class Professor_phdCurriculum implements Serializable{
    
    private String FK_Professor;
    private String FK_PhdCurriculum;

    public String getFK_Professor() {
        return FK_Professor;
    }

    public void setFK_Professor(String FK_Professor) {
        this.FK_Professor = FK_Professor;
    }

    public String getFK_PhdCurriculum() {
        return FK_PhdCurriculum;
    }

    public void setFK_PhdCurriculum(String FK_PhdCurriculum) {
        this.FK_PhdCurriculum = FK_PhdCurriculum;
    }


}
