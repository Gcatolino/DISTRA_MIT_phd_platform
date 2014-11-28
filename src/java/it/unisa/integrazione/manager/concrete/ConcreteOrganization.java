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
public class ConcreteOrganization implements Organization{
    
    private int idOrganization;
    private String companyName;
    private String city;
    private String addres;
    private String phone;
    private String mail;
    private int FK_Account;
    private int FK_FisicPerson;
    private String training;
    private int FK_Professor;
    
    
    public ConcreteOrganization (int idOrganization, String companyName, String city, String address, String phone, String mail,
            int FK_Account, int FK_FisicPerson, String training, int FK_Professor){
        this.idOrganization=idOrganization;
        this.companyName=companyName;
        this.city=city;
        this.addres=address;
        this.phone=phone;
        this.mail=mail;
        this.FK_Account= FK_Account;
        this.FK_FisicPerson=FK_FisicPerson;
        this.training=training;
        this.FK_Professor=FK_Professor;
    }
    
    public ConcreteOrganization(){
        
    }

    @Override
    public int getPrimaryKey() {
       return this.idOrganization;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idOrganization=primaryKey;
    }

    /**
     * @return the idOrganization
     */
    public int getIdOrganization() {
        return idOrganization;
    }

    /**
     * @param idOrganization the idOrganization to set
     */
    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the addres
     */
    public String getAddres() {
        return addres;
    }

    /**
     * @param addres the addres to set
     */
    public void setAddres(String addres) {
        this.addres = addres;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the account
     */
    public int getFK_Account() {
        return FK_Account;
    }

    /**
     * @param account the account to set
     */
    public void setFK_Account(int FK_Account) {
        this.FK_Account = FK_Account;
    }

    /**
     * @return the fisicPerson
     */
    public int getFK_FisicPerson() {
        return FK_FisicPerson;
    }

    /**
     * @param fisicPerson the fisicPerson to set
     */
    public void setFisicPerson(int FK_FisicPerson) {
        this.FK_FisicPerson = FK_FisicPerson;
    }

    /**
     * @return the training
     */
    public String getTraining() {
        return training;
    }

    /**
     * @param training the training to set
     */
    public void setTraining(String training) {
        this.training = training;
    }

    /**
     * @return the profesor
     */
    public int getFK_Professor() {
        return FK_Professor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(int FK_Professor) {
        this.FK_Professor = FK_Professor;
    }
    
    public String toString(){
        return ("IDOrganization: \n"+idOrganization+"Company name: \n"+companyName
                +"City: \n"+city+"Address: \n"+addres+"Phone: \n"+phone+"Mail:\n"+mail+"Account: \n"+FK_Account
                +"Fisic Person:\n"+FK_FisicPerson+"Training: \n"+training+"Professor: \n"+FK_Professor);
    }
    
    
}
