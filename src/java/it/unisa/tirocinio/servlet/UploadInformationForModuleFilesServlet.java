/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet;

import it.unisa.integrazione.manager.concrete.*;
import it.unisa.tirocinio.database.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.*;

/**
 *
 * @author Valentino Vivone
 */

@WebServlet(name = "UploadInformationForModuleFilesServlet", urlPatterns = {"/UploadInformationForModuleFilesServlet"})
public class UploadInformationForModuleFilesServlet extends HttpServlet {
    private PrintWriter out = null;
    private boolean isMultipart;
    private String filePath;
    private String fileSeparator = null;
    private AdministratorDBOperation serialNumberFromDBOperation = null;
    private final JSONObject message = new JSONObject();
    
    @Override
    public void init() {
        try {
            // Get the file location where it would be stored.
            //filePath = getServletContext().getInitParameter("file-upload");
            fileSeparator = System.getProperty("file.separator");
            String userHome = System.getProperty("user.home");
            filePath = userHome+fileSeparator+"ModuleForUploadFile";
            
            serialNumberFromDBOperation = new AdministratorDBOperation();
            
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
            AdministratorDBOperation getSerialNumberObj = new AdministratorDBOperation();
            ConcreteStaff aAdmin = null;
            ConcreteDepartment aDepart= null;
            String serialNumber = null;
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            File fileToStore = null;
            String adminSubfolderPath = filePath;
            while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () ){
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy");
                    Date date = new Date();
                    if( fieldName.equals("modulefile")){
                        fileToStore = new File(adminSubfolderPath+fileSeparator+dateFormat.format(date)+" - Module.pdf");
                    }else if( fieldName.equals("registerfile")){
                        fileToStore = new File(adminSubfolderPath+fileSeparator+dateFormat.format(date)+" - Register.pdf");
                    }
                    fi.write( fileToStore ) ;
                   // out.println("Uploaded Filename: " + fieldName + "<br>");
                }else{
                    //out.println("It's not formfield");
                    //out.println(fi.getString());
                    aDepart = getSerialNumberObj.getFK_DepartmentbyFK_Account(Integer.parseInt(fi.getString()));
                    serialNumber = ""+aDepart.getDescription()+" - Module";
                    adminSubfolderPath += fileSeparator+serialNumber;
                    new File(adminSubfolderPath).mkdir();
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

}
