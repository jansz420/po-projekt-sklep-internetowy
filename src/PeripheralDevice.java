import java.util.Scanner;

public class PeripheralDevice extends Product {
    protected boolean isWireless;
    protected String powerSupply;
    protected String portType;
    protected String inputOutput;
    protected boolean isWaterproof;
    protected boolean hasRgb;
    protected double cableLength;


    public PeripheralDevice(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty);
        this.isWireless = isWireless;
        this.powerSupply = powerSupply;
        this.portType = portType;
        this.inputOutput = inputOutput;
        this.isWaterproof = isWaterproof;
        this.hasRgb = hasRgb;
        this.cableLength = cableLength;
    }

    /**
     * Sprawdza czy urzadzenie jest dla graczy na podstawie jego parametrow
     *
     * @return true jesli tak
     */
    public boolean isForGaming() {
        return hasRgb && (isWireless || cableLength >= 1.5) && (portType.equalsIgnoreCase("USB"));
    }

    /**
     * Wyswietla pelne info produktu
     */
    @Override
    public void displayExtraInfo() {
        super.displayExtraInfo();
        System.out.printf("Łączność: %s\n", isWireless ? "bezprzewodowa" : "przewodowa");
        System.out.println("Zasilanie: " + powerSupply);
        System.out.println("Interfejs: " + portType);
        System.out.println("Typ urządzenia: " + inputOutput); //do zmiany
        System.out.printf("Wodoodporność: %s\n", isWaterproof ? "tak" : "nie");
        System.out.printf("Podświetlenie RGB: %s\n", hasRgb ? "tak" : "nie");
        System.out.printf("Długość przewodu: %.2f\n", cableLength);
    }

    /**
     * Wyswietla menu edycji
     */
    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("10. Łączność");
        System.out.println("11. Zasilanie");
        System.out.println("12. Interfejs");
        System.out.println("13. Typ urządzenia");
        System.out.println("14. Wodoodporność");
        System.out.println("15. Podświetlenie RGB");
        System.out.println("16. Długość przewodu");
    }

    /**
     * Edytuje parametry produktu
     *
     * @return nie wiem
     */
    public int editProduct() {
        while (true) {
            this.displayInfo();
            this.displayExtraInfo();
            Scanner scanner = new Scanner(System.in);
            this.showListToEdit();
            System.out.println("0. Zakończ");
            int action = -1;
            if (scanner.hasNextInt()) {
                action = scanner.nextInt();
                scanner.nextLine();
            }
            switch (action) {
                case 0:
                    return 0;
                case 1:
                    System.out.print("Podaj nową nazwę: ");
                    name = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Podaj nową cenę[zł]: ");
                    if (scanner.hasNextDouble()) {price = scanner.nextDouble();}
                    else {System.out.print("Nieprawidłowa wartość!");}
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
                    System.out.print("Zmieniono łączność");
                    isWireless = !isWireless;
                    break;
                case 11:
                    System.out.print("Podaj nowy rodzaj zasilania: ");
                    powerSupply = scanner.nextLine();
                    break;
                case 12:
                    System.out.print("Podaj nowy typ portu: ");
                    portType = scanner.nextLine();
                    break;
                case 13:
                    System.out.print("Zmien typ urzadzenia: ");
                    inputOutput = scanner.nextLine();
                    break;
                case 14:
                    System.out.print("Zmieniono wodoodporność");
                    isWaterproof = !isWaterproof;
                    break;
                case 15:
                    System.out.print("Zmieniono obecność RGB");
                    hasRgb = !hasRgb;
                    break;
                case 16:
                    System.out.print("Podaj nową długość kabla");
                    if (scanner.hasNextDouble()) { cableLength = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
//            return 1;
        }
    }
    public String toString(){
        return String.format("%s;%b;%s;%s;%s;%b;%b;%.2f",super.toString(), isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
    }
}
