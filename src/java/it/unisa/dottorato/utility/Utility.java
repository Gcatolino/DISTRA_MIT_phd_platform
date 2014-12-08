package it.unisa.dottorato.utility;

import it.unisa.dottorato.exception.ConnectionException;
import it.unisa.dottorato.exception.EntityNotFoundException;
import it.unisa.integrazione.database.DBConnection;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.sql.*;
import java.text.DateFormat;

/**
 * Questa classe contiene un insieme di utility per la gestione del sistema.
 */
public class Utility {

    /**
     * Ritorna, dati un campo e una tabella, il valore massimo del campo nella
     * tabella.
     *
     * @param pField Il campo di cui vogliamo recuperare il valore massimo.
     * @param pTable La tabella in cui ricercare le informazioni richieste.
     * @return Ritorna il valore massimo, del campo pField, passato come
     * parametro, presente nella tabella pTable, passata come parametro.
     *
     * @throws EntityNotFoundException
     * @throws ConnectionException
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    synchronized static public int getMaxValue(String pField, String pTable)
            throws EntityNotFoundException, ConnectionException, SQLException, ClassNotFoundException, IOException {

        int value = 0;
        Connection connect = null;
        try {
            /*
             * Se non sono stati forniti il campo e la tabella restituiamo un
             * codice di errore
             */
            if (pField.equals("")) {
                throw new EntityNotFoundException();
            }
            if (pTable.equals("")) {
                throw new EntityNotFoundException();
            }

            /*
             * Prepariamo la stringa SQL per recuperare le informazioni
             * richieste
             */
            String tSql = "SELECT max(" + pField + ") as new_field FROM "
                    + pTable;

            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();
            if (connect == null) {
                throw new ConnectionException();
            }

            // Inviamo la Query al DataBase
            ResultSet tRs = Utility.queryOperation(connect, tSql);

            if (tRs.next()) {
                value = tRs.getInt("new_field");
            } else {
                throw new EntityNotFoundException();
            }

            return value;
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Converte una data in una stringa formattata per il database.
     *
     * @param pDate La data da convertire.
     * @param pHour
     * @return Ritorna la data formattata per il database.
     */
    static public String date2SQLString(java.util.Date pDate, boolean pHour) {
        TimeZone tz = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(tz);
        calendar.setTime(pDate);

        if (pHour) {
            calendar.setTime(pDate);
        }

        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DATE);

        String result = currentYear + "-" + currentMonth + "-" + currentDay;

        if (pHour) {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            result = result + " " + hour + ":" + min + ":" + sec;
        }

