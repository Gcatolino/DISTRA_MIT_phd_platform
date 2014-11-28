/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.manager.concrete;

import it.unisa.integrazione.manager.interfaces.*;

/**
 *
 * @author katiasolomita
 */
public class ConcreteOfferTraining implements OfferTraining{

   private int idOfferTraining;
   private String description;
   private String FK_Organization;
   private int Organization_idOrganization;
           
    public ConcreteOfferTraining(){
    }
    
    public ConcreteOfferTraining(int idOfferTraining, String description, String FK_Organization, int Organization_idOrganization){
        this.idOfferTraining=idOfferTraining;
        this.description=description;
        this.FK_Organization= FK_Organization;
        this.Organization_idOrganization=Organization_idOrganization;
    }
    
    public int getPrimaryKey() {
        return idOfferTraining;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idOfferTraining=primaryKey;
    }
    
    public int getidOfferTraining(){
        return idOfferTraining;
    }
    
    public void setidOfferTraining(int idOfferTraining){
        this.idOfferTraining=idOfferTraining;
    }
    
    public String getFKOrganization(){
        return FK_Organization;
    }
    
    public void setFKOrganization(String FK_Organization){
        this.FK_Organization=FK_Organization;
    }
    
    public int getOrganization_idOrganization(){
        return Organization_idOrganization;
    }
    
    public void setOrganization_idOrganization(int Organization_idOrganization){
        this.Organization_idOrganization= Organization_idOrganization;
    }
            
}
