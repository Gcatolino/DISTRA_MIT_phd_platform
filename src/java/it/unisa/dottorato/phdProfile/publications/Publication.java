package it.unisa.dottorato.phdProfile.publications;

import java.io.Serializable;

public class Publication implements Serializable{
    
    private int idPublication;
    private String title;
    private String authors;
    private String abstractText;
    private String filePath;
    private String year;
    private String type;
    private String publicationIssue;
    private int numberPages;
    private String FK_Strudent;

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicationIssue() {
        return publicationIssue;
    }

    public void setPublicationIssue(String publicationIssue) {
        this.publicationIssue = publicationIssue;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getFK_Strudent() {
        return FK_Strudent;
    }

    public void setFK_Student(String FK_Strudent) {
        this.FK_Strudent = FK_Strudent;
    }
    
    
}
