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
        cartProducts.remove(product);
    }

    /**
     * Wyświetla podstawowe informacje o produktach w koszyku
     */
    public void display() {
        for (int i=0;i<cartProducts.size();i++) {
            cartProducts.get(i).displayInfo();
        }
    }

    /**
     * sumuje ceny produktów znajdujących się w koszyku
     * @return suma cen
     */
    public double sumUpPrices() {
        double totalPrice = 0;
        for (int i=0;i<cartProducts.size();i++) {
            totalPrice+=cartProducts.get(i).price;
        }
        return totalPrice;
    }
}
