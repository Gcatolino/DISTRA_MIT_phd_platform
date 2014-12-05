package it.unisa.dottorato.exception;

import java.lang.Exception;


/**
 * Questa classe rappresenta l'eccezione generata quando si cerca di
 * assegnare un valore non valido ad una variabile.
 */
public class InvalidValueException extends Exception {

	private static final long serialVersionUID = 2809483023123604223L;

	/**
	 * Genera l'eccezione senza un messagio di errore associato.
	 */
	public InvalidValueException (){
		super("Invalid value for the variable");
	}
	
	/**
	  * Genera l'eccezione con un messagio di errore associato.
	  *
	  * @param pMessage 	Il messaggio di errore che deve essere associato
	  *						all'eccezione.
	  */
	public InvalidValueException(String pMessage) {
		super(pMessage);
	}
}