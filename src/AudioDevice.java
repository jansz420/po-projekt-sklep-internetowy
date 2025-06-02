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
        return isHifi;
    }

    public void displayExtraInfo() {
        System.out.println("Typ urządzenia: " + deviceType);
        System.out.printf("HiFi: %s\n", isHifi ? "tak" : "nie");
        System.out.printf("Impedancja: %.2f\n", impedance);
        System.out.printf("Moc: %.2f\n", power);
        System.out.printf("Pasmo przenoszenia: %.2f\n", frequencyResponse);
        super.displayExtraInfo();

    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("17. Typ urządzenia");
        System.out.println("18. HiFi");
        System.out.println("19. Impedancja");
        System.out.println("20. Moc");
        System.out.println("21. Pasmo przenoszenia");
    }
}
