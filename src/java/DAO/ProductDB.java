/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Cart;
import Models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER NITRO
 */
public class ProductDB extends DBContext {

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                products.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    ;
   

    public List<Product> getProductByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "select * from Product where Name LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                products.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }

    ;

    public List<Product> getProductByType(int id) {
        List<Product> products = new ArrayList<>();
        String sql = "select * from Product";
        if (id == 0) {
            sql +="";
        } else {
            sql += " where CategoryId=" + id;
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                products.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return products;
    }

    ;
    
    
    public Product getProductByID(int id) {
        String sql = "select * from Product Where ProductID=?";
        Product p = new Product();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p.setIdProduct(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getDouble(4));
                p.setImage(rs.getString(5));
                p.setStatus(rs.getInt(6));
                p.setQuantiry( rs.getInt(7));
                p.setIdCatory(rs.getInt(8));                    
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;
    }
public List<Cart> getCartProducts(ArrayList<Cart> list) {
        List<Cart> listCart = new ArrayList<>();
        try {
            if (!list.isEmpty()) {
                for (Cart cart : list) {
                    String sql = "select * from Product where ProductID=?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setInt(1, cart.getIdProduct());
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setIdProduct(rs.getInt(1));
                        row.setName(rs.getString(2));
                        row.setDescription(rs.getString(3));
                        row.setPrice(rs.getDouble(4));
                        row.setImage(rs.getString(5));
                        row.setStatus(rs.getInt(6));
                        row.setQuantiry( rs.getInt(7));
                        row.setIdCatory(rs.getInt(8));
                        row.setQuantityProduct(cart.getQuantityProduct());
                        listCart.add(row);
                    }
                }
            }
        } catch (Exception e) {
        }
        return listCart;
    }
    public static void main(String[] args) {
        ProductDB pdb = new ProductDB();
        List<Product> products = pdb.getProductByType(0);
        for (Product product : products) {
            System.out.println(product.toString());
        }
        Product p=pdb.getProductByID(12);
        System.out.println(p.toString());
    }

    public double getTotalMoney(ArrayList<Cart> list) throws SQLException {
        double sum = 0;
        if (!list.isEmpty()) {
            for (Cart c : list) {
                String sql = "Select price from Product where ProductID=?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, c.getIdProduct());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    sum += rs.getDouble(1) * c.getQuantityProduct();
                }
            }
        }
        return sum;
    }
}
