/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database.utility;

/**
 *
 * @author gemmacatolino
 */
public class Utilities {
    
    synchronized static public String emptyValue(String value){
        if("".equals(value))
            return "null";
        else
            return value;
    }
}