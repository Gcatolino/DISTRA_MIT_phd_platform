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
public class ConcreteRejectedTrainingMessage implements RejectedTrainingMessage{

   private int idRejectedTrainingMessage;
   private String description;
   private int RejectedTrainingMessage_idRejectedTrainingMessage;
   private String Student_SerialNumber;
   
   public ConcreteRejectedTrainingMessage(){
   }
   
   public ConcreteRejectedTrainingMessage(int idRejectedTrainingMessage, String description, int RejectedTrainingMessage_idRejectedTrainingMessage, String Student_SerialNumber){
   this.idRejectedTrainingMessage= idRejectedTrainingMessage;
   this.description=description;
   this.RejectedTrainingMessage_idRejectedTrainingMessage=RejectedTrainingMessage_idRejectedTrainingMessage;
   this.Student_SerialNumber= Student_SerialNumber;
   }
    
    public int getPrimaryKey() {
        return idRejectedTrainingMessage;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idRejectedTrainingMessage= primaryKey;
    }
    
    public int getRejectedTrainingMessage_idRejectedTrainingMessage(){
        return RejectedTrainingMessage_idRejectedTrainingMessage;
    }
    
    public void setRejectedTrainingMessage_idRejectedTrainingMessage(int RejectedTrainingMessage_idRejectedTrainingMessage){
        this.RejectedTrainingMessage_idRejectedTrainingMessage=RejectedTrainingMessage_idRejectedTrainingMessage;
    }
    
    public String getStudent_SerialNumber(){
        return Student_SerialNumber;
    }
    
    public void setStudent_SerialNumber(String Student_SerialNumber){
        this.Student_SerialNumber=Student_SerialNumber;
    }
}
