/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package expenses.manage.module;

import expenses.database.module.databaseHelper;
import expenses.models.module.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Samuel
 */
public class expensesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String txtemail;

        HttpSession session = request.getSession(false);

        if (session == null) {
            session = request.getSession();            
            txtemail = request.getParameter("txtemail");
        } else {
            txtemail = (String) session.getAttribute("email");
        }

        try ( PrintWriter out = response.getWriter()) {

            databaseHelper dt = new databaseHelper();
            User user = dt.getUser(txtemail);

            session.setAttribute("userId", user.id);
            session.setAttribute("email", user.email);
            ResultSet resultset = dt.getExpenses(user.id);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet expensesServlet</title>");
            out.println("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<style>");
            out.println("  html, body { height: 100%; }");  // Asegura que el html y el body ocupen el 100% de la altura
            out.println("  body { display: flex; flex-direction: column; }");  // Usa flexbox en el body
            out.println("  main { flex-grow: 1; }");  // El contenido principal crecerá para llenar el espacio restante
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // Navbar
            out.println("<nav class='navbar navbar-expand-lg navbar-dark bg-primary'>");
            out.println("  <div class='container-fluid'>");
            out.println("    <a class='navbar-brand' href='#'>ExpensesApp</a>");
            out.println("    <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>");
            out.println("      <span class='navbar-toggler-icon'></span>");
            out.println("    </button>");
            out.println("    <div class='collapse navbar-collapse' id='navbarNav'>");
            out.println("      <ul class='navbar-nav ms-auto'>");
            out.println("        <li class='nav-item'>");
            out.println("          <a class='nav-link active' aria-current='page' href='#'>Start</a>");
            out.println("        </li>");
            out.println("        <li class='nav-item'>");
            out.println("          <a class='nav-link' href='#'>Expenses</a>");
            out.println("        </li>");
            out.println("        <li class='nav-item'>");
            out.println("          <a class='nav-link' href='#'>Reports</a>");
            out.println("        </li>");
            out.println("        <li class='nav-item'>");
            out.println("          <a class='nav-link' href='#'>Settings</a>");
            out.println("        </li>");
            out.println("      </ul>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("</nav>");

            out.println("<main class='container mt-5'>");

            out.println(" <form action='saveExpense'>");
            out.println("   <div class='row mb-3'>");
            out.println("       <div class='col'>");
            out.println("           <div class='card-body'>");
            out.println("               <label for='txtDescription' class='form-label'>Description</label>");
            out.println("               <input type='text' class='form-control' id='txtDescription' name='txtDescription'>");
            out.println("           </div>");
            out.println("       </div>");
            out.println("       <div class='col'>");
            out.println("           <div class='card-body'>");
            out.println("               <label for='txtAmount' class='form-label'>Amount</label>");
            out.println("               <input type='number' class='form-control' id='txtAmount' name='txtAmount'>");
            out.println("               <button type='submit' class='btn btn-primary'>Save</button>");
            out.println("           </div>");
            out.println("       </div>");
            out.println("   </div>");
            out.println(" </form>");

            // Main content
            while (resultset.next()) {
                out.println("    <div class='row mb-3'>");
                out.println("        <div class='col'>");
                out.println("            <div class='card'>");
                out.println("                <div class='card-body'>");
                out.println("                    <h5 class='card-title'><span id='dat'>" + resultset.getString("description") + "</span></h5>");
                out.println("                    <p class='card-text'>Amount: <span id='description'>$" + resultset.getInt("amount") + ".00</span></p>");
                out.println("                    <p class='card-text'>Date: <span id='amount'>" + resultset.getDate("creationDate") + "</span></p>");
                out.println("                </div>");
                out.println("            </div>");
                out.println("        </div>");
                out.println("    </div>");
            }
            out.println("</main>");

            // Footer
            out.println("<footer class='bg-primary text-white text-center text-lg-start mt-auto'>");
            out.println("  <div class='container p-4'>");
            out.println("    <div class='row'>");
            out.println("      <div class='col-lg-6 col-md-12 mb-4 mb-md-0'>");
            out.println("        <h5 class='text-uppercase'>GastosApp</h5>");
            out.println("        <p>Manage your finances efficiently and easily with our app.</p>");
            out.println("      </div>");
            out.println("      <div class='col-lg-6 col-md-12 mb-4 mb-md-0'>");
            out.println("        <h5 class='text-uppercase'>Links</h5>");
            out.println("        <ul class='list-unstyled mb-0'>");
            out.println("          <li><a href='#' class='text-white'>Home</a></li>");
            out.println("          <li><a href='#' class='text-white'>Register Expenses</a></li>");
            out.println("          <li><a href='#' class='text-white'>Report</a></li>");
            out.println("          <li><a href='#' class='text-white'>Settings</a></li>");
            out.println("        </ul>");
            out.println("      </div>");
            out.println("    </div>");
            out.println("  </div>");
            out.println("  <div class='text-center p-3' style='background-color: rgba(0, 0, 0, 0.2);'>");
            out.println("    © 2024 GastosApp | All rights reserved.");
            out.println("  </div>");
            out.println("</footer>");

            out.println("</body>");
            out.println("</html>");

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(expensesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } catch (SQLException ex) {
            Logger.getLogger(expensesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
