package it.unisa.integrazione.manager.concrete;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.unisa.integrazione.manager.interfaces.*;

/**
 *
 * @author albamansillacoca
 */
public class ConcreteStaff implements Staff{
    
    private int idStaff;
    private String officePhoneNum;
    private String officeMail;
    private int FKDepartment;
    private int FKAccount;
    private int FKFisicPerson;
    
    
    public ConcreteStaff(int idStaff, String officePhoneNum, String officeMail, int FKDepartment, int FKAccount, int FKFisicPerson){
        this.idStaff=idStaff;
        this.officeMail=officeMail;
        this.officePhoneNum=officePhoneNum;
        this.FKDepartment=FKDepartment;
        this.FKAccount=FKAccount;
        this.FKFisicPerson=FKFisicPerson;
    }
    
    public ConcreteStaff(){
        
    }

    @Override
    public int getPrimaryKey() {
        return this.idStaff;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idStaff=primaryKey;
    }

    /**
     * @return the idStaff
     */
    public int getIdStaff() {
        return idStaff;
    }

    /**
     * @param idStaff the idStaff to set
     */
    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    /**
     * @return the officePhoneNum
     */
    public String getOfficePhoneNum() {
        return officePhoneNum;
    }

    /**
     * @param officePhoneNum the officePhoneNum to set
     */
    public void setOfficePhoneNum(String officePhoneNum) {
        this.officePhoneNum = officePhoneNum;
    }

    /**
     * @return the officeMail
     */
    public String getOfficeMail() {
        return officeMail;
    }

    /**
     * @param officeMail the officeMail to set
     */
    public void setOfficeMail(String officeMail) {
        this.officeMail = officeMail;
    }
    
    /**
     * @return the FKDepartment
     */
    public int getFKDepartment() {
        return FKDepartment;
    }

    /**
     * @param FKDepartment the FKDepartment to set
     */
    public void setFKDepartment(int FKDepartment) {
        this.FKDepartment = FKDepartment;
    }

    /**
     * @return the FKAccount
     */
    public int getFKAccount() {
        return FKAccount;
    }

    /**
     * @param FKAccount the FKAccount to set
     */
    public void setFKAccount(int FKAccount) {
        this.FKAccount = FKAccount;
    }

    /**
     * @return the FKFisicPerson
     */
    public int getFKFisicPerson() {
        return FKFisicPerson;
    }

    /**
     * @param FKFisicPerson the FKFisicPerson to set
     */
    public void setFKFisicPerson(int FKFisicPerson) {
        this.FKFisicPerson = FKFisicPerson;
    }
    
    public String toString(){
        return ("IDStaff: \n"+idStaff+"OfficePhoneNumber: \n"+officePhoneNum+"OfficeEmail: \n"+officeMail+
                "FisicPerson: \n"+FKFisicPerson+"FKAccount: \n"+FKAccount+"FKDepartment: \n"+FKDepartment);
    }

    
}
