import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product test = new Product("Samsung galaxy S25", "Samsung", 9.00, 10, "Samsung Galaxy S25 to nowoczesny smartfon klasy premium, łączący elegancki design z najnowszymi technologiami. Wyposażony w wydajny procesor Exynos/Qualcomm (w zależności od regionu), jasny i płynny ekran AMOLED o wysokiej częstotliwości odświeżania oraz zaawansowany system aparatów, Galaxy S25 zapewnia doskonałą jakość zdjęć, szybkość działania i długą pracę na baterii. Idealny wybór dla wymagających użytkowników.", "niebieski", 162, "14.7x7.1x0.72", 24);
        Product test2 = new Product(
                "iPhone 16 Pro",
                "Apple",
                4999.00,
                15,
                "iPhone 16 Pro to flagowy smartfon Apple z ekranem Super Retina XDR, potężnym chipsetem A18 Pro i zaawansowanym systemem aparatów z funkcją fotografii obliczeniowej. Obudowa z tytanu, wsparcie dla 5G i nowy interfejs Dynamic Island zapewniają najlepsze wrażenia z użytkowania.",
                "czarny",
                187,
                "14.7x7.1x0.78",
                7
        );
        Product test3 = new Product(
                "Dell XPS 15 (2025)",
                "Dell",
                6999.00,
                8,
                "Dell XPS 15 to ultrabook klasy premium z ekranem 4K OLED, procesorem Intel Core i9-13900H i dedykowaną kartą NVIDIA RTX 4060. Lekka, aluminiowa konstrukcja, klawiatura z podświetleniem i długi czas pracy na baterii sprawiają, że to idealne narzędzie do pracy i rozrywki.",
                "srebrny",
                1350,
                "34.4x23.0x1.8",
                14
        );
        test.displayInfo();
        Catalog catalog = new Catalog();
        catalog.addNewProduct();
        catalog.addNewProduct();
        catalog.addNewProduct();
        catalog.addNewProduct();
        catalog.addNewProduct();
        catalog.addNewProduct();
        catalog.addNewProduct();
        catalog.displayProductList();

        System.out.println();
        System.out.println();
        ShoppingCart cart = new ShoppingCart();
        Order order = new Order(cart);
        cart.addProduct(test, 1);
        cart.addProduct(test, 2);
        cart.cartSummary();
        System.out.println(cart.sumUpPrices());
        cart.removeFromCart(test2);
        System.out.println(cart.cartSummary());
        System.out.println(order.orderSummary());
        order.printToFile();
        cart.addProduct(test2, 2);
        order.printToFile();


        Scanner scanner = new Scanner(System.in);

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Hasło: ");
        String password = scanner.nextLine();

        boolean isAdmin = Admin.verifyAdminInfo(login, password);

        if (isAdmin) {
            Admin admin = new Admin(login, password);
            System.out.println("Zalogowano jako administrator.");

            boolean running = true;
            while (running) {
                System.out.println("\n--- MENU ADMINA ---");
                System.out.println("1. Jakaś opcja ");
                System.out.println("2. Jakaś opcja ");
                System.out.println("0. Wyloguj");
                System.out.print("Wybór: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        //metoda
                        break;
                    case 2:
                        //metoda skibidibi
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór.");
                }
            }

        } else {
            System.out.println("Błąd logowania. Brak uprawnień administratora.");
        }

        scanner.close();

    }
}