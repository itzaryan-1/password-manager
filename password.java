import java.util.Random;
import java.util.Scanner;

public class password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Password strength checker
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();
        checkPasswordStrength(password);

        // Password suggestion generator
        System.out.println("\nWould you like a strong password suggestion? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            String suggestedPassword = generateStrongPassword(12);
            System.out.println("Suggested strong password: " + suggestedPassword);
        }

        scanner.close();
    }

    public static void checkPasswordStrength(String password) {
        int strengthScore = 0;

        if (password.length() >= 8) {
            strengthScore++;
        }
        if (password.matches(".*[A-Z].*")) {
            strengthScore++;
        }
        if (password.matches(".*[a-z].*")) {
            strengthScore++;
        }
        if (password.matches(".*\\d.*")) {
            strengthScore++;
        }
        if (password.matches(".*[!@#$%^&*()\\-_=+{};:,<.>].*")) {
            strengthScore++;
        }

        // Evaluate password strength based on score
        switch (strengthScore) {
            case 5:
                System.out.println("Password Strength: Very Strong");
                break;
            case 4:
                System.out.println("Password Strength: Strong");
                break;
            case 3:
                System.out.println("Password Strength: Medium");
                break;
            case 2:
            case 1:
                System.out.println("Password Strength: Weak");
                break;
            default:
                System.out.println("Password Strength: Very Weak");
        }
    }

    public static String generateStrongPassword(int length) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+{};:,<.>";
        String allCharacters = upperCase + lowerCase + digits + specialCharacters;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character of each type
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Fill the rest with random characters
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Shuffle the password for randomness
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        Random random = new Random();
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);

        
    }
}
