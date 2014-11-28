/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.manager.concrete;


import it.unisa.integrazione.manager.interfaces.*;

/**
 *
 * @author albamansillacoca
 */
public class ConcretePermissions implements Permissions {

    private int idPermissions;
    private String description;
    private String classPermission; // this variable refers to the "class" variable in the Permissions interface

    public ConcretePermissions() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassPermission() {
        return classPermission;
    }

    public void setClassPermission(String classPermission) {
        this.classPermission = classPermission;
    }

    public ConcretePermissions(int idPermissions, String description, String classPermission) {
        this.idPermissions = idPermissions;
        this.description = description;
        this.classPermission = classPermission;
    }

    public int getPrimaryKey() {
        return idPermissions;
    }

    public void setPrimaryKey(int idPermissions) {
        this.idPermissions = idPermissions;
    }
    
    
}