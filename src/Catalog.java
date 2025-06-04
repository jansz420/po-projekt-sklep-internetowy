import java.security.Key;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    public ArrayList<Product> products;

    public Catalog() {
        products = new ArrayList<>();
    }

    /**
     * Tworzy nowy produkt wybranego typu i dodaje go do listy
     */
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
        System.out.println("0. Zakoncz");
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
                Mouse newMouse = new Mouse("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, 0, 0, "brak");
                newMouse.editProduct();
                products.add(newMouse);
                break;
            case 6:
                Keyboard newKeyboard = new Keyboard("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, "brak", false, "brak", false);
                newKeyboard.editProduct();
                products.add(newKeyboard);
                break;
            case 7:
                Monitor newMonitor = new Monitor("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, "brak", "brak", 0, 0, false);
                newMonitor.editProduct();
                products.add(newMonitor);
                break;
            default:

                break;
        }
    }

    /**
     * Wyszukuje produkt po nazwie
     * @param name nazwa szukanego produktu
     * @return szukany obiekt Product lub null
     */
    public Product searchProduct(String name){
        for (Product product : products) {
            if (product.name.equals(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Usuwa produkt wyszukany na podstawie nazwy
     * @param name nazwa produktu do usuniecia
     */
    public void removeProduct(String name){
        if (searchProduct(name) != null) {
            products.remove(searchProduct(name));
            System.out.println("Produkt " + name + " został usunięty");
        }
        else {
            System.out.println("Nie znaleziono produktu");
        }
    }

    /**
     * Wyswietla interfejs listy produktow
     */
        public void displayProductList(){
            Scanner scanner = new Scanner(System.in);
            int page = 0;
            int productsPerPage = 5;
            int pageAmount = (products.size() + productsPerPage - 1) / productsPerPage;

            while (true) {
                System.out.printf("\n==== Strona %d z %d ====", page + 1, pageAmount);

                int start = page * productsPerPage;  //indeks pierwszego produktu do wysw na stronie
                int end = Math.min(start + productsPerPage, products.size()); //indeks ostatniego

                for (int i = start, id = 1; i < end; i++, id++) {
                    products.get(i).displayInfo();
                    System.out.printf("%d.", id);
                    for (int j = 0; j < 86; j++) {
                        System.out.print("=");
                    }
                }

                int action = -1;
                System.out.println("\n1-5 - Pokaż pełny opis");
                if (page < pageAmount - 1) {
                    System.out.println("6 - Nastepna strona");
                }
                if (page > 0){
                    System.out.println("7 - Poprzednia strona");
                }
                //wyswietl koszyk
                System.out.println("0 - Zakoncz");
                if (scanner.hasNextInt()) {
                    action  = scanner.nextInt();
                    scanner.nextLine();
                }
                int productIndex = page * productsPerPage + (action - 1);
                switch (action) {
                    case 0:

                        return;
                    case 1, 2, 3, 4, 5:
                        products.get(productIndex).displayExtraInfo();
                        productOptions(products.get(productIndex));
                        break;
                    case 6:
                        page++;
                        break;
                    case 7:
                        page--;
                        break;
                    default:
                        System.out.println("Niepoprawna akcja");
                        break;
                }
            }


        }

    public void productOptions(Product product){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Opcje:");
            System.out.println("1 - Dodaj do koszyka");
            System.out.println("2 - cos tam");
            System.out.println("0 - Wroc");
            int action = -1;
            if (scanner.hasNextInt()) {
                action  = scanner.nextInt();
                scanner.nextLine();
            }
            switch(action) {
                case 0:
                    return;
                case 1:

                    System.out.printf("\n%s zostal dodany do koszyka!\n", product.name);
                    break;
                case 2:
                    break;
            }
        }
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
