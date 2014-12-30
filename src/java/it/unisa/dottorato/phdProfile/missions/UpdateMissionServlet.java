/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdProfile.missions;

import it.unisa.integrazione.model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author gemmacatolino
 */
@WebServlet(name = "UpdateMissionServlet", urlPatterns = {"/dottorato/UpdateMissionServlet"})
public class UpdateMissionServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        JSONObject result = new JSONObject();
        PrintWriter out = response.getWriter();

        try {
            response.setContentType("text/html;charset=UTF-8");
            
            int missionID = Integer.parseInt("" + request.getSession().getAttribute("idMission"));
            
            String place = request.getParameter("place");
            String description = request.getParameter("description");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            
            HttpSession session = request.getSession();
            Person loggedPerson = (Person) session.getAttribute("person");
            
            Mission mission = new Mission();
            
            mission.setPlace(place);
            mission.setDescription(description);
            mission.setStartDate(java.sql.Date.valueOf(startDate));
            mission.setEndDate(java.sql.Date.valueOf(endDate));
            mission.setFK_Student(loggedPerson.getSsn());
            
            MissionManager.getInstance().update(missionID, mission);
            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('La missione è stata modificata.');");
            out.println("location='missionActivity.jsp';");
            out.println("</script>");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UpdateMissionServlet.class.getName()).log(Level.SEVERE, null, ex);
            
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
