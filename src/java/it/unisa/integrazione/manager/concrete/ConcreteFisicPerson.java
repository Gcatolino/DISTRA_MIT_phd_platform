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
public class ConcreteFisicPerson implements FisicPerson {
    
    private int idFisicPerson;
    private String name;
    private String lastName;
    private String phoneNum;
    private String city;
    private String address;
    private String CAP;
    private char SEX;
    private String citizenship;
    private String CF;
    private String email;
    
    public ConcreteFisicPerson(int idFisicPerson, String name, String lastName, String phoneNum, String city, String address,
    String CAP, char SEX, String citizenship, String CF, String email){
        this.idFisicPerson=idFisicPerson;
        this.name=name;
        this.lastName=lastName;
        this.phoneNum=phoneNum;
        this.city=city;
        this.address=address;
        this.CAP=CAP;
        this.SEX=SEX;
        this.citizenship=citizenship;
        this.CF=CF;
        this.email=email;
    }
    
    public ConcreteFisicPerson(){
        
    }

    @Override
    public int getPrimaryKey() {
        return idFisicPerson;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idFisicPerson=primaryKey;
    }

    /**
     * @return the idFisicPerson
     */
    public int getIdFisicPerson() {
        return idFisicPerson;
    }

    /**
     * @param idFisicPerson the idFisicPerson to set
     */
    public void setIdFisicPerson(int idFisicPerson) {
        this.idFisicPerson = idFisicPerson;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the CAP
     */
    public String getCAP() {
        return CAP;
    }

    /**
     * @param CAP the CAP to set
     */
    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    /**
     * @return the SEX
     */
    public char getSEX() {
        return SEX;
    }

    /**
     * @param SEX the SEX to set
     */
    public void setSEX(char SEX) {
        this.SEX = SEX;
    }

    /**
     * @return the citizenship
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * @param citizenship the citizenship to set
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * @return the CF
     */
    public String getCF() {
        return CF;
    }

    /**
     * @param CF the CF to set
     */
    public void setCF(String CF) {
        this.CF = CF;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /*private int idFisicPerson;
    private String name;
    private String lastName;
    private String phoneNum;
    private String city;
    private String address;
    private String CAP;
    private char SEX;
    private String citizenship;
    private String CF;
    private String email;*/
    
     public String toString(){
        return ("IDFisicPerson: \n"+idFisicPerson+"Name: \n"+name+"LastName: \n"+lastName+
                "PhoneNumber: \n"+phoneNum+"City: \n"+city+"Address: \n"+address+"CAP: \n"+ CAP+"SEX: \n"+SEX
                +"Citizenship:\n"+citizenship+"CF: \n"+CF+"Email: \n"+email);
    }
}
