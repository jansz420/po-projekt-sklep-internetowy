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
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            return 1;
        } else {
            return 0;
        }
    }

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

    public void changePrice(double percentage) {
        price *= percentage;
    }

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

    public void editProduct(){  //to chyba useles bo kazda klasa i tak ma wlasne
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
    public String toString(){
        return String.format("%s;%s;%.2f;%d;%s;%s;%.1f;%s;%d",name, brand, price, stockQuantity, description, color, weight, size, warranty);
    }
}
