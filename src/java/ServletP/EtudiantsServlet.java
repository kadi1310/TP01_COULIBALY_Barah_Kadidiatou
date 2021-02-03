/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletP;

import com.sun.faces.util.HtmlUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
public class EtudiantsServlet extends HttpServlet {
    
     
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_NOM = "nom";
    String ligne="";
    
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
            out.println("<title>Servlet Etudiants</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet EtudiantsServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1 style=\"color:blue\"> <center>LISTE DES ETUDIANTS ENREGISTRER</center></h1>");
            //style="background-color:#00FF00"
            out.println("<table border='2px' > ");
            out.println("<tr>");
            out.println("<th style=\"color:blue\">NOM</th>");
            out.println("<th style=\"color:blue\">PRENOM</th>");
            out.println("<th style=\"color:blue\">EMAIL</th>");
            
            try{
        BufferedReader br = new BufferedReader(new FileReader("etudiants.csv"));
        while((ligne = br.readLine()) != null){
            String[] donne = ligne.split(",");
            
            out.println("<tr>");
            out.println("<td>"+donne[0]+"</td>");
            out.println("<td>"+donne[1]+"</td>");
            out.println("<td>"+donne[2]+"</td>");
            out.println("</tr>");
            out.println("</table>");
        }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
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
        //processRequest(request, response);
        
        /* Récupération des champs du formulaire. */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String email = request.getParameter( CHAMP_EMAIL );
        String filepath = "etudiants.csv";
        saveRecord( nom,  prenom,  email, filepath);
        
        
        
        
        
    }
    public static void saveRecord(String nom, String prenom, String email,String filepath)
        {
            filepath="etudiants.csv";
            try
           {
             FileWriter fw = new FileWriter (filepath , true);
             BufferedWriter bw = new  BufferedWriter(fw);
             PrintWriter pw = new PrintWriter (bw);

             pw.println(nom + ','+ prenom + ','+email);
             pw.flush();
             pw.close();
           }catch(IOException E)
          {
             
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
