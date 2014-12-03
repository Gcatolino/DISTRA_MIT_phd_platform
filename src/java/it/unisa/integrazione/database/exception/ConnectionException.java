/*
 * ConnectionException
 *
 */

package it.unisa.integrazione.database.exception;

public class ConnectionException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -6593436034986073011L;

    /**
     * 
     */
    public ConnectionException() {
        super("Unable to Connect to the DataBase!");
    }

    /**
     * Genera l'eccezione con un messagio di errore associato
     * 
     * @param pMessage
     *            Il messaggio di errore che deve essere associato all'eccezione
     */
    public ConnectionException(String pMessage) {
        super(pMessage);
    }

}