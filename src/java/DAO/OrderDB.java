package DAO;

import Models.Order;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDB extends DBContext {

    public void insertOrder(Order order) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([OrderID]"
                + "           ,[AccountID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[TotalAmount]\n"
                + "           ,[StoreID]\n"
                + "           ,[Status]\n"
                + "           ,[AddressShip])\n"
                + "     VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,order.getIdOrder());
            stmt.setInt(2, order.getIdAccount());
            stmt.setString(3, order.getDate());
            stmt.setDouble(4, order.getPrice());
            stmt.setInt(5, order.getIdStore());
            stmt.setInt(6, 0);
            stmt.setString(7, order.getAddress());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

 
}
