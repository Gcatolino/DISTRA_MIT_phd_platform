package it.unisa.dottorato.phdCycle;

import it.unisa.dottorato.exception.ConnectionException;
import it.unisa.dottorato.exception.EntityNotFoundException;
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

@WebServlet(name = "ServletInsertPhdCycle", urlPatterns = {"/ServletInsertPhdCycle"})
public class ServletInsertPhdCycle extends HttpServlet {
    
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

            String idPhdCycle = request.getParameter("idPhdCycle");
            String description = request.getParameter("description");
            String year = request.getParameter("year");
            String professor = request.getParameter("professor");
            
            PhdCycle aPhdCycle = new PhdCycle();
            aPhdCycle.setIdPhdCycle(Integer.parseInt(idPhdCycle));
            aPhdCycle.setDescription(description);
            aPhdCycle.setYear(Integer.parseInt(year));
            aPhdCycle.setFK_Professor(Integer.parseInt(professor));

            try {
                ManagerPhdCycle.getInstance().insert(aPhdCycle);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServletInsertPhdCycle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ServletInsertPhdCycle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EntityNotFoundException ex) {
                Logger.getLogger(ServletInsertPhdCycle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ConnectionException ex) {
                Logger.getLogger(ServletInsertPhdCycle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
