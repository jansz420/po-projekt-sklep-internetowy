import java.util.Scanner;

public class Computer extends Product {
    protected String type;
    protected String processor;
    protected int ram;
    protected int memory;
    protected String graphicsCardType;
    protected String graphicsCardName;
    protected String operatingSystem;

    public Computer(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, String type, String processor, int ram, int memory, String graphicsCardType, String graphicsCardName, String operatingSystem) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty);
        this.type = type;
        this.processor = processor;
        this.ram = ram;
        this.memory = memory;
        this.graphicsCardType = graphicsCardType;
        this.graphicsCardName = graphicsCardName;
        this.operatingSystem = operatingSystem;
    }

    public boolean isGaming() {
        return ram >= 16 && graphicsCardType.compareTo("Dedykowana") == 0 && operatingSystem.contains("Windows");
    }

    @Override
    public void displayExtraInfo() {
        super.displayExtraInfo();
        System.out.println("Typ urządzenia: " + type);
        System.out.println("Procesor: " + processor);
        System.out.println("Ilość pamięci RAM: " + ram + "GB");
        System.out.println("Ilość pamięci użytkowej: " + memory + "GB");
        System.out.println("Typ karty graficznej: " + graphicsCardType);
        if(graphicsCardType.compareTo("Dedykowana")==0) {
            System.out.println("Nazwa karty graficznej: " + graphicsCardName);
        }
        System.out.println("System operacyjny: " + operatingSystem);
    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("DANE CHARAKTERYSTYCZNE:");
        System.out.print("10. Typ urządzenia");
        System.out.print("\t\t\t\t11. Procesor");
        System.out.println("\t\t\t\t\t12. Ilość pamięci RAM");
        System.out.print("13. Ilość pamięci użytkowej");
        System.out.print("\t\t14. Typ karty graficznej");
        System.out.println("\t\t15. Nazwa karty graficznej");
        System.out.print("16. System operacyjny");
    }

    public int editProduct() {
        while (true){
            this.displayExtraInfo();
            Scanner scanner = new Scanner(System.in);
            this.showListToEdit();
            System.out.println("\n0. Zakończ");
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
                    if (scanner.hasNextInt()) { warranty = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 10:
                    System.out.print("Podaj nowy typ urządzenia: ");
                    type = scanner.nextLine();
                    break;
                case 11:
                    System.out.print("Podaj nowy procesor: ");
                    processor = scanner.nextLine();
                    break;
                case 12:
                    System.out.print("Podaj nową ilość pamięci RAM[GB]: ");
                    if (scanner.hasNextInt()) { ram = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 13:
                    System.out.print("Podaj nową ilość pamięci użytkowej[GB]: ");
                    if (scanner.hasNextInt()) { memory = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 14:
                    System.out.print("Podaj nowy typ karty graficznej: ");
                    graphicsCardType = scanner.nextLine();
                    break;
                case 15:
                    System.out.print("Podaj nową nazwę karty graficznej: ");
                    graphicsCardName = scanner.nextLine();
                    break;
                case 16:
                    System.out.print("Podaj nowy system operacyjny: ");
                    operatingSystem = scanner.nextLine();
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
//            return 1;
        }
    }

    public String toString(){
        return String.format("%s;%s;%s;%d;%d;%s;%s;%s",super.toString(), type, processor, ram, memory, graphicsCardType, graphicsCardName, operatingSystem);
    }
}
