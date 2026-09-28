import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

    static String[] usernames = {"Lucas", "Kevin", "AN"};
    static String[] passwords = {"kodeLucas", "kodeKevin", "kodeAN"};

    public static void main(String[] args) {
        loginForsøg();
    }

    // Login forsøg
    static void loginForsøg() {
        Scanner input = new Scanner(System.in);

        int forsøg = 3;

        while (forsøg > 0) {

            System.out.print("Indtast brugernavn: ");
            String username = input.nextLine();

            System.out.print("Indtast adgangskode: ");
            String password = input.nextLine();

            int userIndex = findBruger(username);

            if (userIndex != -1 && checkPassword(userIndex, password)) {
                System.out.println("Velkommen " + username + "! Login kl. " + LocalDateTime.now());
                return;
            }

            forsøg--;

            if (forsøg > 0) {
                System.out.println("Forkert login. Du har " + forsøg + " forsøg tilbage.");
            } else {
                System.out.println("Du har brugt alle forsøg. Kontoen er nu låst.");
            }
        }

        input.close();
    }

    // Find bruger
    static int findBruger(String username) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(username)) {
                return i;
            }
        }
        return -1;
    }

// Tjek om passwordet man har indtastet matcher det fra arrayet
    static boolean checkPassword(int userIndex, String password) {
        return passwords[userIndex].equals(password);
    }
}