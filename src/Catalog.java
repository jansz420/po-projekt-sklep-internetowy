import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Catalog {
    public ArrayList<Product> products;
    private ShoppingCart cart;
    private final Scanner scanner = new Scanner(System.in);
    private boolean filtering = false;
    private ArrayList<Product> productsFilteredOut = new ArrayList<>();
    private boolean isAdmin = false;


    public Catalog() {
        products = new ArrayList<>();
        this.cart = new ShoppingCart();
    }

    /**
     * Tworzy nowy produkt wybranego typu i dodaje go do listy
     */
    public void addNewProduct(){
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
        String action;

        action = scanner.nextLine();
        switch (action) {
            case "0":
                break;
            case "1":
                Computer newComputer =  new Computer("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, "brak", "brak", 0, 0, "brak", "brak", "brak");
                newComputer.editProduct();
                products.add(newComputer);
                break;
            case "2":
                MobileDevice newMobile = new MobileDevice("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, "brak", "brak", 0, 0, "brak", "brak", "brak", 0, 0, "brak", 0);
                newMobile.editProduct();
                products.add(newMobile);
                break;
            case "3":
                PeripheralDevice newDevice = new PeripheralDevice("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0);
                newDevice.editProduct();
                products.add(newDevice);
                break;
            case "4":
                AudioDevice newAudioDevice = new AudioDevice("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, "brak", false, 0, 0, "brak");
                newAudioDevice.editProduct();
                products.add(newAudioDevice);
                break;
            case "5":
                Mouse newMouse = new Mouse("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, 0, 0, "brak");
                newMouse.editProduct();
                products.add(newMouse);
                break;
            case "6":
                Keyboard newKeyboard = new Keyboard("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, "brak", false, "brak", false);
                newKeyboard.editProduct();
                products.add(newKeyboard);
                break;
            case "7":
                Monitor newMonitor = new Monitor("brak", "brak", 0, 0, "brak", "brak", 0, "brak", 0, false, "brak", "brak", "brak", false, false, 0, "brak", "brak", 0, 0, false);
                newMonitor.editProduct();
                products.add(newMonitor);
                break;
            default:
                System.out.println("Nieprawidłowa wartość!");
                break;
        }
    }

    /**
     * Usuwa produkt wyszukany na podstawie nazwy
     * @param index index produktu do usuniecia
     */
    public void removeProduct(int index){
        if (products.get(index) != null) {
            products.remove(products.get(index));
        }
        else {
            System.out.println("Nie znaleziono produktu");
        }
    }

    /**
     * Wyswietla interfejs katalogu
     *
     */
        public void displayProductList(){
            int page = 0;
            int productsPerPage = 5;
            int pageAmount;
            int productIndex;
            String action;

            while (true) {
                pageAmount = (products.size() + productsPerPage - 1) / productsPerPage;


                System.out.print("#################################[ KATALOG  PRODUKTÓW ]#################################");

                if (!products.isEmpty()) {

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
                System.out.println("9 - Sortuj");
                System.out.printf("10 - Filtrowanie %s\n", filtering ? "[AKTYWNE]" : "");   
                if(isAdmin) {
                    System.out.println("\n--- MENU ADMINA ---");
                    System.out.println("11. Dodaj produkt do katalogu ");
                    System.out.println("12. Usuń produkt z katalogu");
                    System.out.println("13. Wyloguj");
                }


                System.out.println("0 - Zakoncz");


                action = scanner.nextLine();

                switch (action) {
                    case "0":
                        return;
                    case "1", "2", "3", "4", "5":
                        productIndex = page * productsPerPage + (parseInt(action) - 1);
                        if (productIndex >= products.size()) {
                            System.out.println("Niepoprawna akcja");
                            break;
                        }
                        products.get(productIndex).displayExtraInfo();
                        productOptions(products.get(productIndex));
                        break;
                    case "6":
                        if (page < pageAmount - 1){
                            page++;
                        }
                        else {
                            System.out.println("Niepoprawna akcja");
                        }
                        break;
                    case "7":
                        if (page > 0){
                            page--;
                        }
                        else {
                            System.out.println("Niepoprawna akcja");
                        }
                        break;
                    case "8":

                        displayCartMenu();
                        break;

                    case "9":
                        sortListBy();
                        break;
                    case "10":
                        filtering = filterProducts();
                        break;
                    case "11":
                        if (isAdmin) {
                            addNewProduct();
                        }
                        else {
                            System.out.println("Niepoprawna akcja");
                        }
                        break;
                    case "12":
                        if (isAdmin) {
                            System.out.println("Wybierz produkt do usunięcia: ");
                            int removeId;
                            if (scanner.hasNextInt()) {
                                removeId = scanner.nextInt();
                            }
                            else {
                                System.out.println("Niepoprawna akcja");
                                break;
                            }
                            productIndex = page * productsPerPage + (removeId - 1);
                            if (productIndex >= products.size()) {
                                System.out.println("Niepoprawna akcja");
                                break;
                            }
                            removeProduct(productIndex);
                        }
                        else {
                            System.out.println("Niepoprawna akcja");
                        }
                        break;
                    case "13":
                        if (isAdmin) {
                            System.out.println("Wylogowano!");
                        }
                        else {
                            System.out.println("Niepoprawna akcja");
                        }
                        isAdmin = false;
                        break;
                    case "420":
                        isAdmin = Admin.adminLogin();
                        break;
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

        while (true) {

            System.out.println("\n==== Koszyk ====");
            System.out.println(cart.cartSummary());
            System.out.println("1 - Usuń wybrany produkt");
            System.out.println("2 - Opróżnij koszyk");
            System.out.println("3 - Złóż zamówienie");
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
                        indexToRemove = parseInt(idxStr) - 1;
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
                        amount = parseInt(amountStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Wprowadź poprawną liczbę.");
                        continue;
                    }

                    cart.removeFromCart(selectedProduct, amount);

                    break;

                case "2":
                    cart.clearCart();
                    break;

                case "3":
                    if (cart.isEmpty()) {
                        System.out.println("Koszyk jest pusty. Nie można złożyć zamówienia.");
                        break;
                    }
                    Order order = new Order(cart);
                    String orderSum="";
                    System.out.println("\n\n==== Dane do Wysyłki ====");
                    orderSum = order.orderSummary();
                    System.out.println(orderSum);

                    for (Map.Entry<Product, Integer> entry : cart.getGroupedProducts().entrySet()) {
                        Product p = entry.getKey();
                        int qty = entry.getValue();
                        int result = p.reduceStockQuantity(qty);
                        if (result == 0) {
                            System.out.printf("Nie udało się zaktualizować stanu magazynowego produktu: %s\n", p.name);
                        }
                    }
                    while (true) {
                        System.out.println("\n1 - Zapisz podsumowanie do pliku");
                        System.out.println("2 - Zmień Dane ");
                        System.out.println("0 - Wróć");
                        System.out.print("Wybierz: ");
                        String choice = scanner.nextLine();

                        if (choice.equals("1")) {
                            order.printToFile(orderSum);
                            break;
                        } else if (choice.equals("2")) {
                            orderSum=order.orderSummary();
                            System.out.println(orderSum);
                            //break;
                        } else if (choice.equals("0")) {
                            break;
                        } else {
                            System.out.println("Niepoprawny wybór. Wpisz 2 lub 1 lub 0.");
                        }
                    }
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
        String action;
        while (true){
            System.out.println("\nOpcje:");
            if (!isAdmin) {
                System.out.println("1 - Dodaj do koszyka");
                System.out.println("2 - Usuń z koszyka");
            }
            else {
                System.out.println("\n--- MENU ADMINA ---");
                System.out.println("3 - Edytuj produkt");
            }

            System.out.println("0 - Wroc");

            action = scanner.nextLine();

            switch(action) {
                case "0":
                    return;
                case "1":
                    System.out.println("Podaj ilość sztuk: ");
                    int quantity  = scanner.nextInt();
                    scanner.nextLine();
                    this.cart.addProduct(product, quantity);
                    System.out.printf("\n%s został dodany do koszyka!\n", product.name);
                    break;
                case "2":
                    System.out.println("Podaj ilość sztuk do usunięcia: ");
                    int quantityRm  = scanner.nextInt();
                    scanner.nextLine();
                    this.cart.removeFromCart(product,quantityRm);
                    System.out.printf("\n%s został usunięty z koszyka!\n", product.name);
                    break;
                case "3":
                    if (isAdmin){
                        product.editProduct();
                    }
                    else {
                        System.out.println("Niepoprawna akcja");
                    }
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
        String action;

        action = scanner.nextLine();
        switch (action) {
            case "0":
                if (filtering){
                    products.addAll(productsFilteredOut);
                    productsFilteredOut.clear();
                }
                return false;
            case "1":
                for (int i = 0; i < products.size(); i++) {
                    if (!(products.get(i) instanceof Computer)) {
                        productsFilteredOut.add(products.get(i));
                        products.remove(products.get(i--));
                    }
                }
                return true;
            case "2":
                for (int i = 0; i < products.size(); i++) {
                    if (!(products.get(i) instanceof PeripheralDevice)) {
                        productsFilteredOut.add(products.get(i));
                        products.remove(products.get(i--));
                    }
                }
                return true;
            case "3":
                for (int i = 0; i < products.size(); i++) {
                    if (!(products.get(i) instanceof AudioDevice)) {
                        productsFilteredOut.add(products.get(i));
                        products.remove(products.get(i--));
                    }
                }
                return true;
            case "4":
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
     * Wywoluje interfejs sortowania katalogu
     */
    public void sortListBy(){
//        Scanner scanner = new Scanner(System.in);
        System.out.println("Opcje:");
        System.out.println("1 - Sortuj alfabetycznie");
        System.out.println("2 - Sortuj cenowo (rosnąco)");
        System.out.println("3 - Sortuj cenowo (malejąco)");
        System.out.println("0 - Wroc");
        String action;

        action = scanner.nextLine();
        switch(action) {
            case "0":
                return;
            case "1":
                Collections.sort(products, new Comparator<>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return p1.name.compareTo(p2.name);
                    }
                });
                break;
            case "2":
                Collections.sort(products, new Comparator<>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return Double.compare(p1.price, p2.price);
                    }
                });
                break;
            case "3":
                Collections.sort(products, new Comparator<>() {
                    @Override
                    public int compare(Product p1, Product p2) {
                        return Double.compare(p2.price, p1.price);
                    }
                });
                break;
            default:
                System.out.println("Niepoprawna akcja");
                break;
        }
    }

    public boolean saveToFile() throws IOException {
        try (
            PrintWriter computerWriter = new PrintWriter(new File("data/Computer.txt"));
            PrintWriter mobileDeviceWriter = new PrintWriter(new File("data/MobileDevice.txt"));
            PrintWriter audioDeviceWriter = new PrintWriter(new File("data/AudioDevice.txt"));
            PrintWriter keyboardWriter = new PrintWriter(new File("data/Keyboard.txt"));
            PrintWriter monitorWriter = new PrintWriter(new File("data/Monitor.txt"));
            PrintWriter mouseWriter = new PrintWriter(new File ("data/Mouse.txt"));
        ) {
            for (Product product : products) {
                if (product instanceof MobileDevice) {
                    mobileDeviceWriter.println(((MobileDevice) product).toString());
                } else if (product instanceof Computer) {
                    computerWriter.println(((Computer) product).toString());
                } else if (product instanceof AudioDevice) {
                    audioDeviceWriter.println(((AudioDevice) product).toString());
                } else if (product instanceof Keyboard) {
                    keyboardWriter.println(((Keyboard) product).toString());
                } else if (product instanceof Monitor) {
                    monitorWriter.println(((Monitor) product).toString());
                } else if (product instanceof Mouse) {
                    mouseWriter.println(((Mouse) product).toString());
                }
            }
            computerWriter.close();
            mobileDeviceWriter.close();
            audioDeviceWriter.close();
            keyboardWriter.close();
            monitorWriter.close();
            mouseWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    private boolean readFromSingleFile(String fileName, String type) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                Product product = null;

                switch (type) {
                    case "Computer":
                        product = new Computer(
                                parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], Double.parseDouble(parts[6]), parts[7], Integer.parseInt(parts[8]),
                                parts[9], parts[10], Integer.parseInt(parts[11]), Integer.parseInt(parts[12]), parts[13],
                                parts[14], parts[15]
                        );
                        break;

                    case "MobileDevice":
                        product = new MobileDevice(
                                parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], Double.parseDouble(parts[6]), parts[7], Integer.parseInt(parts[8]),
                                parts[9], parts[10], Integer.parseInt(parts[11]), Integer.parseInt(parts[12]), parts[13],
                                parts[14], parts[15], Integer.parseInt(parts[16]), Double.parseDouble(parts[17]), parts[18],
                                Integer.parseInt(parts[19])
                        );
                        break;

                    case "Mouse":
                        product = new Mouse(
                                parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], Double.parseDouble(parts[6]), parts[7], Integer.parseInt(parts[8]),
                                Boolean.parseBoolean(parts[9]), parts[10], parts[11], parts[12], Boolean.parseBoolean(parts[13]),
                                Boolean.parseBoolean(parts[14]), Double.parseDouble(parts[15]), Integer.parseInt(parts[16]),
                                Integer.parseInt(parts[17]), parts[18]
                        );
                        break;

                    case "Monitor":
                        product = new Monitor(
                                parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], Double.parseDouble(parts[6]), parts[7], Integer.parseInt(parts[8]),
                                Boolean.parseBoolean(parts[9]), parts[10], parts[11], parts[12], Boolean.parseBoolean(parts[13]),
                                Boolean.parseBoolean(parts[14]), Double.parseDouble(parts[15]), parts[16], parts[17],
                                Double.parseDouble(parts[18]), Integer.parseInt(parts[19]), Boolean.parseBoolean(parts[20])
                        );
                        break;

                    case "AudioDevice":
                        product = new AudioDevice(
                                parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], Double.parseDouble(parts[6]), parts[7], Integer.parseInt(parts[8]),
                                Boolean.parseBoolean(parts[9]), parts[10], parts[11], parts[12], Boolean.parseBoolean(parts[13]),
                                Boolean.parseBoolean(parts[14]), Double.parseDouble(parts[15]), parts[16], Boolean.parseBoolean(parts[17]),
                                Double.parseDouble(parts[18]), Double.parseDouble(parts[19]), parts[20]
                        );
                        break;

                    case "Keyboard":
                        product = new Keyboard(
                                parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                                parts[4], parts[5], Double.parseDouble(parts[6]), parts[7], Integer.parseInt(parts[8]),
                                Boolean.parseBoolean(parts[9]), parts[10], parts[11], parts[12], Boolean.parseBoolean(parts[13]),
                                Boolean.parseBoolean(parts[14]), Double.parseDouble(parts[15]), parts[16], Boolean.parseBoolean(parts[17]),
                                parts[18], Boolean.parseBoolean(parts[19])
                        );
                        break;
                }

                if (product != null) {
                    products.add(product);
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean readFromFile() throws IOException{
            if(
                readFromSingleFile("data/Computer.txt", "Computer") &&
                readFromSingleFile("data/MobileDevice.txt", "MobileDevice") &&
                readFromSingleFile("data/AudioDevice.txt", "AudioDevice") &&
                readFromSingleFile("data/Keyboard.txt", "Keyboard") &&
                readFromSingleFile("data/Monitor.txt", "Monitor") &&
                readFromSingleFile("data/Mouse.txt", "Mouse")
            ) {
                return true;
            } else {
                return false;
            }
    }
}
