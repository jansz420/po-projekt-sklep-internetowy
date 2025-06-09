import java.util.Scanner;

/**
 * Reprezentuje urządzenie peryferyjne typu monitor.
 */
public class Monitor extends PeripheralDevice{
    /** Rozdzielczość ekranu, np. "1920x1080". */
    protected String resolution;
    /** Typ matrycy, np. "IPS", "TN", "VA". */
    protected String panelType;
    /** Przekątna ekranu w calach. */
    protected double screenSize;
    /** Częstotliwość odświeżania ekranu w Hz. */
    protected int refreshRate;
    /** Informacja czy monitor ma wbudowane głośniki. */
    protected boolean hasSpeakers;

    /**
     * Konstruktor klasy Monitor.
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
     * @param resolution rozdzielczość ekranu
     * @param panelType typ matrycy
     * @param screenSize przekątna ekranu w calach
     * @param refreshRate częstotliwość odświeżania w Hz
     * @param hasSpeakers informacja o wbudowanych głośnikach
     */
    public Monitor(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, String resolution, String panelType, double screenSize, int refreshRate, boolean hasSpeakers) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.resolution = resolution;
        this.panelType = panelType;
        this.screenSize = screenSize;
        this.refreshRate = refreshRate;
        this.hasSpeakers = hasSpeakers;
    }

    /**
     * Sprawdza, czy monitor nadaje się do gier.
     * @return true jeśli monitor jest odpowiedni do gier, w przeciwnym razie false
     */
    @Override
    public boolean isForGaming(){
        return super.isForGaming() && refreshRate >= 120 && screenSize >= 24 && screenSize <= 32;
    }

    /**
     * Wyświetla rozszerzone informacje o monitorze
     */
    public void displayExtraInfo() {
        super.displayExtraInfo();
        if (this.isForGaming()){
            System.out.println("Idealny wybór dla graczy!");
        }
        System.out.println("Rozdzielczość: " + resolution);
        System.out.printf("Rodzaj matrycy: %s\n", panelType);
        System.out.printf("Przekątna ekranu: %.1f\n", screenSize);
        System.out.printf("Częstotliwość odświeżania: %d\n", refreshRate);
        System.out.printf("Wbudowane głośniki: %s\n", hasSpeakers ? "tak" : "nie");
    }

    /**
     * Wyświetla listę opcji dostępnych do edycji przez użytkownika.
     */
    protected void showListToEdit() {
        super.showListToEdit();
        System.out.print("\t\t17. Rozdzielczość");
        System.out.println("\t\t18. Rodzaj matrycy");
        System.out.print("19. Przekątna ekranu");
        System.out.print("\t\t20. Częst. odświeżania");
        System.out.println("\t21. Wbudowane głośniki");
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
                    System.out.print("Podaj nową rozdzielczość: ");
                    resolution = scanner.nextLine();
                    break;
                case 18:
                    System.out.print("Podaj nowy rodzaj matrycy: ");
                    panelType = scanner.nextLine();
                    break;
                case 20:
                    System.out.print("Podaj nową przekątną ekranu: ");
                    if (scanner.hasNextDouble()) { screenSize = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 21:
                    System.out.print("Podaj nową częstotliwość odświeżania: ");
                    if (scanner.hasNextInt()) { refreshRate = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 22:
                    System.out.print("Zmieniono obecność głośników");
                    hasSpeakers = !hasSpeakers;
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }
    }
    /**
     * Zwraca reprezentację monitora w postaci łańcucha znaków
     *
     * @return string z informacjami o monitorze
     */
    public String toString(){
        return String.format("%s;%s;%s;%.1f;%d;%b",super.toString(), resolution, panelType, screenSize, refreshRate, hasSpeakers);
    }
}
