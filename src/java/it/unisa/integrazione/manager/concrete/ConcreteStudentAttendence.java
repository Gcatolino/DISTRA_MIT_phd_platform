/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.manager.concrete;

import it.unisa.integrazione.manager.interfaces.*;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author katiasolomita
 */
public class ConcreteStudentAttendence implements StudentAttendence{
    
    private int SerialNum;
    private GregorianCalendar Date;
    private String FK_Student;
    
    public ConcreteStudentAttendence(){
    }
    
    public ConcreteStudentAttendence(int SerialNum, GregorianCalendar Date){
    this.SerialNum = SerialNum;
    this.Date = Date;
    }

    
    @Override
    public int getPrimaryKey() {
        return SerialNum;
                }

    /**
     *
     * @param primaryKey
     */
    @Override
    public void setPrimaryKey(int primaryKey) {
    this.SerialNum = primaryKey;
    }

    public GregorianCalendar getDate() {
        return Date;
    }

    public void setDate(GregorianCalendar Date) {
        this.Date = Date;
    }

    public String getFKStudent() {
        return FK_Student;
    }

    public void setFKStudent(String FK_Student) {
        this.FK_Student = FK_Student;
    }
    
    
}
