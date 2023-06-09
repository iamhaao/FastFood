
package Controller;

import DAO.OrderDB;
import DAO.OrderDetailsDB;
import DAO.StoreDB;
import Models.Account;
import Models.Cart;
import Models.Order;
import Models.OrderDetails;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;


public class CheckOut extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        StoreDB sdb=new StoreDB();
        String address=request.getParameter("address");
        int idStore=Integer.parseInt(request.getParameter("store"));
         ArrayList<Cart> listCart = (ArrayList<Cart>) session.getAttribute("cartProducts");
         Account acc=(Account) session.getAttribute("acc");
         Double total=(Double) session.getAttribute("total");
         String idOrder=RandomStringUtils.randomAlphanumeric(6);
         Order order=new Order(idOrder,acc.getIdAccount(), formatter.format(date), total,idStore , address);
         OrderDB odb=new OrderDB();
          if (listCart != null && acc!=null) {
                odb.insertOrder(order);
                for (Cart c : listCart) {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setIdOrder(idOrder);
                    orderDetails.setIdProduct(c.getIdProduct());
                    orderDetails.quantityProduct(c.getQuantityProduct());
                    orderDetails.setPriceDetails(c.getPrice()*c.getQuantityProduct());
                    OrderDetailsDB detailsdb = new OrderDetailsDB();
                    boolean result=detailsdb.insertOrderDetails(orderDetails);
                    if (!result) {
                        break;
                    }
                }
                listCart.clear();
                request.setAttribute("alert", "Bạn đã đặt hàng thành công!!! ");
                response.sendRedirect("Success.jsp");
                int size = listCart.size();
                session.setAttribute("size", size);
            } else {
                if (acc==null) {
                    response.sendRedirect("Login.jsp");
                } else {
                    response.sendRedirect("Product.jsp");
                }
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
