package it.unisa.dottorato.bean;

import java.io.Serializable;

public class Notice implements Serializable {
    
    private int idNotice;
    private String object;
    private String text;

    public int getIdNotice() {
        return idNotice;
    }

    public void setIdNotice(int idNotice) {
        this.idNotice = idNotice;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }  
    
}
