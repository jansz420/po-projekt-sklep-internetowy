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
}
