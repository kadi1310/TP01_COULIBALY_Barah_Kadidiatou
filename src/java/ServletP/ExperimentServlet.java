/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletP;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author coulibaly barah
 */
public class ExperimentServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExperimentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ma première servlet </h1>");
            out.println("<h3>Informations concernant l'adresse IP et le navigateur utilisé par le client :  </h3>");
            out.println("Adresse IP du client: "+ request.getRemoteAddr()+"<br>");
            out.println("Navigateur du client: "+request.getHeader("user-agent")+ "<br>");
            out.println("<h3>Informations concernant la requete du client :  </h3>");
            out.println("Methode : " + request.getMethod()+"<br/>");
            out.println("Protocole : " + request.getProtocol()+"<br/>");
            out.println("uri demandée : " + request.getRequestURI()+"<br/>");
            out.println("<h3>Informations concernant l'entete de la requete  :  </h3>");
            out.println("host: "+ request.getHeader("host")+"<br>");
            out.println("user-agent: "+ request.getHeader("user-agent")+"<br>");
            out.println("accept: "+ request.getHeader("accept")+"<br>");
            out.println("accept-language: "+ request.getHeader("accept-language")+"<br>");
            out.println("accept-encoding: "+ request.getHeader("accept-encoding")+"<br>");
            out.println("accept-charset: "+ request.getHeader("accept-charset")+"<br>");
            out.println("keep-alive: "+ request.getHeader("keep-alive")+"<br>");
            out.println("connection: "+ request.getHeader("conection")+"<br>");
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
