/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.manager.concrete;

import it.unisa.integrazione.manager.interfaces.*;
import java.util.GregorianCalendar;

/**
 *
 * @author albamansillacoca
 */
public class ConcreteStudent implements Student {

    private String SerialNumber;
    private String coverLetter;
    private GregorianCalendar yearEnrollment;
    private int cycle;
    private String universityEmail;
    private int FKAccount;
    private int FKFisicPerson;
    private int FKDepartment;
    private int FKStudentStatus;
    private int FKClaimTraining;
    private int FKidStudentInformation;

    public ConcreteStudent(String SerialNumber, String coverLetter, GregorianCalendar yearEnrollment, int cycle, String universityEmail, int FKAccount, int FKFisicPerson, int FKDepartment, int FKStudentStatus, int FKClaimStatus, int FKidStudentInformation) {
        this.SerialNumber = SerialNumber;
        this.coverLetter = coverLetter;
        this.yearEnrollment = yearEnrollment;
        this.cycle = cycle;
        this.universityEmail = universityEmail;
        this.FKAccount = FKAccount;
        this.FKFisicPerson = FKFisicPerson;
        this.FKDepartment = FKDepartment;
        this.FKStudentStatus = FKStudentStatus;
        this.FKClaimTraining = FKClaimStatus;
        this.FKidStudentInformation = FKidStudentInformation;
    }
  
    public ConcreteStudent(){
        
    }

    @Override
    public String getPrimaryKey() {
        return SerialNumber;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        SerialNumber = primaryKey;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public GregorianCalendar getYearEnrollment() {
        return yearEnrollment;
    }

    public void setYearEnrollment(GregorianCalendar yearEnrollment) {
        this.yearEnrollment = yearEnrollment;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getUniversityEmail() {
        return universityEmail;
    }

    public void setUniversityEmail(String universityEmail) {
        this.universityEmail = universityEmail;
    }

    public int getFKAccount() {
        return FKAccount;
    }

    public void setFKAccount(int FKAccount) {
        this.FKAccount = FKAccount;
    }

    public int getFKFisicPerson() {
        return FKFisicPerson;
    }

    public void setFKFisicPerson(int FKFisicPerson) {
        this.FKFisicPerson = FKFisicPerson;
    }

    public int getFKDepartment() {
        return FKDepartment;
    }

    public void setFKDepartment(int FKDepartment) {
        this.FKDepartment = FKDepartment;
    }

    public int getFKStudentStatus() {
        return FKStudentStatus;
    }

    public void setFKStudentStatus(int FKStudentStatus) {
        this.FKStudentStatus = FKStudentStatus;
    }

    public int getFKClaimTraining() {
        return FKClaimTraining;
    }

    public void setFKClaimTraining(int FKClaimStatus) {
        this.FKClaimTraining = FKClaimStatus;
    }

    public int getFKidStudentInformation() {
        return FKidStudentInformation;
    }

    public void setFKidStudentInformation(int FKidStudentInformation) {
        this.FKidStudentInformation = FKidStudentInformation;
    }

    
    
    public String toString() {
        return ("SerialNumber: \n" + SerialNumber + "coverLetter: \n" + coverLetter + "YearEnrollment: \n" + yearEnrollment
                + "cycle: \n" + cycle + "UniversityEmail: \n" + universityEmail + "FKAccount: \n" + FKAccount + "FKFisicPerson:\n" + FKFisicPerson
                + "FKDepartment: \n" + FKDepartment + "FKStudentStatus:\n" + FKStudentStatus + "FKClaimStatus:\n" + FKClaimTraining);
    }


}
