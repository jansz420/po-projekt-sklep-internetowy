import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Catalog {
    public ArrayList<Product> products;
    private ShoppingCart cart;
   // private Order order;
    private final Scanner scanner = new Scanner(System.in);
    private boolean filtering = false;
    public ArrayList<Product> productsFilteredOut = new ArrayList<>();


    public Catalog() {
        products = new ArrayList<>();
        this.cart = new ShoppingCart();
        //this.order = null;
    }

    /**
     * Tworzy nowy produkt wybranego typu i dodaje go do listy
     */
    public void addNewProduct(){
//        Scanner scanner = new Scanner(System.in);
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
     * Wyswietla interfejs katalogu
     * @return true jesli wpisano kod admina
     */
        public boolean displayProductList(){
            int page = 0;
            int productsPerPage = 5;
            int pageAmount;
            int action;

            while (true) {
                action = -1;
                pageAmount = (products.size() + productsPerPage - 1) / productsPerPage;


                System.out.print("#################################[ KATALOG  PRODUKTÓW ]#################################");

                if (!products.isEmpty()) {
//                    System.out.printf("\n====[ Strona %d z %d ]====\n");

                    int start = page * productsPerPage;  //indeks pierwszego produktu do wysw na stronie
                    int end = Math.min(start + productsPerPage, products.size()); //indeks ostatniego
                    int id = 1;

                    for (int i = start; i < end; i++, id++) {
                        products.get(i).displayInfo();
                        System.out.printf("\t\t\t\t\t\t\t\t\t   <([ %d ])>\n", id);
                    }
                    System.out.printf("\n####################################[ Strona %d z %d ]####################################\n", page + 1, pageAmount);


                    //tutaj wrzucic te printy jak maciej balcerzak raczy zrobic wyswietlanie koszyka
                    System.out.printf("1-%d - Pokaż pełny opis\n", id - 1); //poprawka zeby dobrze opcje wyswietlalo
                    if (page < pageAmount - 1) {
                        System.out.println("6 - Nastepna strona");
                    }
                    if (page > 0){
                        System.out.println("7 - Poprzednia strona");
                    }

                }
                else {
                    System.out.println("\n\n\tBrak produktów do wyświetlenia\n");
                    System.out.println("########################################################################################");
                }
                System.out.println("8 - Wyświetl koszyk");
                System.out.println("9 - Złóż zamówienie");

                System.out.println("10 - Sortuj");
                System.out.println("11 - Filtrowanie");
                System.out.println("0 - Zakoncz");

                if (scanner.hasNextInt()) {
                    action  = scanner.nextInt();
                    scanner.nextLine();
                }
                int productIndex = page * productsPerPage + (action - 1);
                switch (action) {
                    case 0:
                        return false;
                    case 1, 2, 3, 4, 5:
                        if (productIndex >= products.size()) {
                            System.out.println("Niepoprawna akcja");
                            break;
                        }
                        products.get(productIndex).displayExtraInfo();
                        productOptions(products.get(productIndex));
                        break;
                    case 6:
                        if (page < pageAmount - 1){
                            page++;
                        }
                        else {
                            System.out.println("Niepoprawna akcja");
                        }
                        break;
                    case 7:
                        if (page > 0){
                            page--;
                        }
                        else {
                            System.out.println("Niepoprawna akcja");
                        }
                        break;
                    case 8:

                        displayCartMenu();
                        break;
                    case 9:
                        //this.order = new Order(cart);
                        //System.out.println(this.order.orderSummary());
                        break;

                    case 10:
                        sortListBy();
                        break;
                    case 11:
                        filtering = filterProducts();
                        break;
                    case 420:
                        return true;

                    default:
                        System.out.println("Niepoprawna akcja");
                        break;
                }
            }


        }


    /**
     * Wyświetla interfejs koszyka
     */
    public void displayCartMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Koszyk ====");
            System.out.println(cart.cartSummary());
            System.out.println("1 - Usuń wybrany produkt");
            System.out.println("2 - Opróżnij koszyk");
            System.out.println("0 - Wróć");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    Map<Product, Integer> productCounts = cart.getGroupedProducts();
                    List<Product> uniqPrdcts = new ArrayList<>(productCounts.keySet());

                    for (int i = 0; i < uniqPrdcts.size(); i++) {
                        Product p = uniqPrdcts.get(i);
                        System.out.printf("%d. %s x%d\n", i + 1, p.name, productCounts.get(p));
                    }

                    System.out.print("Podaj numer produktu do usunięcia: ");
                    String idxStr = scanner.nextLine();
                    int indexToRemove;
                    try {
                        indexToRemove = Integer.parseInt(idxStr) - 1;
                        if (indexToRemove < 0 || indexToRemove >= uniqPrdcts.size()) {
                            System.out.println("Nieprawidłowy numer.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Wprowadź poprawną liczbę.");
                        continue;
                    }

                    Product selectedProduct = uniqPrdcts.get(indexToRemove);

                    System.out.print("Ile sztuk chcesz usunąć: ");
                    String amountStr = scanner.nextLine();
                    int amount;
                    try {
                        amount = Integer.parseInt(amountStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Wprowadź poprawną liczbę.");
                        continue;
                    }

                    cart.removeFromCart(selectedProduct, amount);

                    break;

                case "2":
                    cart.clearCart();
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Niepoprawna akcja. Wybierz 1, 2 lub 0.");
            }
        }
    }


    /**
     * Wyswietla interfejs danego produktu
     * @param product wybrany przez uzytkownika produkt
     */

    public void productOptions(Product product){
        while (true){
//            Scanner scanner = new Scanner(System.in);
            System.out.println("\nOpcje:");
            System.out.println("1 - Dodaj do koszyka");
            System.out.println("2 - Usuń z koszyka");
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
                    System.out.println("Podaj ilość sztuk: ");
                    int quantity  = scanner.nextInt();
                    scanner.nextLine();
                    this.cart.addProduct(product, quantity);
                    System.out.printf("\n%s został dodany do koszyka!\n", product.name);
                    break;
                case 2:
                    System.out.println("Podaj ilość sztuk do usunięcia: ");
                    int quantityRm  = scanner.nextInt();
                    scanner.nextLine();
                    this.cart.removeFromCart(product,quantityRm);
                    System.out.printf("\n%s został usunięty z koszyka!\n", product.name);
                    break;
                default:
                    System.out.println("Niepoprawna akcja");
                    break;
            }
        }
    }

    /**
     * Wlacza filtrowanie listy produktow
     * @return true jesli filtrowanie jest wlaczone
     */
    public boolean filterProducts(){

        System.out.println("Opcje:");
        System.out.println("1 - Komputery");
        System.out.println("2 - Urzadzenia peryferyjne");
        System.out.println("3 - Urządzenia audio");
        System.out.println("4 - Dla graczy");
        System.out.printf("0 - %s\n", filtering ? "Wyłącz filtrowanie" : "Wróć");
        int action = -1;
        if (scanner.hasNextInt()) {
            action  = scanner.nextInt();
            scanner.nextLine();
        }
        switch (action) {
            case 0:
                if (filtering){
                    products.addAll(productsFilteredOut);
                    productsFilteredOut.clear();
                }
                return false;
            case 1:
                for (int i = 0; i < products.size(); i++) {
                    if (!(products.get(i) instanceof Computer)) {
                        productsFilteredOut.add(products.get(i));
                        products.remove(products.get(i--));
                    }
                }
                return true;
            case 2:
                for (int i = 0; i < products.size(); i++) {
                    if (!(products.get(i) instanceof PeripheralDevice)) {
                        productsFilteredOut.add(products.get(i));
                        products.remove(products.get(i--));
                    }
                }
                return true;
            case 3:
                for (int i = 0; i < products.size(); i++) {
                    if (!(products.get(i) instanceof AudioDevice)) {
                        productsFilteredOut.add(products.get(i));
                        products.remove(products.get(i--));
                    }
                }
                return true;
            case 4:
                for (int i = 0; i < products.size(); i++) {
                    if (!(products.get(i) instanceof Computer && ((Computer) products.get(i)).isGaming()) && !(products.get(i) instanceof PeripheralDevice && ((PeripheralDevice) products.get(i)).isForGaming())) {
                        productsFilteredOut.add(products.get(i));
                        products.remove(products.get(i--));
                    }
                }
                return true;
            default:
                System.out.println("Niepoprawna akcja");
                return false;
        }
    }

    /**
     * Wywoluje nterfejs sortowania katalogu
     */
    public void sortListBy(){
//        Scanner scanner = new Scanner(System.in);
        System.out.println("Opcje:");
        System.out.println("1 - Sortuj alfabetycznie");
        System.out.println("2 - Sortuj cenowo (rosnąco)");
        System.out.println("3 - Sortuj cenowo (malejąco)");
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
                Collections.sort(products, new Comparator<>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.name.compareTo(p2.name);
                    }
                });
                break;
            case 2:
                Collections.sort(products, new Comparator<>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return Double.compare(p1.price, p2.price);
                    }
                });
                break;
            case 3:
                Collections.sort(products, new Comparator<>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return Double.compare(p2.price, p1.price);
                    }
                });
            break;
        }
    }

    public boolean saveToFile(String fileName){

        return false;
    }

    public boolean readFromFile(String fileName){
        return false;
    }
}
