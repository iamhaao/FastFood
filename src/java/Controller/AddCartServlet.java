package Controller;

import Models.Cart;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cart> listCart = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        Cart c = new Cart();
        c.setIdProduct(id);
        c.setQuantityProduct(1);
        HttpSession session = request.getSession();
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
        if (cart_list == null) {
            listCart.add(c);
            session.setAttribute("cart_list", listCart);
            response.sendRedirect("products?nameSearch&choose=0");
        } else {
            listCart = cart_list;
            boolean exist = false;
            for (Cart cart : listCart) {
                if (cart.getIdProduct() == id) {
                    exist = true;
                    response.sendRedirect("error.jsp");
                    break;
                }
            }
            if (!exist) {
                listCart.add(c);
                session.removeAttribute("cart_list");
                session.setAttribute("cart_list", listCart);
                response.sendRedirect("products?nameSearch&choose=0");
            }
        }
        int size = listCart.size();
        session.setAttribute("size", size);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
