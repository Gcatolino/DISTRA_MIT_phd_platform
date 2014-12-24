/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdClass;

import java.io.Serializable;

/**
 *
 * @author Elisa
 */
public class Student_phdClass implements Serializable{
    
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
