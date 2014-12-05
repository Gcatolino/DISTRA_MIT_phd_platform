package it.unisa.dottorato.phdCycle;

import java.io.Serializable;

public class PhdCycle implements Serializable {
    
    private int idPhdCycle;
    private String description;
    private int year;
    private int FK_Professor;

    public int getIdPhdCycle() {
        return idPhdCycle;
    }

    public void setIdPhdCycle(int idPhdCycle) {
        this.idPhdCycle = idPhdCycle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFK_Professor() {
        return FK_Professor;
    }

    public void setFK_Professor(int FK_Professor) {
        this.FK_Professor = FK_Professor;
    }
  
}
