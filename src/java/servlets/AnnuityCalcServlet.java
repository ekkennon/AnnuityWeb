/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Annuity;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Erin K Kennon
 */
public class AnnuityCalcServlet extends HttpServlet { 

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
        String url = "/AnnuityResult.jsp";
        String errorMsg = "";
        double rate;
        double begDeposit;
        double endDeposit;
        int term;
        Annuity a = new Annuity();
        
        
        try {
            begDeposit = Double.parseDouble(request.getParameter("amt1"));
            endDeposit = Double.parseDouble(request.getParameter("amt2"));
            
            if (begDeposit + endDeposit <= 0) {
                errorMsg += "Total deposits must be greater than 0 <br>";
            } else {
                a.setBegDeposit(begDeposit);
                a.setEndDeposit(endDeposit);
            }
        } catch (Exception e) {
            errorMsg += "Deposit Error: " + e.getMessage() + "<br>";
        }
        
        try {
            rate = Double.parseDouble(request.getParameter("irt"));
            
            if (rate <= 0) {
                errorMsg += "Interest rate must be greater than 0 <br>";
            } else {
                a.setRate(rate);
            }
        } catch (Exception e) {
            errorMsg += "Interest rate Error: " + e.getMessage() + "<br>";
        }
        
        try {
            term = Integer.parseInt(request.getParameter("term"));
            
            if (term <= 0) {
                errorMsg += "Term must be greater than 0 <br>";
            } else {
                a.setTerm(term);
            }
        } catch (Exception e) {
            errorMsg += "Term Error: " + e.getMessage() + "<br>";
        }
        
        if (errorMsg != "") {
            url = "/AnnuityInput.jsp";
            request.setAttribute("errorMsg", errorMsg);
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("annuity",a);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(url);
        disp.forward(request,response);
        
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
