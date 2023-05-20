
package DAO;

import Models.OrderDetails;
import java.sql.PreparedStatement;


public class OrderDetailsDB extends DBContext{
    
    public boolean insertOrderDetails(OrderDetails orderdetails){
        boolean result=false;
       String sql="INSERT INTO [dbo].[OrderDetails]\n" +
"           ([OrderID]\n" +
"           ,[ProductID]\n" +
"           ,[Quantity]\n" +
"           ,[Price])\n" +
"     VALUES(?,?,?,?)"; 
        
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1, orderdetails.getIdOrder());
            stmt.setInt(2, orderdetails.getIdProduct());
            stmt.setInt(3, orderdetails.getquantityProduct());
            stmt.setDouble(4,orderdetails.getPriceDetails());
            stmt.executeUpdate();
            result=true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
}
