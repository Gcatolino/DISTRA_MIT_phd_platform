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
public class ConcreteClaimTraining implements ClaimTraining{
    
    private int idClaimTraining;
    private String description;
    private int FKClaimStatus;
    private int FKProfessor;
    private int FKOrganization;

    public ConcreteClaimTraining(){
    }
    
    public ConcreteClaimTraining(int idClaimTraining, String description, int FKClaimStatus, int FKProfessor, int FKOrganization){
    this.idClaimTraining = idClaimTraining;
    this.description = description;
    this.FKClaimStatus = FKClaimStatus;
    this.FKProfessor=FKProfessor;
    this.FKOrganization = FKOrganization;
    }
    
    @Override
    public int getPrimaryKey() {
        return this.idClaimTraining;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idClaimTraining=primaryKey;
    }

    /**
     * @return the idClaimTraining
     */
    public int getIdClaimTraining() {
        return idClaimTraining;
    }

    /**
     * @param idClaimTraining the idClaimTraining to set
     */
    public void setIdClaimTraining(int idClaimTraining) {
        this.idClaimTraining = idClaimTraining;
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
     * @return the FKClaimStatus
     */
    public int getFKClaimStatus() {
        return FKClaimStatus;
    }

    /**
     * @param FKClaimStatus the FKClaimStatus to set
     */
    public void setFKClaimStatus(int FKClaimStatus) {
        this.FKClaimStatus = FKClaimStatus;
    }

    /**
     * @return the FKProfessor
     */
    public int getFKProfessor() {
        return FKProfessor;
    }

    /**
     * @param FKProfessor the FKProfessor to set
     */
    public void setFKProfessor(int FKProfessor) {
        this.FKProfessor = FKProfessor;
    }

    /**
     * @return the FKOrganization
     */
    public int getFKOrganization() {
        return FKOrganization;
    }

    /**
     * @param FKOrganization the FKOrganization to set
     */
    public void setFKOrganization(int FKOrganization) {
        this.FKOrganization = FKOrganization;
    }
    
     public String toString(){
        return ("idClaimTraining: \n"+idClaimTraining+"Description: \n"+description+"FKClaimStatus: \n"+FKClaimStatus+"FKProfessor: \n"
                +FKProfessor+"FKOrganization: \n"+FKOrganization);
    }
    
}
