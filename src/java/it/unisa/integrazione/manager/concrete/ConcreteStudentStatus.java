/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.integrazione.manager.concrete;

import it.unisa.integrazione.manager.interfaces.*;

/**
 *
 * @author albamansillacoca
 */
public class ConcreteStudentStatus implements StudentStatus{
    
    private Student IDstudentStatus;
    private String description;
    
    public ConcreteStudentStatus(Student IDstudentStatus, String description){
        this.IDstudentStatus=IDstudentStatus;
        this.description=description;
    }
    
    public ConcreteStudentStatus(){
    }

    @Override
    public Student getPrimaryKey() {
       return this.IDstudentStatus;
    }
    
    @Override
    public void setPrimaryKey(Student primaryKey) { 
        this.IDstudentStatus=primaryKey;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the IDstudentStatus
     */
    public Student getIDstudentStatus() {
        return IDstudentStatus;
    }

    /**
     * @param IDstudentStatus the IDstudentStatus to set
     */
    public void setIDstudentStatus(Student IDstudentStatus) {
        this.IDstudentStatus = IDstudentStatus;
    }

    public String toString(){
        return ("IDstudentStatus: \n"+IDstudentStatus+"Description: \n"+description);
    }
}
