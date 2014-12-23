package it.unisa.integrazione.servlet;

import it.unisa.integrazione.database.CycleManager;
import it.unisa.integrazione.database.DegreeManager;
import it.unisa.integrazione.database.DepartmentManager;
import it.unisa.integrazione.database.PersonManager;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.database.exception.MissingDataException;
import it.unisa.integrazione.model.Account;
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

/**
 *
 * @author gemmacatolino
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {

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

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String typeOfAccount = request.getParameter("typeOfAccount");

            String address = request.getParameter("address");
            String citizenship = request.getParameter("citizenship");
            String city = request.getParameter("city");

            int cycle = 0;
            
            if(typeOfAccount.toLowerCase().contains("bstudent"))
                cycle = 1;
            else if(typeOfAccount.toLowerCase().contains("mstudent"))
                cycle = 2;        
            else if(typeOfAccount.toLowerCase().contains("phd"))
                cycle = 3;  
            else if(typeOfAccount.toLowerCase().contains("professor"))
                cycle = 4;
            else cycle = 5;
                    
            String department = request.getParameter("department");
            
            String gender = request.getParameter("gender");
            String matricula = request.getParameter("matricula");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String phone = request.getParameter("phone");
            String position = request.getParameter("position");
            String ssn = request.getParameter("ssn");
            String university = request.getParameter("university");
            String webpage = request.getParameter("webPage");
            String zipCode = request.getParameter("zipCode");
            String degree = request.getParameter("degree");
            
            
            Account account = new Account();
            account.setEmail(email);
            account.setPassword(password);
            account.setActive(false);
            account.setTypeOfAccount(typeOfAccount);

            Person person = new Person();
            person.setAccount(account);
            person.setAddress(address);
            person.setCitizenship(citizenship);
            person.setCity(city);
            person.setCycle(CycleManager.getInstance().getCycleByCycleNumber(cycle));
            person.setDepartment(DepartmentManager.getInstance().getDepartmentByAbbreviation(department));
            
            person.setGender(gender);
            person.setMatricula(matricula);
            person.setName(name);
            person.setSurname(surname);
            person.setPhone(phone);
            person.setPosition(position);
            person.setSsn(ssn);
            person.setUniversity(university);
            person.setWebPage(webpage);
            person.setZipCode(zipCode);
            person.setDegree(DegreeManager.getInstance().getDegreeByTitle(degree));
            
            PersonManager.getInstance().add(person);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('La registrazione è andata a buon fine');");
            out.println("location='login.jsp';");
            out.println("</script>");
            
           // response.sendRedirect("login.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConnectionException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingDataException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
