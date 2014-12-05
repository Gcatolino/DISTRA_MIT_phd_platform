package it.unisa.dottorato.exception;

import java.lang.Exception;

/**
  * Questa classe rappresenta l'eccezione generata quando non possibile
  * ottenere una connessione al database
  */
public class ConnectionException extends Exception {

	/**
	 * Genera l'eccezione senza un messagio di errore associato.
	 */
	public ConnectionException() {
		super("Unable to Connect to the DataBase!");
	}
	
	/**
	  * Genera l'eccezione con un messagio di errore associato.
	  *
	  * @param pMessage 	Il messaggio di errore che deve essere associato
	  *						all'eccezione.
	  */
	public ConnectionException(String pMessage) {
		super(pMessage);
	}
	
	
}