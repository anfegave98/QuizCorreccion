/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ModeloNavegacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModeloNavegacionn;


/**
 *
 * @author User
 */
public class ModeloNavegacion extends HttpServlet {


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
            out.println("<title>Servlet Tablas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Tablas at " + request.getContextPath() + "</h1>");
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
             
            ModeloNavegacionDAO obj = new ModeloNavegacionDAO();
            
            ArrayList<ModeloNavegacionn> lista = (ArrayList<ModeloNavegacionn>) obj.getAllModelos();
            
            request.setAttribute("listaModelos", lista);
            
           request.getRequestDispatcher("ModelosNavegacion.jsp").forward(request, response);

        } catch (SQLException ex) {
            
            Logger.getLogger(ModeloNavegacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       try {
            String nombre = (String) request.getParameter("nombre");
             
             
             
            ModeloNavegacionDAO dao = new ModeloNavegacionDAO();
            ModeloNavegacionn mod = new ModeloNavegacionn(nombre);
            
            dao.addModelo(mod);
           
            
            response.sendRedirect("ModeloNavegacion");
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloNavegacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
