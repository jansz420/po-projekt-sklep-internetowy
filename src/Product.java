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

    public void reduceStockQuantity(int quantity) {
        stockQuantity -= quantity;
    }

    public void displayInfo() {

        for (int i=0; i<name.length()+3; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
        System.out.println(name.toUpperCase());
        for (int i=0; i<name.length()+3; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
        System.out.println("Cena: " + price);
        System.out.println(description);
        System.out.println("\nDane techniczne: ");
        System.out.println("Marka: " + brand);
        System.out.println("Dostępność: " + stockQuantity);
        System.out.println("Kolor: " + color);
        System.out.println("Waga: " + weight);
        System.out.println("Rozmiar: " + size);
        System.out.println("Gwarancja: " + warranty + "miesięcy");
    }

    public void changePrice(double percentage) {
        price *= percentage;
    }

    private void showListToEdit() {
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
        this.displayInfo();
        Scanner scanner = new Scanner(System.in);
        this.showListToEdit();
        System.out.println("0. Anuluj");
        int action = 404;
        while (scanner.hasNextInt()) {
            action  = scanner.nextInt();
        }
        switch(action) {
            case 0:
                return 0;
            case 1:
                System.out.print("Podaj nową nazwę: ");
                name = scanner.nextLine();
                break;
            case 2:
                System.out.print("Podaj nową cenę: ");
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
                System.out.print("Podaj nową wagę: ");
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
                System.out.println("ERROR. Something went wrong with input.");
                break;
        }
        return 1;
    }
}
