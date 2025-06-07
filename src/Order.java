import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Order {
    private ShoppingCart cart = new ShoppingCart();
    private double deliveryPrice;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;

    public Order(ShoppingCart cart) {
        this.cart = cart;
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



    public String orderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("\n\n==== Podsumowanie Zamówienia ====");
        summary.append(this.cart.cartSummary());
        summary.append(String.format("Koszt dostawy   : %.2f zł\n", this.getDeliveryPrice()));
        summary.append(String.format("Cena ostateczna : %.2f zł\n", this.getUltimatePrice()));
        summary.append(this.orderDetails());
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

    /**
     * metoda pobierająca dane do zamówienia
     * @return dane klienta
     */
    public String orderDetails() {

        String details= "\n--- DANE ODBIORCY ---\n";
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Imię: ");
            this.customerName = scanner.nextLine().trim();
            if (!this.customerName.isEmpty()) {
                break;
            }
            System.out.println("Imię nie może być puste.");
        }
        details+="Imię: "+this.customerName+"\n";

        while (true) {
            System.out.print("Nazwisko: ");
            this.customerSurname = scanner.nextLine().trim();
            if (!this.customerSurname.isEmpty()) {
                break;
            }
            System.out.println("Nazwisko nie może być puste.");
        }
        details+="Nazwisko: "+this.customerSurname+"\n";

        while (true) {
            System.out.print("Email: ");
            this.customerEmail = scanner.nextLine().trim();
            if (this.customerEmail.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                break;
            }
            System.out.println("Niepoprawny adres email.");
        }
        details+="Adres Email: "+this.customerEmail+"\n";


        while (true) {
            System.out.print("Adres Wysyłki: ");
            this.customerAddress = scanner.nextLine().trim();
            if (this.customerAddress.matches("^(?=(?:.*[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ]){3,}).{5,}$")) {
                break;
            }
            System.out.println("Niepoprawny adres.");
        }
        details+="Adres Wysyłki: "+this.customerAddress+"\n";

        while (true) {
            System.out.print("Numer Telefonu: ");
            this.customerPhoneNumber = scanner.nextLine().trim();
            if (this.customerPhoneNumber.matches("^[0-9]{9}$")) {
                break;
            }
            System.out.println("Numer telefonu powinien składać się z 9 cyfr.");
        }
        details+="Numer Telefonu: "+this.customerPhoneNumber+"\n";

        return details;
    }

}
