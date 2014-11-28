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
public class ConcreteClaimStatus implements ClaimStatus{
    
    private int idClaimStatus;
    private String description;
    
    public ConcreteClaimStatus(int idClaimStatus, String description){
        this.idClaimStatus=idClaimStatus;
        this.description=description;
    }
    
    public ConcreteClaimStatus(){
    }

    @Override
    public int getPrimaryKey() {
        return this.idClaimStatus;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idClaimStatus=primaryKey;
    }

    /**
     * @return the idClaimStatus
     */
    public int getIdClaimStatus() {
        return idClaimStatus;
    }

    /**
     * @param idClaimStatus the idClaimStatus to set
     */
    public void setIdClaimStatus(int idClaimStatus) {
        this.idClaimStatus = idClaimStatus;
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
        return ("idClaimStatus: \n"+idClaimStatus+"Description: \n"+description);
    }
    
}
