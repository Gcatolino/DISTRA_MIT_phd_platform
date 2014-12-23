/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.model;

/**
 *
 * @author Alessandro
 */
public class Degree {

    /**
     * id of the degree and primary key in the DB. it's composed of 5 digit.
     */
    private String matricula;
    /**
     * title of the degree
     */
    private String title;

    /**
     * link to the degree program on esse3
     */
    private String link;

    /**
     * department to which this degree belongs.
     */
    private String departmentAbbreviation;
    
    
    private String esse3Content;

    /**
     * cycle = 1 -> Bachelor degree cycle = 2 -> Degree cycle = 3 -> PhD
     * others...
	 *
     */
    private int cycle;
    
    private boolean active;



    /**
     * Constructor
     * @param matricola
     * @param link
     * @param titolo
     * @param ciclo
     * @param departmentAbb 
     */
    public Degree(String matricola, String link, String titolo, int ciclo, String departmentAbb) {
        this.matricula = matricola;
        this.link = link;
        this.title = titolo;
        this.cycle = ciclo;
        this.departmentAbbreviation = departmentAbb;
        this.active = true;
    }
    
    
    public Degree(String matricola, String link, String titolo, int ciclo, String departmentAbb, boolean active) {
        this.matricula = matricola;
        this.link = link;
        this.title = titolo;
        this.cycle = ciclo;
        this.departmentAbbreviation = departmentAbb;
        this.active = active;
    }

    public String getMatricula(){
        return this.matricula;
    }

    /**
     * 
     * @param sn the serial number of the degree
     */
    public void setMatricula(String sn) {
        if (sn.equals("") || sn.length() > 5) {
            throw new RuntimeException("Empty serial number for new degree");
        }
        this.matricula = sn;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.equals("")) {
            throw new RuntimeException("Empty tile for new degree");
        }
        this.title = title;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        if (cycle <= 0) {
            throw new IllegalArgumentException("Cycle cannot be less than 1");
        }
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        String esc = "\'";
        return "matricula=" + esc + matricula + esc + "," + 
                "title=" + esc + title + esc + "," +
                "link=" + esc + link + esc + "," +
                "cycle_number=" + cycle + "," + 
                "department_abbreviation=" + esc + departmentAbbreviation + esc + "," +
                "active=" + (this.active? 1 : 0); 
    }

    public String toStringQueryInsert() {
        String esc = "\'";
        return esc + title + esc + "," +
                esc + matricula + esc + "," +
                esc + link + esc + "," + cycle + "," +
               esc + departmentAbbreviation + esc + "," +
                (this.active? 1 : 0);
//        return "\"" + serialNumber + "\",\"" + link + "\",\"" + title + "\"," + cycle + "," + serialNumber + ")";
    }

    public boolean equals(Degree b) {
        return this.matricula.equalsIgnoreCase(b.getMatricula())
                && this.title.equalsIgnoreCase(b.getTitle())
                && this.getLink().equals(b.getLink())
                && this.getCycle() == b.getCycle()
                && this.getDepartmentAbbreviation().equalsIgnoreCase(b.getDepartmentAbbreviation());

    }

    public String getDepartmentAbbreviation() {
        return departmentAbbreviation;
    }

    public void setDepartmentAbbreviation(String departmentAbbreviation) {
        this.departmentAbbreviation = departmentAbbreviation;
    }
    
    
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
