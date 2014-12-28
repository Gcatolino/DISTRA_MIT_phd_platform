package it.unisa.dottorato.phdCurriculum;

import java.io.Serializable;

/**
 *
 * @author Elisa D'Eugenio
 */
public class PhdCurriculum implements Serializable {

    private String name;
    private String description;
    private String FK_Professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFK_Professor() {
        return FK_Professor;
    }

    public void setFK_Professor(String FK_Professor) {
        this.FK_Professor = FK_Professor;
    }

}
