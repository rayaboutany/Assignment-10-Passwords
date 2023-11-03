import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class assignment10 {

    public static boolean isValidPassword(String password) {
        // Check the length of the password
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Define regular expressions for the four categories
        String lowercaseRegex = ".*[a-z].*";
        String uppercaseRegex = ".*[A-Z].*";
        String numberRegex = ".*[0-9].*";
        String specialSymbolsRegex = ".*[~!@#$%^&*()\\-+=_].*";

        // Count how many categories the password matches
        int categoryCount = 0;

        if (password.matches(lowercaseRegex)) {
            categoryCount++;
        }
        if (password.matches(uppercaseRegex)) {
            categoryCount++;
        }
        if (password.matches(numberRegex)) {
            categoryCount++;
        }
        if (password.matches(specialSymbolsRegex)) {
            categoryCount++;
        }

        // Check if the password matches at least three out of four categories
        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }

        scanner.close();
    }
}