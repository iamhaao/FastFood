/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


public class Product {
    private int idProduct;
    private String name;
    private String description;
    private double price;
    private String image;
    private int status;
    private int idCatory;
    private int quantiry;

    public Product() {
    }

    public Product(int idProduct, String name, String description, double price, String image, int status, int idCatory, int quantiry) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.status = status;
        this.idCatory = idCatory;
        this.quantiry = quantiry;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdCatory() {
        return idCatory;
    }

    public void setIdCatory(int idCatory) {
        this.idCatory = idCatory;
    }

    public int getQuantiry() {
        return quantiry;
    }

    public void setQuantiry(int quantiry) {
        this.quantiry = quantiry;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", name=" + name + ", description=" + description + ", price=" + price + ", image=" + image + ", status=" + status + ", idCatory=" + idCatory + ", quantiry=" + quantiry + '}';
    }
}
