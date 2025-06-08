import java.util.Scanner;

public class AudioDevice extends PeripheralDevice{
    protected String deviceType;
    protected boolean isHifi;
    protected double impedance;
    protected double power;
    protected double frequencyResponse;

    public AudioDevice(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, String deviceType, boolean isHifi, double impedance, double power, double frequencyResponse) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.deviceType = deviceType;
        this.isHifi = isHifi;
        this.impedance = impedance;
        this.power = power;
        this.frequencyResponse = frequencyResponse;

    }

    @Override
    public boolean isForGaming(){
        return super.isForGaming() && isHifi && (deviceType.equalsIgnoreCase("Sluchawki" ) || deviceType.equalsIgnoreCase("Mikrofon")) && impedance <= 60 && frequencyResponse.equals("20-20000");
    }

    public void displayExtraInfo() {
        super.displayExtraInfo();
        if (this.isForGaming()){
            System.out.println("Idealny wybór dla graczy!");
        }
        System.out.println("Typ urządzenia: " + deviceType);
        System.out.printf("HiFi: %s\n", isHifi ? "tak" : "nie");
        System.out.printf("Impedancja: %.2f\n", impedance);
        System.out.printf("Moc: %.2f\n", power);
        System.out.printf("Pasmo przenoszenia: %.2f\n", frequencyResponse);
    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.print("\t\t17. Typ urządzenia");
        System.out.println("\t\t18. HiFi");
        System.out.print("19. Impedancja");
        System.out.print("\t\t\t\t20. Moc");
        System.out.println("\t\t\t\t\t21. Pasmo przenoszenia");
    }

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
                    System.out.print("Podaj nowy typ urzadzenia audio: ");
                    deviceType = scanner.nextLine();
                    break;
                case 18:
                    System.out.print("Zmieniono HiFi");
                    isHifi = !isHifi;
                    break;
                case 19:
                    System.out.print("Podaj nową impedancje: ");
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
                    if (scanner.hasNextDouble()) { frequencyResponse = scanner.nextDouble(); }
                    else { System.out.print("Nieprawidłowa wartość!"); }
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    break;
            }
        }
    }
    public String toString(){
        return String.format("%s;%s;%b;%d;%d;%s",super.toString(), deviceType, isHifi, impedance, power, frequencyResponse);
    }
}
