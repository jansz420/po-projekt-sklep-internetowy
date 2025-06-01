import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartProducts =new ArrayList<>();

    public ShoppingCart() {

    }
    public ShoppingCart(List<Product> cartProducts) {
        this.cartProducts = cartProducts;
    }

    /**
     * dodaje produkt do koszyka
     * @param product produkt, który ma zostać dodany
     * @param amount ilość
     */
    public void addProduct(Product product, int amount) {
        for (int i=0;i<amount; i++) {
            cartProducts.add(product);
        }
    }

    /**
     * usuwa dany produkt z koszyka
     * @param product produkt do usunięcia
     */
    public void removeFromCart(Product product) {
        if (cartProducts.contains(product)) {
            cartProducts.remove(product);
        } else {
            System.out.println("Produkt " + product.name + " nie znajduję się w twoim koszyku");
        }
    }

    /**
     * Wyświetla podstawowe informacje o produktach w koszyku
     */
    public void display() {
        for (Product cartProduct : cartProducts) {
            cartProduct.displayInfo();
        }
    }

    /**
     * sumuje ceny produktów znajdujących się w koszyku
     * @return suma cen
     */
    public double sumUpPrices() {
        double totalPrice = 0;
        for (Product cartProduct : cartProducts) {
            totalPrice += cartProduct.price;
        }
        return totalPrice;
    }
}
