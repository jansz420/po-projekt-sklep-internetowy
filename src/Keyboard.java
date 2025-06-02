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
        return false;
    }

    public void displayExtraInfo() {
        System.out.println("Typ klawiatury: " + keyboardType);
        System.out.printf("Klawisze numeryczne: %s\n", hasNumPad ? "tak" : "nie");
        System.out.printf("Układ klawiszy: %s\n", keyLayout);
        System.out.printf("Podpórka pod nadgarstki: %s\n", hasWristRest ? "tak" : "nie");
        super.displayExtraInfo();

    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("17. Typ klawiatury");
        System.out.println("18. Klawisze numeryczne");
        System.out.println("19. Układ klawiszy");
        System.out.println("20. Podpórka pod nadgarstki");
    }
}