        return result;
    }

    /**
     * Taglia una stringa dopo n caratteri, al primo spazio
     *
     * @param pStr La stringa da tagliare.
     * @param nChar
     * @return
     *
     *
     */
    static public String cutString(String pStr, int nChar) {
        String strReturn;
        if (nChar >= pStr.length()) {
            return pStr;
        } else {
            strReturn = pStr.substring(0, nChar);
            if (!strReturn.substring(nChar).equals(" ")) {
                int k = nChar + 1;
                while (!pStr.substring(nChar, k).equals(" ")) {
                    strReturn = strReturn + pStr.substring(nChar, k);
                    nChar = k;
                    k++;
                }
            }
        }
        return strReturn;
    }

    static public String clear(String pString) {
        int start = 0;
        int start2 = 0;
        int end = 0;
        int end2 = 0;
        String result = "";
        String result2 = "";

        while (end >= 0) {
            end = pString.indexOf("'", start);

            if (end >= 0) {

                result = result + pString.substring(start, end);
                result = result + "\\'";
                start = end + 1;

            } else {
                result = result + pString.substring(start);
            }
        }

        while (end2 >= 0) {
            end2 = result.indexOf("\n", start2);

            if (end2 >= 0) {

                result2 = result2 + result.substring(start2, end2 - 1);
                result2 = result2 + " ";
                start2 = end2 + 1;

            } else {
                result2 = result2 + result.substring(start2);
            }
        }
        return (result2);
    }

    /**
     * Sostituisce i caratteri ' e \ con '' nella stringa passata come
     * parametro.
     *
     * @param pStr La stringa da trasformare.
     *
     * @return La tringa trasformata.
     */
    static public String Replace(String pStr) {
        String tRis;
        tRis = pStr.replaceAll("\"", "'");
        tRis = tRis.replaceAll("'", "\\'");
        return tRis;
    }

    /**
     * Sostituisce il carattere ' con la stringa " " nella stringa passata come
     * parametro.
     *
     * @param pStr La stringa da trasformare.
     *
     * @return La tringa trasformata.
     */
    static public String ReplaceQuote(String pStr) {
        String tRis;
        tRis = pStr.replaceAll("'", " ");
        return tRis;
    }

    /**
     * Esegue un'operazione sul database tramite una stringa SQL.
     *
     * @param pConnect La connessione al database.
     * @param pSql La stringa SQL.
     *
     * @return Il numero di record coinvolti nell'operazione.
     *
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
     *
     * @param pConnect La connessione al database.
     * @param pSql La stringa SQL.
     *
     * @return Il numero di record coinvolti nell'operazione.
     *
     * @throws SQLException
     */
    static public ResultSet queryOperation(Connection pConnect, String pSql)
            throws SQLException {
        Statement stmt = pConnect.createStatement();
        return stmt.executeQuery(pSql);
    }

    /**
     * Converte un dato booleano in intero.
     *
     * @param pBol Il valore booleano da convertire in intero.
     *
     * @return Il valore intero corrispondente al valore booleano passato come
     * parametro.
     */
    static public int BooleanToInt(boolean pBol) {
        if (pBol == true) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Converte un dato intero in booleano.
     *
     * @param pInt Il valore intero da convertire in booleano.
     *
     * @return Il valore booleano corrispondente al valore intero passato come
     * parametro.
     */
    static public boolean IntToBoolean(int pInt) {
        return pInt == 1;
    }

    /**
     * Restituisce la data corrente.
     *
     * @return La data corrente.
     */
    static public java.util.Date today() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date creationDate = calendar.getTime();
        return creationDate;
    }

    /**
     * Restituisce la data contenuta nella stringa in input.
     *
     * @param pDate La stringa di cui effettuare il parse in un data.
     *
     * @return La data convertita.
     */
    static public java.util.Date String2Date(String pDate) {
        try {
            DateFormat dfDate = DateFormat.getDateInstance();
            java.util.Date tDate = dfDate.parse(pDate,
                    new java.text.ParsePosition(0));
            java.sql.Timestamp timeStamp = new java.sql.Timestamp(tDate
                    .getTime());

            return (java.util.Date) timeStamp;
        } catch (Exception e) {
            try {
                DateFormat dfDate = DateFormat.getDateInstance(
                        DateFormat.SHORT, java.util.Locale.ITALY);
                java.util.Date tDate = dfDate.parse(pDate,
                        new java.text.ParsePosition(0));
                java.sql.Timestamp timeStamp = new java.sql.Timestamp(tDate
                        .getTime());

                return (java.util.Date) timeStamp;
            } catch (Exception e2) {
                return null;
            }
        }
    }

    /**
     * Restituisce la data in input in formato String.
     *
     * @param pDate La Data da convertire.
     * @param pHour
     *
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

    /**
     * @param sourceStr
     * @param searchFor
     * @param replaceWith
     * @return la stringa corrispondente a searchBuffer
     */
    public static String ReplaceAll(String sourceStr, String searchFor,
            String replaceWith) {
        StringBuilder searchBuffer = new StringBuilder(sourceStr);
        int hits = 0;

        while (searchBuffer.toString().toUpperCase().indexOf(
                searchFor.toUpperCase(), hits) >= 0) {
            int newIndex = searchBuffer.toString().toUpperCase().indexOf(
                    searchFor.toUpperCase(), hits);
            searchBuffer.replace(newIndex, newIndex + searchFor.length(),
                    replaceWith);
            hits++;
        }

        return searchBuffer.toString();
    }

    // La funzione precedente va in loop se sostituisco "\" con "\\"
    // usiamo allora due variabile la prima viene "consumata" ad ogni occorrenza
    // del pattern
    /**
     * @param sourceStr
     * @param searchFor
     * @param replaceWith
     * @return newStringBuffer
     */
    public static String ReplaceAllStrings(String sourceStr, String searchFor,
            String replaceWith) {
        StringBuffer searchBuffer = new StringBuffer(sourceStr);
        StringBuilder newStringBuffer = new StringBuilder("");

        while (searchBuffer.toString().toUpperCase().contains(searchFor.toUpperCase())) {
            int newIndex = searchBuffer.toString().toUpperCase().indexOf(
                    searchFor.toUpperCase());
            newStringBuffer.append(searchBuffer.substring(0, newIndex));
            newStringBuffer.append(replaceWith);
            searchBuffer = new StringBuffer(searchBuffer.substring(newIndex
                    + searchFor.length(), searchBuffer.length()));
        }

        newStringBuffer.append(searchBuffer);
        return newStringBuffer.toString();
    }

    /**
     * @param sourceStr
     * @param removeStr
     */
    public static void RemoveAll(String sourceStr, String removeStr) {
        int nextOccurence;

        while (sourceStr.toUpperCase().contains(removeStr.toUpperCase())) {
            nextOccurence = sourceStr.toUpperCase().indexOf(
                    removeStr.toUpperCase());
            sourceStr = sourceStr.substring(0, nextOccurence)
                    + sourceStr.substring(nextOccurence + removeStr.length(),
                            sourceStr.length());
        }
    }

    /**
     * Calcola la distanza in giorni tra 2 date passate.
     *
     * @param today
     * @param reservationDate
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int daysBetween(Date today, Date reservationDate) {
        final int millisecInADay = 86400000;

        GregorianCalendar firstDate = new GregorianCalendar();
        GregorianCalendar secondDate = new GregorianCalendar();

        firstDate.set(today.getYear() + 1900, today.getMonth(), today.getDate());
        secondDate.set(reservationDate.getYear() + 1900, reservationDate.getMonth(), reservationDate.getDate());

        long millisecBetween = secondDate.getTimeInMillis() - firstDate.getTimeInMillis();
        int daysBetween = (int) (millisecBetween / millisecInADay);

        return (daysBetween);
    }

}
