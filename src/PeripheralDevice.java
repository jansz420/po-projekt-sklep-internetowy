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

    public boolean isForGaming() {
        return hasRgb;
    }

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
}
