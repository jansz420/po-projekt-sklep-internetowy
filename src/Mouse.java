import java.util.Scanner;

/**
 * Klasa reprezentująca urządzenie peryferyjne typu mysz komputerowa
 */
public class Mouse extends PeripheralDevice{
    /**Czułość DPI myszy.*/
    protected int dpi;
    /** Liczba przycisków w myszy.*/
    protected int buttonsAmount;
    /**Typ sensora (np. optyczny, laserowy).*/
    protected String sensorType;

    /**
     * Konstruktor inicjalizujący wszystkie pola klasy
     * @param name            nazwa produktu
     * @param brand           marka
     * @param price           cena
     * @param stockQuantity   ilość na magazynie
     * @param description     opis produktu
     * @param color           kolor
     * @param weight          waga w gramach
     * @param size            rozmiar (format tekstowy)
     * @param warranty        gwarancja w miesiącach
     * @param isWireless      czy bezprzewodowa
     * @param powerSupply     sposób zasilania
     * @param portType        typ portu
     * @param inputOutput     typ urządzenia (wejście/wyjście)
     * @param isWaterproof    czy wodoodporna
     * @param hasRgb          czy ma podświetlenie RGB
     * @param cableLength     długość kabla
     * @param dpi             czułość DPI
     * @param buttonsAmount   liczba przycisków
     * @param sensorType      typ sensora
     */
    public Mouse(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, int dpi, int buttonsAmount, String sensorType) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.dpi = dpi;
        this.buttonsAmount = buttonsAmount;
        this.sensorType = sensorType;
    }

    /**
     * Określa, czy mysz nadaje się do gier
     *
     * @return true jeśli mysz spełnia wymagania gracza
     */
    public boolean isForGaming(){
        return super.isForGaming() && dpi >= 1600 && buttonsAmount >= 5 && (sensorType.equalsIgnoreCase("Laserowy")) || (sensorType.equalsIgnoreCase("Optyczny"));
    }

    /**
     * Wyświetla dodatkowe informacje o myszy
     */
    public void displayExtraInfo() {
        super.displayExtraInfo();
        if (this.isForGaming()){
            System.out.println("Idealny wybór dla graczy!");
        }
        System.out.println("DPI: " + dpi);
        System.out.println("Ilość przycisków: " + buttonsAmount);
        System.out.println("Sensor: " + sensorType);
    }
    /**
     * Wyświetla listę opcji dostępnych do edycji przez użytkownika.
     */
    protected void showListToEdit() {
        super.showListToEdit();
        System.out.print("\t\t17. DPI");
        System.out.println("\t\t\t\t\t18. Ilość przycisków");
        System.out.println("19. Sensor");
    }

    /**
     * Umożliwia interaktywną edycję właściwości produktu z poziomu konsoli.
     */
    @Override
    public void editProduct() {
        while(true) {
            this.displayExtraInfo();
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
                case 17:
                    System.out.print("Podaj nowe DPI: ");
                    if (scanner.hasNextInt()) { dpi = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 18:
                    System.out.print("Podaj nową ilość przycisków: ");
                    if (scanner.hasNextInt()) { buttonsAmount = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 20:
                    System.out.print("Podaj nowy rodzaj sensora: ");
                    sensorType = scanner.nextLine();
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }
    }
    /**
     * Zwraca reprezentację tekstową obiektu klasy
     *
     * @return dane myszy jako łańcuch tekstowy
     */
    public String toString(){
        return String.format("%s;%d;%d;%s",super.toString(), dpi, buttonsAmount, sensorType);
    }
}
