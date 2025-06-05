import java.util.Scanner;

public class MobileDevice extends Computer{
    protected int batteryCapacity;
    protected double screenSize;
    protected String resolution;
    protected int refreshRate;

    public MobileDevice(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, String type, String processor, int ram, int memory, String graphicsCardType, String graphicsCardName, String operatingSystem, int batteryCapacity, double screenSize, String resolution, int refreshRate) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, type, processor, ram, memory, graphicsCardType, graphicsCardName, operatingSystem);
        this.batteryCapacity = batteryCapacity;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.refreshRate = refreshRate;
    }

    @Override
    public boolean isGaming() {
        return ram >= 16 && graphicsCardType.compareTo("Dedykowana") == 0 && operatingSystem.contains("Windows") && refreshRate >=90;
    }

    public void displayExtraInfo() {
        super.displayExtraInfo();
        System.out.println("Rozmiar ekranu: " + screenSize + " cali");
        System.out.println("Pojemność baterii: " + batteryCapacity + " mAh");
        System.out.println("Rozdzielczość  ekranu: " + resolution + "[px]");
        System.out.println("Częstotliwość odświerzania ekranu: " + refreshRate + " Hz");
    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("17. Rozmiar ekranu");
        System.out.println("18. Pojemność baterii");
        System.out.println("19. Rozdzielczość ekranu");
        System.out.println("20. Częstotliwość odświerzania ekranu");
    }

    public int editProduct() {
        while (true){
            this.displayInfo();
            Scanner scanner = new Scanner(System.in);
            this.showListToEdit();
            System.out.println("0. Zakończ");
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
                    ram = scanner.nextInt();
                    break;
                case 13:
                    System.out.print("Podaj nową ilość pamięci użytkowej[GB]: ");
                    memory = scanner.nextInt();
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
                case 17:
                    System.out.print("Podaj nową pojemność baterii: ");
                    batteryCapacity = scanner.nextInt();
                    break;
                case 18:
                    System.out.print("Podaj nowy rozmiar ekranu: ");
                    screenSize = scanner.nextDouble();
                    break;
                case 19:
                    System.out.print("Podaj nową rozdzielczość: ");
                    resolution = scanner.nextLine();
                    break;
                case 20:
                    System.out.print("Podaj nową częstotliwość odświeżania: ");
                    refreshRate = scanner.nextInt();
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    return 0;
            }
//            return 1;
        }
    }
    public String toString(){
        return String.format("%s;%d;%.1f;%s;%d",super.toString(), batteryCapacity, screenSize, resolution, refreshRate);
    }
}
