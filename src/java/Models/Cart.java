
package Models;


public class Cart extends Product{
    private int quantityProduct;

    public Cart() {
    }

    public Cart(int quantityProduct, int idProduct, String name, String description, double price, String image, int status, int idCatory, int quantiry) {
        super(idProduct, name, description, price, image, status, idCatory, quantiry);
        this.quantityProduct = quantityProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }
    
    
}
