import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin {
    private String name;
    private String password;

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * metoda sprawdzająca poprawnośc danych
     * @param inputName nazwa admina
     * @param inputPassword hasło admin
     * @return 1 jak dane są poprawne, 0 jak nie są
     */

    public static boolean verifyAdminInfo(String inputName, String inputPassword) {
        File adminLogin = new File("login.txt");
        //System.out.println(adminLogin.getAbsolutePath());
        try (Scanner scanner = new Scanner(adminLogin)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String fileName = parts[0];
                    String filePassword = parts[1];
                    if (fileName.equals(inputName) && filePassword.equals(inputPassword)) {
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + adminLogin.getName());
        } catch (Exception e) {
            System.out.println("Wystąpił błąd podczas czytania pliku: " + e.getMessage());
        }
        return false;
        }

    /**
     * metoda do zwracania nazwy obecnie zalogowanego administratora
     * @return nazwę administratora
     */
    public String getName() {
        return name;
    }


    /**
     * Metoda do logowania Administratora
     */
    public static boolean adminLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Hasło: ");
        String password = scanner.nextLine();

        boolean isAdmin = Admin.verifyAdminInfo(login, password);

        if (isAdmin) {
            Admin admin = new Admin(login, password);
            System.out.println("Zalogowano jako " + admin.getName());
            return true;
        } else {
            System.out.println("Błąd logowania. Brak uprawnień administratora.");
            return false;
        }
    }

}
