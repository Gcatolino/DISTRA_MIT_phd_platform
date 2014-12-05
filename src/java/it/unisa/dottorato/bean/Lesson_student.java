package it.unisa.dottorato.bean;

import java.io.Serializable;

public class Lesson_student implements Serializable{
    
    private int FK_Lesson;
    private int FK_Student;

    public int getFK_Lesson() {
        return FK_Lesson;
    }

    public void setFK_Lesson(int FK_Lesson) {
        this.FK_Lesson = FK_Lesson;
    }

    public int getFK_Student() {
        return FK_Student;
    }

    public void setFK_Student(int FK_Student) {
        this.FK_Student = FK_Student;
    }
    
}
