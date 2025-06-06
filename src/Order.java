import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Order {
    private ShoppingCart cart = new ShoppingCart();
    private double deliveryPrice;
    private String status;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;

    public Order(ShoppingCart cart) {
        this.cart = cart;
        this.status ="Oczekujące";

    }

    /**
     * Oblicza cenę dostawy na podstawie wagi i rozmiarów
     * paczki(mała/średnia/duża/największa). Darmowa dostawa dla zamówień powyżej 400 zł
     * @return cena dostawy
     */
    public double getDeliveryPrice() {
        if (cart.sumUpPrices() > 500.0) {
            deliveryPrice = 0.0;
        }
        else {
            double weightInKg = cart.getTotalWeight() / 1000.0;
            double volume = cart.calculateTotalVolume();

            if (weightInKg <= 1.0 && volume <= 2000.0) {
                deliveryPrice = 7.0;
            } else if (weightInKg <= 5.0 && volume <= 10000.0) {
                deliveryPrice = 15.0;
            } else if (weightInKg <= 10.0 && volume <= 25000.0) {
                deliveryPrice = 25.0;
            } else {
                deliveryPrice = 40.0;
            }
        }
        return deliveryPrice;
    }

    /**
     *  Obliczanie całkowitego kosztu zamówienia (dostawa +
     * wartość koszyka)
     * @return cała wartość zamówienia
     */
    public double getUltimatePrice() {
        return cart.sumUpPrices()+ this.getDeliveryPrice();
    }

    public void changeStatus(String status) {
        this.status = status;
    }


    public String orderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append(this.cart.cartSummary());
        summary.append(String.format("Koszt dostawy   : %.2f zł\n", this.getDeliveryPrice()));
        summary.append(String.format("Cena ostateczna : %.2f zł\n", this.getUltimatePrice()));
        return summary.toString();
    }

    /**
     * Zapisywanie podsumowania zamówienia do pliku
     * @return true przy powodzeniu, false przy błędzie
     */
    public boolean printToFile() {
        File summary = new File("orderSummary.txt");
        try (PrintWriter writer = new PrintWriter(summary)) {
            writer.println(this.orderSummary());
            System.out.println("Pomyślnie zapisano podsumowanie zamówienia.");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Nie można utworzyć pliku: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku: " + e.getMessage());
            return false;
        }
    }
}
