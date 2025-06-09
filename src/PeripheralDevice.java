import java.util.Scanner;

/**
 * Klasa reprezentująca urządzenia peryferyjne.
 * Zawiera atrybuty charakterystyczne dla urządzeń peryferyjnych
 * oraz metody umożliwiające ich prezentację i edycję.
 */
public class PeripheralDevice extends Product {
    /**Określa, czy urządzenie jest bezprzewodowe (true) czy przewodowe (false).*/
    protected boolean isWireless;
    /**Rodzaj zasilania urządzenia (np. bateria, USB, sieciowe).*/
    protected String powerSupply;
    /**Typ interfejsu, np. USB.*/
    protected String portType;
    /**Klasyfikacja urządzenia: wejścia, wyjścia lub wejścia/wyjścia. */
    protected String inputOutput;
    /**Określa, czy urządzenie jest wodoodporne.*/
    protected boolean isWaterproof;
    /**Określa, czy urządzenie posiada podświetlenie RGB.*/
    protected boolean hasRgb;
    /**Długość przewodu w metrach (dotyczy urządzeń przewodowych).*/
    protected double cableLength;

    /**
     * Konstruktor tworzący nowy obiekt typu PeripheralDevice.
     * @param name nazwa urządzenia
     * @param brand marka urządzenia
     * @param price cena urządzenia
     * @param stockQuantity ilość dostępna w magazynie
     * @param description opis urządzenia
     * @param color kolor urządzenia
     * @param weight waga urządzenia w gramach
     * @param size rozmiar urządzenia w formacie WYSxSZERxDŁ [cm]
     * @param warranty długość gwarancji w miesiącach
     * @param isWireless informacja, czy urządzenie jest bezprzewodowe
     * @param powerSupply rodzaj zasilania
     * @param portType typ portu (np. HDMI, DisplayPort)
     * @param inputOutput typ wejścia/wyjścia
     * @param isWaterproof informacja o wodoodporności
     * @param hasRgb informacja o podświetleniu RGB
     * @param cableLength długość kabla w metrach
     */
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
     * Sprawdza, czy urządzenie nadaje się do zastosowań gamingowych.
     * Kryteria: RGB, odpowiednia długość kabla lub bezprzewodowość, oraz port USB.
     *
     * @return true jeśli spełnia wymagania gracza, false w przeciwnym razie
     */
    public boolean isForGaming() {
        return hasRgb && (isWireless || cableLength >= 1.5) && (portType.equalsIgnoreCase("USB"));
    }

    /**
     * Wyświetla szczegółowe informacje o urządzeniu peryferyjnym.
     */
    @Override
    public void displayExtraInfo() {
        super.displayExtraInfo();
        System.out.printf("Łączność: %s\n", isWireless ? "bezprzewodowa" : "przewodowa");
        System.out.println("Zasilanie: " + powerSupply);
        System.out.println("Interfejs: " + portType);
        System.out.println("Typ urządzenia: " + inputOutput);
        System.out.printf("Wodoodporność: %s\n", isWaterproof ? "tak" : "nie");
        System.out.printf("Podświetlenie RGB: %s\n", hasRgb ? "tak" : "nie");
        System.out.printf("Długość przewodu: %.2f\n", cableLength);
    }

    /**
     * Wyświetla listę opcji edycji charakterystycznych dla urządzenia peryferyjnego.
     */
    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("DANE CHARAKTERYSTYCZNE:");
        System.out.print("10. Łączność");
        System.out.print("\t\t\t\t11. Zasilanie");
        System.out.println("\t\t\t12. Interfejs");
        System.out.print("13. Typ urządzenia");
        System.out.print("\t\t\t14. Wodoodporność");
        System.out.println("\t\t15. Podświetlenie RGB");
        System.out.print("16. Długość przewodu");
    }

    /**
     * Umożliwia edycję danych urządzenia przez użytkownika poprzez menu konsolowe.
     */
    @Override
    public void editProduct() {
        while(true) {
            this.displayExtraInfo();
            Scanner scanner = new Scanner(System.in);
            this.showListToEdit();
            System.out.println("\n0. Zakończ");
            int action = -1;
            if (scanner.hasNextInt()) {
                action = scanner.nextInt();
                scanner.nextLine();
            }
            switch (action) {
                case 0:
                    return;
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
                    System.out.print("Zmień typ urządzenia: ");
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
                    System.out.print("Podaj nową długość kabla: ");
                    if (scanner.hasNextDouble()) { cableLength = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }
    }

    /**
     * Zwraca tekstową reprezentację urządzenia peryferyjnego
     * w postaci danych oddzielonych średnikami.
     *
     * @return ciąg znaków z informacjami o urządzeniu
     */
    @Override
    public String toString(){
        return String.format("%s;%b;%s;%s;%s;%b;%b;%.2f",
                super.toString(), isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
    }
}
