/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.manager.concrete;

/**
 *
 * @author carlosborges
 */
public class StudentTrainingInformation {
    private ConcreteStudent aStudent;
    private ConcreteFisicPerson aFisicPerson;
    private ConcreteStudentInformation aStudentInformation;

    public StudentTrainingInformation(ConcreteStudent aStudent, ConcreteFisicPerson aFisicPerson, ConcreteStudentInformation aStudentInformation) {
        this.aStudent = aStudent;
        this.aFisicPerson = aFisicPerson;
        this.aStudentInformation = aStudentInformation;
    }

    public StudentTrainingInformation(){
        
    }

    public ConcreteStudent getStudent() {
        return aStudent;
    }

    public void setStudent(ConcreteStudent aStudent) {
        this.aStudent = aStudent;
    }

    public ConcreteFisicPerson getFisicPerson() {
        return aFisicPerson;
    }

    public void setFisicPerson(ConcreteFisicPerson aFisicPerson) {
        this.aFisicPerson = aFisicPerson;
    }

    public ConcreteStudentInformation getStudentInformation() {
        return aStudentInformation;
    }

    public void setaStudentInformation(ConcreteStudentInformation aStudentInformation) {
        this.aStudentInformation = aStudentInformation;
    }

    
    
}
