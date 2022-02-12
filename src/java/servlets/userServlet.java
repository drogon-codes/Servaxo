/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ejb.UserLocal;
import entities.TblOrder;
import entities.TblServiceorder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import client.restClient;


/**
 *
 * @author Admin
 */
@WebServlet(name = "userServlet", urlPatterns = {"/userServlet"})
public class userServlet extends HttpServlet {
@EJB UserLocal ul;
restClient rc = new restClient();
Currency curr = Currency.getInstance("INR");
String symbol = curr.getSymbol();
DateFormat df = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
Date today = Calendar.getInstance().getTime();
String datetime = df.format(today);
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet userServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//          User Registration
//            ul.registerUser(2, 2, "testuser@email.com", "test123", "User2", "1234567890", datetime, datetime);
//            rc.registerUser("6", "2", "user@gmail.com", "user@123", "User3", "1234567890", datetime, datetime);
//          Add To Cart
//            ul.addToCart(1, 1, 1, 2, datetime, datetime);
//            rc.addToCart("1", "1", "1", "2", datetime, datetime);
//            ul.removePart(1, 1, 1, 2, datetime);
//            rc.removePart("1", "1", "1", "1", datetime);
//            ul.emptyCart(2);

//          Place Order
//            ul.placeOrder(5, 1, 1, "yes", "paytm", "Address 1", "Address 2", "Landmark", 395005, "pending", datetime, datetime);

//          Cancel Order
//            ul.cancelOrder(1, 1, symbol);

//          Add Service To Service Cart
//            ul.addToServiceCart(1, 1, 1, datetime, datetime);
//            ul.removeService(1, 1, 1, datetime);
//            ul.emptyServiceCart(1);

//          Place Service Order
//            ul.addServiceOrder(3, 1, 1, "GJ-05 1314", "Bearing Replacement", datetime, "Address 1", "Address 2", 395005, "Landmark", "Pending", datetime, datetime);

//          Cancel Service Order
//            ul.cancelServiceOrder(1, 1, symbol);
            
//        Collection<TblServiceorder> sOrders = ul.getUserServiceOrders(1);
//
//        for(TblServiceorder sOrder : sOrders){
//            out.println("OrderId: " + sOrder.getServiceorderId() + "<br/>");
//            out.println("UserName: " + sOrder.getUserId().getName()+ "<br/>");
//        }
        
//        Collection<TblOrder> orders = ul.getUserOrders(1);
//        
//        for(TblOrder order : orders){
//            out.println("OrderId: " + order.getOrderId() + "<br/>");
//            out.println("UserName: " + order.getUserId().getName()+ "<br/>");
//        }
            
            out.println("<h1>Servlet userServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
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
