/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author alexs
 */
@WebServlet(name = "JurosSimplesServlet", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServlet extends HttpServlet {


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
            out.println("<title>Calculo de Juros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3><a href='./'>Voltar</a></h3>");
                        try{
                double Valor = Double.parseDouble(request.getParameter("Valor"));
                out.println("<h2>Valor Presente = R$ "+Valor+"</h2>");
                double j = Double.parseDouble(request.getParameter("j"));
                out.println("<h2>Juros = "+j+" %</h2>");
                double n = Double.parseDouble(request.getParameter("n"));
                out.println("<h2>Parcelas em = "+n+" X</h2>");
                double VF = Valor + (Valor * ((j/1000) * n));
                out.println("<h2>Valor a prazo = R$ "+VF+"</h2>");
                double VP = VF/n;
                out.println("<h2>Valor da parcela = R$ "+VP+"</h2>");
            }catch(NumberFormatException ex){
                out.println("<h2>Ocorreu um erro: "+ex.getLocalizedMessage()+"</h2>");
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