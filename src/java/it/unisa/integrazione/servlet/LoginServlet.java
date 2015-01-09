/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.servlet;

import it.unisa.integrazione.database.AccountManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gemmacatolino
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            AccountManager accountManager = AccountManager.getInstance();
            Person person = accountManager.login(username, password);

            if (person != null) {
                if (! person.getAccount().isActive()) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Account non attivo');");
                    out.println("location='login.jsp';");
                    out.println("</script>");
                } else if (person.getAccount().getTypeOfAccount().equals("Bstudent")) {
                    session.removeAttribute("loginError");
                    session.setAttribute("person", person);
                    response.sendRedirect("indexLog.jsp");
                } else if (person.getAccount().getTypeOfAccount().equals("Mstudent")) {
                    session.removeAttribute("loginError");
                    session.setAttribute("person", person);
                    response.sendRedirect("indexLog.jsp");
                } else if (person.getAccount().getTypeOfAccount().equals("phd")) {
                    session.removeAttribute("loginError");
                    session.setAttribute("person", person);
                    response.sendRedirect("dottorato/index.jsp");
                } else if (person.getAccount().getTypeOfAccount().equals("professor")) {
                    session.removeAttribute("loginError");
                    session.setAttribute("person", person);
                    response.sendRedirect("indexLog.jsp");
                } else if (person.getAccount().getTypeOfAccount().equals("company")) {
                    session.removeAttribute("loginError");
                    session.setAttribute("person", person);
                    response.sendRedirect("indexLog.jsp");
                } else if (person.getAccount().getTypeOfAccount().equals("admin")) {
                    session.removeAttribute("loginError");
                    session.setAttribute("person", person);
                    response.sendRedirect("indexLog.jsp"); 
                } else if (person.getAccount().getTypeOfAccount().equals("phdadmin")) {
                    session.removeAttribute("loginError");
                    session.setAttribute("person", person);
                    response.sendRedirect("dottorato/index.jsp"); 
                }else {
                    session.setAttribute("loginError", "error");
                    response.sendRedirect("login.jsp");
                }
            } else {
                session.setAttribute("loginError", "error");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException sqlException) {
            out.print("<h1>SQL Exception: </h1>" + sqlException.getMessage());
        } catch (ConnectionException connectionException) {
            out.print("<h1>Connection Exception</h1>");
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
        doPost(request, response);
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
