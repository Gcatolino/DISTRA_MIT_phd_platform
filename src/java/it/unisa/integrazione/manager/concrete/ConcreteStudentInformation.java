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
public class ConcreteStudentInformation implements StudentInformation{

    private int idStudentInformation;
    private String CurriculumVitaePATH;
    private String AccademicTranscriptPATH;
    private Student FK_Student;
            
    public ConcreteStudentInformation(){
    }

    public String getCurriculumVitaePATH() {
        return CurriculumVitaePATH;
    }

    public void setCurriculumVitaePATH(String CurriculumVitaePATH) {
        this.CurriculumVitaePATH = CurriculumVitaePATH;
    }

    public String getAccademicTranscriptPATH() {
        return AccademicTranscriptPATH;
    }

    public void setAccademicTranscriptPATH(String AccademicTranscriptPATH) {
        this.AccademicTranscriptPATH = AccademicTranscriptPATH;
    }

    public Student getFK_Student() {
        return FK_Student;
    }

    public void setFK_Student(Student FK_Student) {
        this.FK_Student = FK_Student;
    }

    public ConcreteStudentInformation(int idStudentInformation, String CurriculumVitaePATH, String AccademicTranscriptPATH){
    
        this.idStudentInformation = idStudentInformation;
        this.CurriculumVitaePATH= CurriculumVitaePATH;
        this.AccademicTranscriptPATH = AccademicTranscriptPATH;
    }
 
    public int getPrimaryKey() {
        return idStudentInformation;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
          this.idStudentInformation = primaryKey;
    }
    
}
