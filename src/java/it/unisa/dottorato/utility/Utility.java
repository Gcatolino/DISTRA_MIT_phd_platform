package it.unisa.dottorato.utility;

import java.sql.*;
import java.text.DateFormat;

/**
 * Questa classe contiene un insieme di utility per la gestione del sistema.
 */
public class Utility {

    synchronized static public String emptyValue(String value){
        if("".equals(value))
            return "null";
        else
            return "'" + value + "'";
    }

    /**
     * Sostituisce i caratteri ' e \ con '' nella stringa passata come
     * parametro.
     * @param pStr La stringa da trasformare.
     * @return La tringa trasformata.
     */
    static public String Replace(String pStr) {
        String tRis;
        tRis = pStr.replaceAll("\"", "'");
        tRis = tRis.replaceAll("'", "''");
        return tRis;
    }

    /**
     * Sostituisce il carattere ' con la stringa " " nella stringa passata come
     * parametro.
     * @param pStr La stringa da trasformare.
     * @return La tringa trasformata.
     */
    static public String ReplaceQuote(String pStr) {
        String tRis;
        tRis = pStr.replaceAll("'", " ");
        return tRis;
    }

    /**
     * Esegue un'operazione sul database tramite una stringa SQL.
     * @param pConnect La connessione al database.
     * @param pSql La stringa SQL.
     * @return Il numero di record coinvolti nell'operazione.
     * @throws SQLException
     */
    static public int executeOperation(Connection pConnect, String pSql)
            throws SQLException {
        int tResult;
        try (Statement stmt = pConnect.createStatement()) {
            tResult = stmt.executeUpdate(pSql);
        }
        return tResult;
    }

    /**
     * Esegue una Query SQL sul database.
     * @param pConnect La connessione al database.
     * @param pSql La stringa SQL.
     * @return Il numero di record coinvolti nell'operazione.
     * @throws SQLException
     */
    static public ResultSet queryOperation(Connection pConnect, String pSql)
            throws SQLException {
        Statement stmt = pConnect.createStatement();
        return stmt.executeQuery(pSql);
    }

    /**
     * Restituisce la data in input in formato String.
     * @param pDate La Data da convertire.
     * @param pHour
     * @return La data convertita.
     */
    static public String Date2String(java.util.Date pDate, boolean pHour) {
        try {
            DateFormat dfDate = DateFormat.getDateInstance(DateFormat.SHORT);
            DateFormat dfTime = DateFormat.getTimeInstance(DateFormat.SHORT);
            if (pHour) {
                return dfDate.format(pDate) + " " + dfTime.format(pDate);
            } else {
                return dfDate.format(pDate);
            }
        } catch (Exception e) {
            return "";
        }
    }

}
