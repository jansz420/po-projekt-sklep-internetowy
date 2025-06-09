import java.util.Scanner;

/**
 * Reprezentuje urządzenie peryferyjne typu klawiatura.
 */
public class Keyboard extends PeripheralDevice {

    /** Typ klawiatury, np. "mechaniczna", "membranowa". */
    protected String keyboardType;

    /** Informacja, czy klawiatura posiada klawiaturę numeryczną. */
    protected boolean hasNumPad;

    /** Układ klawiszy, np. "QWERTY", "AZERTY", "DVORAK". */
    protected String keyLayout;

    /** Informacja, czy klawiatura ma podpórkę pod nadgarstki. */
    protected boolean hasWristRest;

    /**
     * Konstruktor inicjalizujący wszystkie pola klasy
     * @param name           Nazwa produktu
     * @param brand          Marka producenta
     * @param price          Cena produktu
     * @param stockQuantity  Ilość sztuk na magazynie
     * @param description    Opis produktu
     * @param color          Kolor klawiatury
     * @param weight         Waga klawiatury w gramach
     * @param size           Rozmiar klawiatury (format tekstowy)
     * @param warranty       Długość gwarancji w miesiącach
     * @param isWireless     Czy klawiatura jest bezprzewodowa
     * @param powerSupply    Rodzaj zasilania
     * @param portType       Typ portu (np. USB)
     * @param inputOutput    Typ urządzenia (wejściowe/wyjściowe)
     * @param isWaterproof   Czy klawiatura jest wodoodporna
     * @param hasRgb         Czy klawiatura ma podświetlenie RGB
     * @param cableLength    Długość kabla w metrach
     * @param keyboardType   Typ klawiatury
     * @param hasNumPad      Czy posiada klawiaturę numeryczną
     * @param keyLayout      Układ klawiszy
     * @param hasWristRest   Czy posiada podpórkę pod nadgarstki
     */
    public Keyboard(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, String keyboardType, boolean hasNumPad, String keyLayout, boolean hasWristRest) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.keyboardType = keyboardType;
        this.hasNumPad = hasNumPad;
        this.keyLayout = keyLayout;
        this.hasWristRest = hasWristRest;
    }

    /**
     * Określa, czy klawiatura nadaje się do gier.
     *
     * @return true jeśli klawiatura spełnia wymagania dla graczy, w przeciwnym razie false
     */
    @Override
    public boolean isForGaming() {
        return super.isForGaming() && hasWristRest && keyboardType.equalsIgnoreCase("Mechaniczna");
    }

    /**
     * Wyświetla dodatkowe informacje o klawiaturze
     */
    public void displayExtraInfo() {
        super.displayExtraInfo();
        if (this.isForGaming()) {
            System.out.println("Idealny wybór dla graczy!");
        }
        System.out.println("Typ klawiatury: " + keyboardType);
        System.out.printf("Klawisze numeryczne: %s\n", hasNumPad ? "tak" : "nie");
        System.out.printf("Układ klawiszy: %s\n", keyLayout);
        System.out.printf("Podpórka pod nadgarstki: %s\n", hasWristRest ? "tak" : "nie");
    }

    /**
     * Wyświetla listę opcji dostępnych do edycji przez użytkownika.
     */
    protected void showListToEdit() {
        super.showListToEdit();
        System.out.print("\t\t17. Typ klawiatury");
        System.out.println("\t\t18. Klawisze numeryczne");
        System.out.print("19. Układ klawiszy");
        System.out.println("\t\t\t20. Podpórka pod nadgarstki");
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
                    if (scanner.hasNextDouble()) {
                        price = scanner.nextDouble();
                    } else {
                        System.out.print("Nieprawidłowa wartość!");
                    }
                    break;
                case 3:
                    System.out.print("Podaj nowy opis: ");
                    description = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Podaj nową liczbę produktu na magazynie: ");
                    if (scanner.hasNextInt()) {
                        stockQuantity = scanner.nextInt();
                    } else {
                        System.out.print("Nieprawidłowa wartość!");
                    }
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
                    if (scanner.hasNextDouble()) {
                        weight = scanner.nextDouble();
                    } else {
                        System.out.print("Nieprawidłowa wartość!");
                    }
                    break;
                case 8:
                    System.out.print("Podaj nowy rozmiar (WYS[cm]xSZER[cm]xDŁ[cm]): ");
                    size = scanner.nextLine();
                    break;
                case 9:
                    System.out.print("Podaj nową długość gwarancji(ile miesięcy): ");
                    if (scanner.hasNextInt()) {
                        warranty = scanner.nextInt();
                    } else {
                        System.out.print("Nieprawidłowa wartość!");
                    }
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
                    if (scanner.hasNextDouble()) {
                        cableLength = scanner.nextDouble();
                    } else {
                        System.out.print("Nieprawidłowa wartość!");
                    }
                    break;
                case 17:
                    System.out.print("Podaj nowy typ klawiatury: ");
                    keyboardType = scanner.nextLine();
                    break;
                case 18:
                    System.out.print("Zmieniono obecność NumPada");
                    hasNumPad = !hasNumPad;
                    break;
                case 20:
                    System.out.print("Podaj nowy układ klawiszy: ");
                    keyLayout = scanner.nextLine();
                    break;
                case 21:
                    System.out.print("Zmieniono obecność podpórki pod nadgarstek");
                    hasWristRest = !hasWristRest;
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }
    }

    /**
     * Zwraca reprezentację tekstową klawiatury
     *
     * @return String zawierający dane klawiatury oddzielone średnikami
     */
    @Override
    public String toString() {
        return String.format("%s;%s;%b;%s;%b", super.toString(), keyboardType, hasNumPad, keyLayout, hasWristRest);
    }
}