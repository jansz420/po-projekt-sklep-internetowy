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
}
