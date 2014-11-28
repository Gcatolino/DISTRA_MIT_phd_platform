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
public class ConcreteDepartment implements Department{

    private int idDepartment;
    private String description;
    
    public ConcreteDepartment (int idDepartment, String description){
        this.idDepartment=idDepartment;
        this.description=description;
    }
    
    public ConcreteDepartment(){
        
    }

    @Override
    public int getPrimaryKey() {
        return idDepartment;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idDepartment=primaryKey;
    }

    /**
     * @return the idDepartment
     */
    public int getIdDepartment() {
        return idDepartment;
    }

    /**
     * @param idDepartment the idDepartment to set
     */
    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
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
    
    public String toString(){
        return ("idDepartment: \n"+idDepartment+"Description: \n"+description);
    }
    
}
