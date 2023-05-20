/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDB;
import Models.Account;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("rem");
        AccountDB adb=new AccountDB();
        Account acc=null;

        Cookie cookieUser = new Cookie("cuser", user);
        Cookie cookiePass = new Cookie("cpass", pass);
        Cookie cookieRem = new Cookie("crem", remember);
        if(adb.checkSignUp(user)==true){
        
        try {
            acc = adb.getAccountByUsername(user);
        } catch (Exception e) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        if (acc != null && acc.getPassword().equals(pass)) {

            if (remember != null) {
                cookieUser.setMaxAge(60 * 60 * 24);
                cookiePass.setMaxAge(60 * 60 * 24);
                cookieRem.setMaxAge(60 * 60 * 24);
            } else {
                cookieUser.setMaxAge(0);
                cookiePass.setMaxAge(0);
                cookieRem.setMaxAge(0);
            }
            response.addCookie(cookieUser);
            response.addCookie(cookiePass);
            response.addCookie(cookieRem);
            
            
            HttpSession session = request.getSession();
            session.setAttribute("user", acc);
            session.setAttribute("rem", remember);
//            ProductDB pdb = new ProductDB();
//            ArrayList<Product> bestseller = pdb.bestSeller();
//            session.setAttribute("bestseller", bestseller);
            session.setAttribute("acc", acc);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("alert", "username or password incorrect");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

        }}else{
             request.setAttribute("alert", "username or password incorrect");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
