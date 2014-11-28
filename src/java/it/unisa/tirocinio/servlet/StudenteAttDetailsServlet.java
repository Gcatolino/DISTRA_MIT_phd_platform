/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.servlet;


import it.unisa.integrazione.database.*;
import it.unisa.integrazione.manager.concrete.*;
import it.unisa.tirocinio.database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author carlosborges
 */
@WebServlet(name = "StudenteAttDetailsServlet", urlPatterns = {"/StudenteAttDetailsServlet"})
public class StudenteAttDetailsServlet extends HttpServlet {

    private final JSONObject message = new JSONObject();

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
            throws ServletException, IOException {
        
        JSONArray studentList = new JSONArray();
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            StudentAttendanceDetails details = new StudentAttendanceDetails();
            ArrayList<StudentTrainingInformation> dataToReturn = details.getStudentDetails();
            for (StudentTrainingInformation aStundetInfo : dataToReturn) {
                JSONObject studentInfo = new JSONObject();
                studentInfo.put("serialNumber", aStundetInfo.getStudent().getPrimaryKey());
                studentInfo.put("name", aStundetInfo.getFisicPerson().getName());
                studentInfo.put("surname", aStundetInfo.getFisicPerson().getLastName());
                studentInfo.put("cvPath", aStundetInfo.getStudentInformation().getCurriculumVitaePATH());
                studentInfo.put("atPath", aStundetInfo.getStudentInformation().getAccademicTranscriptPATH());
                studentInfo.put("email", aStundetInfo.getStudent().getUniversityEmail());
                studentList.put(studentInfo);
            }
            out.println(studentList);
            message.put("StudentList", studentList);
            response.getWriter().write(message.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudenteAttDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudenteAttDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(StudenteAttDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
