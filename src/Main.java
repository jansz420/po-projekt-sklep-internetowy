public class Main {
    public static void main(String[] args) {
        Product test = new Product("Samsung galaxy S25", "Samsung", 3809.00, 10, "Samsung Galaxy S25 to nowoczesny smartfon klasy premium, łączący elegancki design z najnowszymi technologiami. Wyposażony w wydajny procesor Exynos/Qualcomm (w zależności od regionu), jasny i płynny ekran AMOLED o wysokiej częstotliwości odświeżania oraz zaawansowany system aparatów, Galaxy S25 zapewnia doskonałą jakość zdjęć, szybkość działania i długą pracę na baterii. Idealny wybór dla wymagających użytkowników.", "niebieski", 162, "14.7x7.1x0.72", 24);
        test.displayInfo();
        Catalog catalog = new Catalog();
        catalog.addNewProduct();
        catalog.addNewProduct();
//        catalog.addNewProduct();
        catalog.displayProductList();
        catalog.removeProduct("Myszka Krypton");
        catalog.displayProductList();
    }
}