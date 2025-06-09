import java.util.Scanner;

/**
 * Klasa reprezentująca urządzenia peryferjne typu audio
 */
public class AudioDevice extends PeripheralDevice {
    /**Typ urządzenia audio, np. "Słuchawki", "Mikrofon"*/
    protected String deviceType;
    /**Czy urządzenie spełnia standard Hi-Fi (wysoka jakość dźwięku)*/
    protected boolean isHifi;
    /**Impedancja urządzenia [Ohm]*/
    protected double impedance;
    /**Moc wyjściowa urządzenia [W]*/
    protected double power;
    /**Pasmo przenoszenia np. "20-20000" (w Hz)*/
    protected String frequencyResponse;
    /**Konstruktor inicjujący wszystkie pola klasy
     * @param name           nazwa produktu
     * @param brand          marka producenta
     * @param price          cena produktu
     * @param stockQuantity  ilość sztuk na magazynie
     * @param description    opis produktu
     * @param color          kolor urządzenia
     * @param weight         waga w gramach
     * @param size           rozmiar urządzenia (np. 10x5x3 cm)
     * @param warranty       długość gwarancji w miesiącach
     * @param isWireless     czy urządzenie jest bezprzewodowe
     * @param powerSupply    typ zasilania
     * @param portType       typ portu (np. USB, Bluetooth)
     * @param inputOutput    typ urządzenia: wejście/wyjście
     * @param isWaterproof   czy urządzenie jest wodoodporne
     * @param hasRgb         czy urządzenie posiada RGB
     * @param cableLength    długość przewodu (w metrach)
     * @param deviceType     typ urządzenia audio
     * @param isHifi         Czy urządzenie spełnia standard Hi-Fi
     * @param impedance      Impedancja urządzenia
     * @param power          Moc wyjściowa urządzeni
     * @param frequencyResponse Pasmo przenoszenia
     */
    public AudioDevice(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, String deviceType, boolean isHifi, double impedance, double power, String frequencyResponse) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.deviceType = deviceType;
        this.isHifi = isHifi;
        this.impedance = impedance;
        this.power = power;
        this.frequencyResponse = frequencyResponse;
    }

    /**
     * Sprawdza, czy dane urządzenie audio nadaje się dla graczy
     *
     * @return true jeśli spełnia kryteria dla graczy
     */
    @Override
    public boolean isForGaming() {
        return super.isForGaming() && isHifi && (deviceType.equalsIgnoreCase("Sluchawki" ) || deviceType.equalsIgnoreCase("Mikrofon")) && impedance <= 60 && frequencyResponse.equals("20-20000");
    }

    /**
     * Wyświetla wszystkie informacje o urządzeniu, w tym audio-specyficzne
     */
    @Override
    public void displayExtraInfo() {
        super.displayExtraInfo();
        if (this.isForGaming()) {
            System.out.println("Idealny wybór dla graczy!");
        }
        System.out.println("Typ urządzenia: " + deviceType);
        System.out.printf("HiFi: %s\n", isHifi ? "tak" : "nie");
        System.out.printf("Impedancja: %.2f\n", impedance);
        System.out.printf("Moc: %.2f\n", power);
        System.out.println("Pasmo przenoszenia: " + frequencyResponse);
    }

    /**
     * Wyświetla listę opcji dostępnych do edycji przez użytkownika.
     */
    @Override
    protected void showListToEdit() {
        super.showListToEdit();
        System.out.print("\t\t17. Typ urządzenia");
        System.out.println("\t\t18. HiFi");
        System.out.print("19. Impedancja");
        System.out.print("\t\t\t\t20. Moc");
        System.out.println("\t\t\t\t\t21. Pasmo przenoszenia");
    }

    /**
     * Umożliwia interaktywną edycję właściwości produktu z poziomu konsoli.
     */
    @Override
    public void editProduct() {
        while (true) {
            this.displayExtraInfo();
            Scanner scanner = new Scanner(System.in);
            this.showListToEdit();
            System.out.println("0. Zakończ");

            int action = -1;
            if (scanner.hasNextInt()) {
                action  = scanner.nextInt();
                scanner.nextLine(); // Przejście po liczbie
            }

            switch(action) {
                case 0:
                    return;
                // przypadki 1–16 obsługiwane w klasie nadrzędnej, ale ponownie zdefiniowane tutaj
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
                    System.out.print("Podaj nowy rozmiar (WYS[cm]xSZER[cm]xDŁ[cm]): ");
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
                    System.out.print("Zmień typ urządzenia (wejścia/wyjścia): ");
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
                // Audio-specyficzne pola
                case 17:
                    System.out.print("Podaj nowy typ urządzenia audio: ");
                    deviceType = scanner.nextLine();
                    break;
                case 18:
                    System.out.print("Zmieniono HiFi");
                    isHifi = !isHifi;
                    break;
                case 19:
                    System.out.print("Podaj nową impedancję: ");
                    if (scanner.hasNextDouble()) { impedance = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 20:
                    System.out.print("Podaj nową moc: ");
                    if (scanner.hasNextDouble()) { power = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 21:
                    System.out.print("Podaj nowe pasmo przenoszenia: ");
                    frequencyResponse = scanner.nextLine();
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }
    }

    /**
     * Zwraca tekstową reprezentację obiektu
     * @return dane w formacie tekstowym oddzielone średnikami
     */
    @Override
    public String toString() {
        return String.format("%s;%s;%b;%.2f;%.2f;%s", super.toString(), deviceType, isHifi, impedance, power, frequencyResponse);
    }
}
