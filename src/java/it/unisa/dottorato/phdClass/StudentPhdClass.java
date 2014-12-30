package it.unisa.dottorato.phdClass;

import java.io.Serializable;

/**
 *
 * @author Elisa D'Eugenio
 */
public class StudentPhdClass implements Serializable{
    
    private String FK_Student;
    private int FK_PhdClass;

    public String getFK_Student() {
        return FK_Student;
    }

    public void setFK_Student(String FK_Student) {
        this.FK_Student = FK_Student;
    }

    public int getFK_PhdClass() {
        return FK_PhdClass;
    }

    public void setFK_PhdClass(int FK_PhdClass) {
        this.FK_PhdClass = FK_PhdClass;
    }


}
