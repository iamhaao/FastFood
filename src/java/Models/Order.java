
package Models;

import java.sql.Date;


public class Order {
    private String idOrder;
    private int idAccount;
    private String date;
    private double price;
    private int idStore;
    private String address;

    public Order() {
    }

    public Order(String idOrder, int idAccount, String date, double price, int idStore, String address) {
        this.idOrder = idOrder;
        this.idAccount = idAccount;
        this.date = date;
        this.price = price;
        this.idStore = idStore;
        this.address = address;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }


    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", idAccount=" + idAccount + ", date=" + date + ", price=" + price + ", idStore=" + idStore + ", address=" + address + '}';
    }

   
    
    
}
