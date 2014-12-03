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
public class Account {

    private String email;
    private String password;
    private String typerOfAccount;
    private boolean active;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTyperOfAccount() {
        return typerOfAccount;
    }

    public void setTyperOfAccount(String typerOfAccount) {
        this.typerOfAccount = typerOfAccount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
}
