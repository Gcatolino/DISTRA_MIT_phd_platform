package it.unisa.dottorato.phdCurriculum;

import java.io.Serializable;

public class PhdCurriculum implements Serializable{
    
    private int idPhdCurriculum;
    private String name;
    private String description;
    private int FK_Professor;

    public int getIdPhdCurriculum() {
        return idPhdCurriculum;
    }

    public void setIdPhdCurriculum(int idPhdCurriculum) {
        this.idPhdCurriculum = idPhdCurriculum;
    }

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

    public int getFK_Professor() {
        return FK_Professor;
    }

    public void setFK_Professor(int FK_Professor) {
        this.FK_Professor = FK_Professor;
    }   
    
}
