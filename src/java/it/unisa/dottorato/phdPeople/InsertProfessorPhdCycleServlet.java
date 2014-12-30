package it.unisa.dottorato.phdPeople;

import it.unisa.dottorato.phdCurriculum.InsertPhdCurriculumServlet;
import it.unisa.dottorato.phdCurriculum.UpdatePhdCurriculumServlet;
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
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Elisa D'Eugenio
 */
@WebServlet(name = "InsertProfessorPhdCycle", urlPatterns = {"/dottorato/InsertProfessorPhdCycle"})
public class InsertProfessorPhdCycleServlet extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        try {

            JSONObject result = new JSONObject();
        String idPhdCycle = request.getParameter("idPhdCycle");
        String idProfessor = request.getParameter("idProfessor");
        
        result.put("result", true);

        try {
            PhdPeopleManager.getInstance().insertProfessorPhdClass(idProfessor, idPhdCycle);
        } catch (ClassNotFoundException | SQLException ex) {
            result.put("result", false);
            Logger.getLogger(InsertPhdCurriculumServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        out.write(result.toString());

        } catch (JSONException ex) {
            Logger.getLogger(UpdatePhdCurriculumServlet.class.getName()).log(Level.SEVERE, null, ex);
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
