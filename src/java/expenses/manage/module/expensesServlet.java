/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package expenses.manage.module;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String txtemail = request.getParameter("txtemail");

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet expensesServlet</title>");
            out.println("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-5'>");
            out.println("    <div class='row mb-3'>");  
            out.println("        <div class='col'>");
            out.println("            <div class='card'>");
            out.println("                <div class='card-body'>");
            out.println("                    <h5 class='card-title'>Fecha: <span id='dat'>24 de septiembre de 2024</span></h5>");
            out.println("                    <p class='card-text'>Descripción del gasto: <span id='description'>Compra de material de oficina</span></p>");
            out.println("                    <p class='card-text'>Monto: <span id='amount'>$150.00</span></p>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("    <div class='row mb-3'>"); 
            out.println("        <div class='col'>");
            out.println("            <div class='card'>");
            out.println("                <div class='card-body'>");
            out.println("                    <h5 class='card-title'>Fecha: <span id='dat'>24 de septiembre de 2024</span></h5>");
            out.println("                    <p class='card-text'>Descripción del gasto: <span id='description'>Compra de material de oficina</span></p>");
            out.println("                    <p class='card-text'>Monto: <span id='amount'>$150.00</span></p>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("    <div class='row mb-3'>"); 
            out.println("        <div class='col'>");
            out.println("            <div class='card'>");
            out.println("                <div class='card-body'>");
            out.println("                    <h5 class='card-title'>Fecha: <span id='dat'>24 de septiembre de 2024</span></h5>");
            out.println("                    <p class='card-text'>Descripción del gasto: <span id='description'>Compra de material de oficina</span></p>");
            out.println("                    <p class='card-text'>Monto: <span id='amount'>$150.00</span></p>");
            out.println("                </div>");
            out.println("            </div>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("</div>");
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
