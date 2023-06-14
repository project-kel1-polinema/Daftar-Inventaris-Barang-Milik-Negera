package src;

import java.io.Console;
import java.util.Arrays;

public class Login {
    public String[] user = {"Agung", "Dona", "Aldi", "Rafli", "Naura", "Zaidan"};
    public char[][] passwords = {
        {'2', '2', '4', '1', '7', '6', '0', '1', '3', '5'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'}
    };

    public boolean login(String username, char[] password) {
        for (int i = 0; i < user.length; i++) {
            if (username.equals(user[i]) && Arrays.equals(password, passwords[i])) {
                Arrays.fill(password, ' ');
                return true;
            }
        }
        Arrays.fill(password, ' ');
        return false;
    }

    public static void main(String[] args) {
        Login login = new Login();
        Console console = System.console();
        if (console == null) {
            System.err.println("Console tidak tersedia");
            System.exit(1);
        }

        String username = console.readLine("Masukkan username: ");
        char[] password = console.readPassword("Masukkan password: ");

        if (login.login(username, password)) {
            System.out.println("Login berhasil");
        } else {
            System.out.println("Login gagal");
        }
    }
}
