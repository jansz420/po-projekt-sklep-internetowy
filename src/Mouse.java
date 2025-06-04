import java.util.Scanner;

public class Mouse extends PeripheralDevice{
    protected int dpi;
    protected int buttonsAmount;
    protected String sensorType;

    public Mouse(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, int dpi, int buttonsAmount, String sensorType) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.dpi = dpi;
        this.buttonsAmount = buttonsAmount;
        this.sensorType = sensorType;
    }

    @Override
    public boolean isForGaming(){
        return false;
    }

    public void displayExtraInfo() {
        System.out.println("DPI: " + dpi);
        System.out.println("Ilość przycisków: " + buttonsAmount);
        System.out.println("Sensor: " + sensorType);
        super.displayExtraInfo();
    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("17. DPI");
        System.out.println("18. Ilość przycisków");
        System.out.println("19. Sensor");
    }

    public int editProduct() {
        while(true) {
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
                    cableLength = scanner.nextDouble();
                    break;
                case 17:
                    System.out.print("Podaj nowe DPI: ");
                    dpi = scanner.nextInt();
                    break;
                case 18:
                    System.out.print("Podaj nową ilość przycisków: ");
                    buttonsAmount = scanner.nextInt();
                    break;
                case 20:
                    System.out.print("Podaj nowy rodzaj sensora: ");
                    sensorType = scanner.nextLine();
                    break;
                default:
                    System.out.println("Błędny numer akcji.");
                    return 0;
            }
//            return 1;
        }


    }
}
