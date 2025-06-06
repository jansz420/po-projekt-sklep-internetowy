import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Zlicza ilość wystąpienia danego produktu w koszyku
     * @param product
     * @return liczbę wystąpień w koszyku
     */
    public int countProducts(Product product) {
        int count = 0;
        for (Product p : cartProducts) {
            if (p.equals(product)) {
                count++;
            }
        }
        return count;
    }

    /**
     * usuwa dany produkt z koszyka
     * @param product produkt do usunięcia
     */
    public void removeFromCart(Product product, int amount) {
        if (cartProducts.contains(product)) {
            if (amount > this.countProducts(product)) {
                System.out.println("W twoim koszyku znajdują się tylko "+ this.countProducts(product) + " takie produkty");
            }
            else {
                for(int i = 0 ; i < amount ; i++) {
                    cartProducts.remove(product);
                }
            }
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
     * Opróżnia koszyk
     */
    public void clearCart() {
        cartProducts.clear();
        System.out.println("Koszyk został opróżniony.");
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
     * Grupowanie produktów w koszyku
     * @return mapa gdzie kluczem jest dany produkt, a wartością liczba jego występowania w koszyku
     */
    public Map<Product, Integer> getGroupedProducts() {
        Map<Product, Integer> grouped = new HashMap<>();
        for (Product product : cartProducts) {
            grouped.put(product, grouped.getOrDefault(product, 0) + 1);
        }
        return grouped;
    }

    /**
     * Tworzenie podsumowania koszyka, które zawiera najistotniejsze informacje i łączną cenę
     * @return podsumowanie koszyka
     */
    public String cartSummary() {
        if (cartProducts.isEmpty()) {
            return "Koszyk jest pusty";
        }
        String summary= "\n";
        Map<Product, Integer> grouped = getGroupedProducts();
        int index = 0;
        for (Map.Entry<Product, Integer> entry : grouped.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            summary += (++index) + " " +product.name+" "+product.color+" "+product.price+" zł "+ "x"+quantity+"\n";
        }
        summary += "Cena Koszyka "+ this.sumUpPrices()+" zł\n";
        return summary;
    }
}
