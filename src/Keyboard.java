import java.util.Scanner;

public class Keyboard extends PeripheralDevice{
    protected String keyboardType;
    protected boolean hasNumPad;
    protected String keyLayout;
    protected boolean hasWristRest;

    public Keyboard(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, String keyboardType, boolean hasNumPad, String keyLayout, boolean hasWristRest) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.keyboardType = keyboardType;
        this.hasNumPad = hasNumPad;
        this.keyLayout = keyLayout;
        this.hasWristRest = hasWristRest;
    }

    @Override
    public boolean isForGaming(){
        return super.isForGaming() && hasWristRest && keyboardType.equalsIgnoreCase("Mechaniczna");
    }

    public void displayExtraInfo() {
        super.displayExtraInfo();
        if (this.isForGaming()){
            System.out.println("Idealny wybór dla graczy!");
        }
        System.out.println("Typ klawiatury: " + keyboardType);
        System.out.printf("Klawisze numeryczne: %s\n", hasNumPad ? "tak" : "nie");
        System.out.printf("Układ klawiszy: %s\n", keyLayout);
        System.out.printf("Podpórka pod nadgarstki: %s\n", hasWristRest ? "tak" : "nie");
    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.print("\t\t17. Typ klawiatury");
        System.out.println("\t\t18. Klawisze numeryczne");
        System.out.print("19. Układ klawiszy");
        System.out.println("\t\t\t20. Podpórka pod nadgarstki");
    }

    @Override
    public int editProduct() {
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
//            return 1;
        }
    }
    public String toString(){
        return String.format("%s;%s;%b;%s;%b",super.toString(), keyboardType, hasNumPad, keyLayout, hasWristRest);
    }
}
