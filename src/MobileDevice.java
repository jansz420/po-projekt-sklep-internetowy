import java.util.Scanner;

/**
 * Klasa reprezentująca urządzenie mobilne, takie jak laptop, tablet lub smartfon.
 * Dziedziczy po klasie {@link Computer} i dodaje właściwości charakterystyczne dla urządzeń mobilnych,
 * takie jak pojemność baterii, rozmiar ekranu, rozdzielczość oraz częstotliwość odświeżania.
 * Stanowi wyspecjalizowaną wersję komputera przenośnego.
 */

public class MobileDevice extends Computer{
    /**
     * pojemność baterii
     */
    protected int batteryCapacity;
    /**
     * rozmiar ekranu
     */
    protected double screenSize;
    /**
     * rozdzielczość ekranu
     */
    protected String resolution;
    /**
     * częstotliwość odświerzania ekranu
     */
    protected int refreshRate;

    /**
     * Tworzy nowe urządzenie mobilne (np. laptop, tablet, smartfon) z podanymi parametrami.
     *
     * @param name nazwa produktu
     * @param brand marka producenta
     * @param price cena produktu
     * @param stockQuantity ilość sztuk dostępnych w magazynie
     * @param description opis produktu
     * @param color kolor urządzenia
     * @param weight waga w gramach
     * @param size wymiary urządzenia w formacie WysxSzerxDł
     * @param warranty okres gwarancji w miesiącach
     * @param type typ komputera (np. laptop, tablet, smartphone)
     * @param processor nazwa procesora
     * @param ram ilość pamięci RAM w GB
     * @param memory pojemność dysku w GB
     * @param graphicsCardType typ karty graficznej (np. zintegrowana, dedykowana)
     * @param graphicsCardName nazwa karty graficznej
     * @param operatingSystem zainstalowany system operacyjny
     * @param batteryCapacity pojemność baterii w mAh
     * @param screenSize przekątna ekranu w calach
     * @param resolution rozdzielczość ekranu (np. 1920x1080)
     * @param refreshRate częstotliwość odświeżania ekranu w Hz
     */
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
        System.out.print("\t\t\t17. Rozmiar ekranu");
        System.out.println("\t\t\t\t18. Pojemność baterii");
        System.out.print("19. Rozdzielczość ekranu");
        System.out.println("\t\t20. Częstotliwość odświerzania ekranu");
    }

    public void editProduct() {
        while (true){
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
                case 17:
                    System.out.print("Podaj nową pojemność baterii: ");
                    if (scanner.hasNextInt()) { batteryCapacity = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 18:
                    System.out.print("Podaj nowy rozmiar ekranu: ");
                    if (scanner.hasNextDouble()) { screenSize = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                case 19:
                    System.out.print("Podaj nową rozdzielczość: ");
                    resolution = scanner.nextLine();
                    break;
                case 20:
                    System.out.print("Podaj nową częstotliwość odświeżania: ");
                    if (scanner.hasNextInt()) { refreshRate = scanner.nextInt(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }
    }
    public String toString(){
        return String.format("%s;%d;%.1f;%s;%d",super.toString(), batteryCapacity, screenSize, resolution, refreshRate);
    }
}
