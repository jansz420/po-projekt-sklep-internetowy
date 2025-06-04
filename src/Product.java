import java.util.Scanner;

public class Product {
    protected String name;
    protected String brand;
    protected double price;
    protected int stockQuantity;
    protected String description;
    protected String color;
    protected double weight;
    protected String size;
    protected int warranty;

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

    public void increaseStockQuantity(int quantity) {
        price += quantity;
    }

    public int reduceStockQuantity(int quantity) {
        if (quantity > stockQuantity) {
            stockQuantity -= quantity;
            return 1;
        } else {
            return 0;
        }
    }

    public void displayExtraInfo() {}

    public void displayInfo() {
        for (int i=0; i<86; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
        System.out.printf("| %-20s | Cena: %8.2f zł | Dostępność: %3d szt | Marka: %-12s |\n", name.toUpperCase(), price, stockQuantity, brand);
//        System.out.printf(" | Cena: %.2f zł", price);
//        System.out.printf(" | Dostępność: %d szt", stockQuantity);
//        System.out.printf(" | Marka: %s |\n", brand);
        for (int i=0; i<88; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
//        System.out.printf("Cena: %.2f zł\n", price);
//        System.out.println("Dostępność: " + stockQuantity + " szt");
//        System.out.println(description);
//        System.out.println("\nDane techniczne: ");
//        System.out.println("Marka: " + brand);
//        displayExtraInfo();
//        System.out.println("Kolor: " + color);
//        System.out.println("Waga: " + weight + " g");
//        System.out.println("Rozmiar: " + size + " [cm]");
//        System.out.println("Gwarancja: " + warranty + " mies.");
    }

    public void changePrice(double percentage) {
        price *= percentage;
    }

    protected void showListToEdit() {
        System.out.println("Co chcesz zmienić?:");
        System.out.println("1. Nazwę produktu");
        System.out.println("2. Cenę");
        System.out.println("3. Opis");
        System.out.println("4. Stan na magazynie");
        System.out.println("5. Markę");
        System.out.println("6. Kolor");
        System.out.println("7. Wagę");
        System.out.println("8. Rozmiar");
        System.out.println("9. Gwarancję");
    }

    public int editProduct(){
        while (true){
            this.displayInfo();
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
                    return 0;
                case 1:
                    System.out.print("Podaj nową nazwę: ");
                    name = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Podaj nową cenę[zł]: ");
                    price = scanner.nextDouble();
                    break;
                case 3:
                    System.out.print("Podaj nowy opis: ");
                    description = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Podaj nową liczbę produktu na magazynie: ");
                    stockQuantity = scanner.nextInt();
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
                    weight = scanner.nextDouble();
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
                    return 0;
            }
//            return 1;
        }

    }

    @Override
    public String toString(){
        return String.format("Produkt[nazwa: %s, kolor: %s, cena: %.2f zł, Dostępność: %d szt]",name, color, price, stockQuantity);
    }
}
