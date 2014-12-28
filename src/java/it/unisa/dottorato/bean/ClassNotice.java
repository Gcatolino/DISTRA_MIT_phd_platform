package it.unisa.dottorato.bean;

import java.io.Serializable;

/**
 *
 * @author Elisa D'Eugenio
 */
public class ClassNotice implements Serializable{
    
    private int FK_Class;
    private int FK_Notice;

    public int getFK_Class() {
        return FK_Class;
    }

    public void setFK_Class(int FK_Class) {
        this.FK_Class = FK_Class;
    }

    public int getFK_Notice() {
        return FK_Notice;
    }

    public void setFK_Notice(int FK_Notice) {
        this.FK_Notice = FK_Notice;
    }
    
}
