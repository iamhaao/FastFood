package DAO;

import Models.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDB extends DBContext {

    public List<Account> getAll() {
        List<Account> listAccount = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
                listAccount.add(acc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listAccount;
    }

    ;
    
    public Account getAccountByUsername(String username) {
        Account acc = new Account();
        String sql = "select * from Account where Username=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                acc = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return acc;
    }

    ;
    public static void main(String[] args) {
        AccountDB adb = new AccountDB();
        boolean result=adb.checkSignUp("iamhaao1");
        List<Account> list = adb.getAll();

        for (Account account : list) {
            System.out.println(account.toString());
        }
        System.out.println(result);

    }

    public void updateCustomer(Account c) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [Username] = ?\n"
                + "      ,[Password] = ?\n"
                + "      ,[name] =?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[roleId] = ?\n"
                + "      ,[avatar] =?\n"
                + " WHERE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getUsername());
            stmt.setString(2, c.getPassword());
            stmt.setString(3, c.getName());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getAddress());
            stmt.setString(6, c.getPhone());
            stmt.setInt(7, c.getIdRole());
            stmt.setString(8, c.getAvatar());
            stmt.setString(9, c.getUsername());
        } catch (SQLException e) {
        }
    }
    public boolean checkSignUp(String username){
        boolean result=false;
         String sql = "select * from Account where Username=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result=true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }   
        return result;
    }

    public void addAccount(Account acc) {
        String sql="INSERT INTO [dbo].[Account]\n" +
"           ([Username]\n" +
"           ,[Password]\n" +
"           ,[name]\n" +
"           ,[Email]\n" +
"           ,[Address]\n" +
"           ,[Phone]\n" +
"           ,[roleId]\n" +
"           ,[avatar])\n" +
"     VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setString(1,acc.getUsername());
            stmt.setString(2, acc.getPassword());
            stmt.setString(3, acc.getName());
            stmt.setString(4, acc.getEmail());
            stmt.setString(5, acc.getAddress());
            stmt.setString(6, acc.getPhone());
            stmt.setInt(7, acc.getIdRole());
            stmt.setString(8, acc.getAvatar());
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
}
