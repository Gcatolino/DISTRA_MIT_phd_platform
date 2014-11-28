/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet;

import it.unisa.tirocinio.database.StudentDBOperation;
import it.unisa.integrazione.manager.concrete.ConcreteStudent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author carlosborges
 */
@WebServlet(name = "UploadInformationFilesServlet", urlPatterns = {"/UploadInformationFilesServlet"})
public class UploadInformationFilesServlet extends HttpServlet {
    private PrintWriter out = null;
    private boolean isMultipart;
    private String filePath;
    private String fileSeparator = null;
    private StudentDBOperation serialNumberFromDBOperation = null;
    private final JSONObject message = new JSONObject();
    

    @Override
    public void init() {
        try {
            // Get the file location where it would be stored.
            //filePath = getServletContext().getInitParameter("file-upload");
            fileSeparator = System.getProperty("file.separator");
            String userHome = System.getProperty("user.home");
            filePath = userHome+fileSeparator+"PlatformDocuments";
            
            serialNumberFromDBOperation = new StudentDBOperation();
            
            File directoryCheck = new File(filePath);
            if( !directoryCheck.exists() ){
                directoryCheck.mkdir();
            }
        } catch (ClassNotFoundException ex) {
            out.println("Exception "+ex);
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            out.println("Exception "+ex);
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            out.println("Exception "+ex);
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, JSONException {
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin","*");
            out = response.getWriter();
            isMultipart = ServletFileUpload.isMultipartContent(request);
            StudentDBOperation getSerialNumberObj = new StudentDBOperation();
            ConcreteStudent aStudent = null;
            String serialNumber = null;
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            File fileToStore = null;
            String studentSubfolderPath = filePath;
            while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () ){
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    if( fieldName.equals("cvfile")){
                        fileToStore = new File(studentSubfolderPath+fileSeparator+"CV.pdf");
                    }else if( fieldName.equals("examsfile")){
                        fileToStore = new File(studentSubfolderPath+fileSeparator+"ES.pdf");
                    }
                    fi.write( fileToStore ) ;
                   // out.println("Uploaded Filename: " + fieldName + "<br>");
                }else{
                    //out.println("It's not formfield");
                    //out.println(fi.getString());
                    aStudent = getSerialNumberObj.getSerialNumberbyFK_Account(Integer.parseInt(fi.getString()));
                    serialNumber = reverseSerialNumber(aStudent.getPrimaryKey());
                    studentSubfolderPath += fileSeparator+serialNumber;
                    new File(studentSubfolderPath).mkdir();
                } 
            }
            message.put("status", 1);
            out.print(message.toString());
        } catch (IOException ex) {
            message.put("status",0);
            message.put("errorMessage",ex);
            out.print(message.toString());
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            message.put("status",0);
            message.put("errorMessage",ex);
            out.print(message.toString());
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            message.put("status",0);
            message.put("errorMessage",ex);
            out.print(message.toString());
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileUploadException ex) {
            message.put("status",0);
            message.put("errorMessage",ex);
            out.print(message.toString());
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            message.put("status",0);
            message.put("errorMessage",ex);
            out.print(message.toString());
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new ServletException("GET method used with " +
                getClass().getName()+": POST method required.");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UploadInformationFilesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        
        return "Short description";
    }// </editor-fold>

    private String reverseSerialNumber(String primaryKey) {
        String reversedSerialNumber = "";
        for ( int i = primaryKey.length()-1; i >= 0; i-- ){
            reversedSerialNumber += (primaryKey.charAt(i));
        }
        
        return reversedSerialNumber;
    }

}
