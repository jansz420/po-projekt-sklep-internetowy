import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //initial

        Catalog catalog = new Catalog();

        if (catalog.readFromFile()) {
            System.out.println("Wczytano wszystkie produkty!");
        } else {
            System.out.println("Niektóre pliki nie zostały wczytane poprawnie.");
        }

        //interface

        System.out.println("\n\t========== SKLEP INTERNETOWY ==========");
        System.out.println("\t---- v0.9 Poczopek Industries inc. ----");
        System.out.println("\t=======================================\n");

        catalog.displayProductList();

        System.out.println("Do zobaczenia ponownie!");
    }
}