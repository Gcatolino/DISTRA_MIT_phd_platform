/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tp.model.interfaces;

/**
 *
 * @author katiasolomita
 */
public interface StudentAttendence {
    
    public int getPrimaryKey();
    public void setPrimaryKey(int primaryKey);

    /**
     *
     * @return a string of the object
     */
    @Override
    public String toString();
}
