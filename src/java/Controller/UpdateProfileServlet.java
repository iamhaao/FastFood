package Controller;

import DAO.AccountDB;
import Models.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        HttpSession session=request.getSession();
        AccountDB adb=new AccountDB();
        Account c=(Account) session.getAttribute("acc");
        String pass=request.getParameter("password");
        Account acc=new Account(c.getIdAccount(), user, pass, name, email, address, phone, c.getIdRole(), c.getAvatar());
        adb.updateCustomer(c); 
        session.setAttribute("acc", acc);
        request.setAttribute("alert", "Update Profile Successfull !!!!");
        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);

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
