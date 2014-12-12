package it.unisa.integrazione.database.exception;

/**
 *
 * @author gemmacatolino
 */
public class MissingDataException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -6593436034986073011L;

    /**
     * 
     */
    public MissingDataException() {
        super("Cycle is missing!");
    }

    /**
     * Genera l'eccezione con un messagio di errore associato
     * 
     * @param pMessage
     *            Il messaggio di errore che deve essere associato all'eccezione
     */
    public MissingDataException(String pMessage) {
        super(pMessage);
    }

    
}
