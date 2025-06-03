import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    public ArrayList<Product> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    public void addNewProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===DODAWANIE PRODUKTU===");
        System.out.println("1. Komputer");
        System.out.println("2. Mobilny komputer");
        System.out.println("3. Urządzenie peryferyjne");
        System.out.println("4. Urządzenie audio");
        System.out.println("5. Myszka");
        System.out.println("6. Klawiatura");
        System.out.println("7. Monitor");
        System.out.println("0. Anuluj");
        System.out.println("Podaj typ produktu: ");
        int action = -1;
        if (scanner.hasNextInt()) {
            action = scanner.nextInt();
            scanner.nextLine();
        }
        switch (action) {
            case 1:
                Computer newComputer =  new Computer("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, "brak", "brak", 0, 0, "brak", "brak", "brak");
                newComputer.editProduct();
                products.add(newComputer);
                break;
            case 2:
                MobileDevice newMobile = new MobileDevice("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, "brak", "brak", 0, 0, "brak", "brak", "brak", 0, 0, "brak", 0);
                newMobile.editProduct();
                products.add(newMobile);
                break;
            case 3:
                PeripheralDevice newDevice = new PeripheralDevice("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0);
                newDevice.editProduct();
                products.add(newDevice);
                break;
            case 4:
                AudioDevice newAudioDevice = new AudioDevice("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, "brak", false, 0, 0, 0);
                newAudioDevice.editProduct();
                products.add(newAudioDevice);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                break;
        }
    }

    public void removeProduct(String name){

    }

    public void displayProductList(){
        for (Product product : products) {
            product.displayInfo();
        }
    }

    public Product searchProduct(String name){
        return null;
    }

    public void filterProducts(){

    }

    public void sortListBy(){

    }

    public boolean saveToFile(String fileName){
        return false;
    }

    public boolean readFromFile(String fileName){
        return false;
    }
}
