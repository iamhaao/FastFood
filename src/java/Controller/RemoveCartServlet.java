package Controller;

import Models.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

public class RemoveCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("cart_list");
        if (listCart != null) {
            for (Cart p : listCart) {
                if (p.getIdProduct() == id) {
                } else {
                    listCart.remove(listCart.indexOf(p));
                    break;
                }
            }
            int size = listCart.size();
            session.setAttribute("size", size);
            response.sendRedirect("cart");
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
