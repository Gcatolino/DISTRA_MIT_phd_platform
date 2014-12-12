/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.model;

/**
 *
 * @author gemmacatolino
 */
public class Department {
    
    String abbrevation;
    String title;
    String url_moodle;
    String token;

    public String getAbbrevation() {
        return abbrevation;
    }

    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_moodle() {
        return url_moodle;
    }

    public void setUrl_moodle(String url_moodle) {
        this.url_moodle = url_moodle;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
