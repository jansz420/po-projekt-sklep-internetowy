public class Monitor extends PeripheralDevice{
    protected String resolution;
    protected String panelType;
    protected double screenSize;
    protected int refreshRate;
    protected boolean hasSpeakers;

    public Monitor(String name, String brand, double price, int stockQuantity, String description, String color, double weight, String size, int warranty, boolean isWireless, String powerSupply, String portType, String inputOutput, boolean isWaterproof, boolean hasRgb, double cableLength, String resolution, String panelType, double screenSize, int refreshRate, boolean hasSpeakers) {
        super(name, brand, price, stockQuantity, description, color, weight, size, warranty, isWireless, powerSupply, portType, inputOutput, isWaterproof, hasRgb, cableLength);
        this.resolution = resolution;
        this.panelType = panelType;
        this.screenSize = screenSize;
        this.refreshRate = refreshRate;
        this.hasSpeakers = hasSpeakers;
    }

    @Override
    public boolean isForGaming(){
        return false;
    }

    public String screenFormat(){
        return "temp";
    }

    public void displayExtraInfo() {
        System.out.println("Rozdzielczość: " + resolution);
        System.out.printf("Rodzaj matrycy: %s\n", panelType);
        System.out.printf("Przekątna ekranu: %.1f\n", screenSize);
        System.out.printf("Częstotliwość odświeżania: %d\n", refreshRate);
        System.out.printf("Wbudowane głośniki: %s\n", hasSpeakers ? "tak" : "nie");
        super.displayExtraInfo();
    }

    protected void showListToEdit() {
        super.showListToEdit();
        System.out.println("17. Rozdzielczość");
        System.out.println("18. Rodzaj matrycy");
        System.out.println("19. Przekątna ekranu");
        System.out.println("20. Częstotliwość odświeżania");
        System.out.println("21. Wbudowane głośniki");
    }
}
