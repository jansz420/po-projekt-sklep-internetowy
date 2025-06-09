import java.util.Scanner;

/**
 * Klasa bazowa dla wszystkich produktów.
 * Zawiera uniwersalne pola oraz podstawowe implementacje metod,
 * które są nadpisywane w klasach pochodnych.
 * Może być używana jako samodzielny produkt, jednak nie jest to zalecane,
 * ponieważ nie reprezentuje konkretnego typu produktu i nie zawiera
 * specyficznych atrybutów niezbędnych do jego pełnego opisu.
 * Zaleca się korzystanie z klas dziedziczących, które rozszerzają funkcjonalność tej klasy.
 */
public class Product {

    /**
     * nazwa produktu
     */
    protected String name;

    /**
     * marka producenta
     */
    protected String brand;

    /**
     * cena produktu
     */
    protected double price;

    /**
     * ilość sztuk dostępnych w magazynie
     */
    protected int stockQuantity;

    /**
     * szczegółowy opis produktu
     */
    protected String description;

    /**
     * kolor urządzenia
     */
    protected String color;

    /**
     * waga urządzenia w gramach
     */
    protected double weight;

    /**
     * rozmiar urządzenia w formacie WysokośćxSzerokośćxDługość
     */
    protected String size;

    /**
     * okres gwarancji (w miesiącach)
     */
    protected int warranty;

    /**
     * Tworzy nowy obiekt klasy Computer z określonymi parametrami.
     *
     * @param name nazwa produktu
     * @param brand marka producenta
     * @param price cena produktu
     * @param stockQuantity ilość sztuk dostępnych w magazynie
     * @param description szczegółowy opis produktu
     * @param color kolor urządzenia
     * @param weight waga urządzenia w gramach
     * @param size rozmiar urządzenia w formacie WysxSzerxDł
     * @param warranty okres gwarancji (w miesiącach)
     */
    public Product(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.color = color;
        this.weight = weight;
        this.size = size;
        this.warranty = warranty;
    }

    /**
     * Zwiększa ilość sztuk produktów dostępnych w magazynie.
     *
     * @param quantity ilość produktów do dodania
     */
    public void increaseStockQuantity(int quantity) {
        price += quantity;
    }

    /**
     * Zmniejsza ilość sztuk produktów dostępnych w magazynie.
     * @param quantity ilość produktów do usunięcia
     *
     * @return 1 jeśli poprawnie wykonano zadanie,
     * 0 w przypadku próby odjęcia większej liczby niż dostępna na magazynie.
     */
    public int reduceStockQuantity(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Wyświetla dodatkowe dane (opis produktu i dane techniczne)
     */
    public void displayExtraInfo() {
        displayInfo();
        System.out.printf("Opis produktu: \n%s\n", description);
        System.out.println("\nDANE TECHNICZNE:");
        System.out.printf("Marka: %s\t\t\t\t", brand);
        System.out.printf("Kolor: %s\t\t\t",color);
        System.out.println("Waga: " + weight + " g");
        System.out.printf("Rozmiar: %s [cm]\t\t", size);
        System.out.println("Gwarancja: " + warranty + " mies.");
        System.out.println("\nDANE CHARAKTERYSTYCZNE:");
    }

    /**
     * Wyświetla podstawowe informacje o produkcie
     */
    public void displayInfo() {
        System.out.print("\n");
        for (int i=0; i<88; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
        System.out.printf("| %-20s | Cena: %8.2f zł | Dostępność: %3d szt | Marka: %-12s |\n", name.toUpperCase(), price, stockQuantity, brand);
        for (int i=0; i<88; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    /**
     * Zmienia cenę produktu o podany procent.
     *
     * @param percentage procent z ceny do odjęcia
     */
    public void changePrice(double percentage) {
        price -= price * percentage;
    }

    /**
     * Wyświetla listę pól produtku do edytowania.
     * Używane do metody editProduct.
     */
    protected void showListToEdit() {
        System.out.println("Co chcesz zmienić?:");
        System.out.print("1. Nazwę produktu\t\t");
        System.out.print("2. Cenę\t\t\t");
        System.out.println("3. Opis");
        System.out.print("4. Stan na magazynie\t");
        System.out.print("5. Markę\t\t");
        System.out.println("6. Kolor");
        System.out.print("7. Wagę\t\t\t\t\t");
        System.out.print("8. Rozmiar\t\t");
        System.out.println("9. Gwarancję");
    }

    /**
     * Generuje cały panel do edytowania wszystkich pól produktu.
     * Działa aż do wyłączenia przez użytkownika.
     */
    public void editProduct(){
        while (true){
            this.displayExtraInfo();
            Scanner scanner = new Scanner(System.in);
            this.showListToEdit();
            System.out.println("0. Anuluj");
            int action = -1;
            if (scanner.hasNextInt()) {
                action  = scanner.nextInt();
                scanner.nextLine();
            }
            switch(action) {
                case 0:
                    return;
                case 1:
                    System.out.print("Podaj nową nazwę: ");
                    name = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Podaj nową cenę[zł]: ");
                    if (scanner.hasNextDouble()) { price = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 3:
                    System.out.print("Podaj nowy opis: ");
                    description = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Podaj nową liczbę produktu na magazynie: ");
                    if (scanner.hasNextInt()) { stockQuantity = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 5:
                    System.out.print("Podaj nową markę: ");
                    brand = scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Podaj nowy kolor: ");
                    color = scanner.nextLine();
                    break;
                case 7:
                    System.out.print("Podaj nową wagę[g]: ");
                    if (scanner.hasNextDouble()) { weight = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 8:
                    System.out.print("Podaj nowy rozmiar (WYS[cm]xSZER[cm]xDŁ[cm]: ");
                    size = scanner.nextLine();
                    break;
                case 9:
                    System.out.print("Podaj nową długość gwarancji(ile miesięcy): ");
                    warranty = scanner.nextInt();
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }

    }

    @Override
    /**
     * Generuje linie tekstu, która jest w formacie używanym przez baze danych i funkcje z nią związane.
     *
     * @return sformatowaną linię tekstu
     */
    public String toString(){
        return String.format("%s;%s;%.2f;%d;%s;%s;%.1f;%s;%d",name, brand, price, stockQuantity, description, color, weight, size, warranty);
    }
}
