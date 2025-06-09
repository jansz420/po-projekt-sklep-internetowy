import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Klasa reprezentuje koszyk zakupowy użytkownika w sklepie internetowym.
 * Pozwala na dodawanie i usuwanie produktów, zliczanie ich ilości, obliczanie łącznej ceny,
 * objętości i wagi zamówienia oraz generowanie podsumowania koszyka.
 * Produkty dodawane są do koszyka w postaci listy
 */
public class ShoppingCart {
    /**
     * Lista produktów znajdujących się w koszyku użytkownika.
     */
    private List<Product> cartProducts = new ArrayList<>();

    /**
     * Tworzy nowy, pusty koszyk zakupowy.
     */
    public ShoppingCart() {

    }

    /**
     * dodaje produkt do koszyka
     *
     * @param product produkt, który ma zostać dodany
     * @param amount  ilość
     */
    public void addProduct(Product product, int amount) {
        for (int i = 0; i < amount; i++) {
            cartProducts.add(product);
        }
    }

    /**
     * Zlicza ilość wystąpienia danego produktu w koszyku
     *
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
     *
     * @param product produkt do usunięcia
     */
    public void removeFromCart(Product product, int amount) {
        if (cartProducts.contains(product)) {
            if (amount > this.countProducts(product)) {
                System.out.println("W twoim koszyku znajdują się tylko " + this.countProducts(product) + " takie produkty");
            } else {
                for (int i = 0; i < amount; i++) {
                    cartProducts.remove(product);
                }
                System.out.printf("Usunięto %d sztuk produktu %s z koszyka.\n", amount, product.name);
            }
        } else {
            System.out.println("Nie znaleziono produktu " + product.name + " w twoim koszyku.");
        }
    }

    /**
     * Sumuje ceny produktów znajdujących się w koszyku
     *
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
     *
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
     *
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
     *
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
     * sprawdza czy koszyk jest pusty
     * @return 1 jak jest pusty, 0 jak ma jakiś produkt/y
     */

    public boolean isEmpty() {
        return cartProducts.isEmpty();
    }

    /**
     * Tworzenie podsumowania koszyka, które zawiera najistotniejsze informacje i łączną cenę
     *
     * @return podsumowanie koszyka
     */
    public String cartSummary() {
        if (this.isEmpty()){
            return "\n=====================================\n" + "           Koszyk jest pusty         \n" + "=====================================\n";
        }
        StringBuilder summary = new StringBuilder();
        summary.append("\n=========================================================================================\n");
        summary.append("| Nr | Nazwa              | Marka        | Kolor        | Gwarancja | Cena [zł] | Ilość | \n");
        summary.append("-----------------------------------------------------------------------------------------\n");
        Map<Product, Integer> grouped = getGroupedProducts();
        int index = 0;
        for (Map.Entry<Product, Integer> entry : grouped.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            summary.append(String.format("| %2d | %-18s | %-12s | %-12s | %3d mies. | %9.2f | %5d | \n", ++index, product.name, product.brand, product.color, product.warranty, product.price, quantity));
        }
        summary.append("=========================================================================================\n");
        summary.append(String.format("Suma do zapłaty: %.2f zł\n", this.sumUpPrices()));
        return summary.toString();
    }
}

