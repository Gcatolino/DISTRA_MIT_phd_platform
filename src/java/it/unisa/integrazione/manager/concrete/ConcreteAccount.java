package it.unisa.integrazione.manager.concrete;


import it.unisa.integrazione.manager.interfaces.*;

public class ConcreteAccount implements Account{


    private int idAccount;
    private String userName;
    private String password;
    private String typeOfAccount;
    private ConcretePermissions FKPermission;
    
    public ConcreteAccount(int idAccount, String userName, String password, String typeOfAccount, ConcretePermissions FKPermission) {
        this.idAccount = idAccount;
        this.userName = userName;
        this.password = password;
        this.typeOfAccount = typeOfAccount;
        this.FKPermission = FKPermission;
    }

    public ConcreteAccount(){
        
    }
    @Override
    public int getPrimaryKey() {
        return this.idAccount;
        
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        this.idAccount= primaryKey;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String unserName) {
        this.userName = unserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(String typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    public ConcretePermissions getFKPermission() {
        return FKPermission;
    }

    public void setFKPermission(ConcretePermissions FKPermission) {
        this.FKPermission = FKPermission;
    }
    
    public String toString(){
        return ("IDAccount: \n"+idAccount+"UserName: \n"+userName+"Password: \n"+password+
                "TypeOfAccount: \n"+typeOfAccount+"Permissions: \n"+FKPermission);
    }
    
}
