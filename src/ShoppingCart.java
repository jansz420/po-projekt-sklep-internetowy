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
        for (int i = 0 ; i < amount ; i++) {
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
            System.out.println("Nie znaleziono produktu " + product.name + " w twoim koszyku.");
        }
    }

    /**
     * Sumuje ceny produktów znajdujących się w koszyku
     * @return suma cen
     */
    public double sumUpPrices() {
        double totalPrice = 0;
        for (Product cartProduct : cartProducts) {
            totalPrice += cartProduct.price;
        }
        return totalPrice;
    }

    /**
     * Oblicza wagę wszystkich produktów w koszyku [g]
     * @return waga koszyka
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        for (Product cartProduct : cartProducts) {
            totalWeight += cartProduct.weight;
        }
        return totalWeight;
    }

    /**
     * Oblicza objętość paczki [cm^3]
     * @return objętość paczki
     */
    public double calculateTotalVolume() {
        double totalVolume = 0;
        for (Product cartProduct : cartProducts) {
            String[] dimensions = cartProduct.size.split("x");
            double length = Double.parseDouble(dimensions[0]);
            double width = Double.parseDouble(dimensions[1]);
            double height = Double.parseDouble(dimensions[2]);
            totalVolume += length * width * height;
        }
        return totalVolume;
    }

    /**
     * Wyświetla podstawowe informacje o produktach w koszyku
     */
    public void display() {
        for (Product cartProduct : cartProducts) {
            cartProduct.displayInfo();
        }
    }

    //tutaj jeszcze nie wiem jak chce aby dokładnie wyglądało podsumowanie
    public String cartSummary() {
        String summary= "\n";
//        for (Product cartProduct : cartProducts) {
//            summary += cartProduct.toString() + ", ";
//        }
        for (int i = 0; i < cartProducts.size(); i++) {
            summary += (i+1) + " " + cartProducts.get(i).toString() + "\n";
        }
        summary += "Cena Koszyka "+ this.sumUpPrices()+" zł\n";
        return summary;
    }
}
