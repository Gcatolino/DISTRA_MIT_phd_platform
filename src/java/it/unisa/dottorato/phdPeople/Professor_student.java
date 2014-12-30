package it.unisa.dottorato.phdPeople;

import java.io.Serializable;

/**
 *
 * @author Elisa D'Eugenio
 */
public class Professor_student implements Serializable{
    
    private String FK_Professor;
    private String FK_Student;

    public String getFK_Professor() {
        return FK_Professor;
    }

    public void setFK_Professor(String FK_Professor) {
        this.FK_Professor = FK_Professor;
    }

    public String getFK_Student() {
        return FK_Student;
    }

    public void setFK_Student(String FK_Student) {
        this.FK_Student = FK_Student;
    }


    
}
