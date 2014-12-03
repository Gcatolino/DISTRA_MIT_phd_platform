/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database.exception;

/**
 *
 * @author gemmacatolino
 */
public class AccountNotActiveException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public AccountNotActiveException() {
        super();
    }

    /**
     * @param pMessage
     */
    public AccountNotActiveException(String pMessage) {
        super(pMessage + buildLabel());
    }

    /**
     * @param pMessage
     * @param pParentException
     */
    public AccountNotActiveException(String pMessage, Exception pParentException) {
        super(pMessage + buildLabel(), pParentException);
    }

    /**
     * @param pParentException
     */
    public AccountNotActiveException(Exception pParentException) {
        super(buildLabel(), pParentException);
    }

    private static String buildLabel() {
        return " [1]";
    }

}
