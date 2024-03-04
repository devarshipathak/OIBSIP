import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM System");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.next();

        if (accounts.containsKey(username)) {
            Account account = accounts.get(username);
            System.out.print("Enter your password: ");
            String password = scanner.next();

            if (account.validatePassword(password)) {
                showMainMenu(account);
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        } else {
            System.out.println("Account not found. Please register or try again.");
        }
    }

    private static void register() {
        System.out.print("Enter a new username: ");
        String newUsername = scanner.next();

        if (accounts.containsKey(newUsername)) {
            System.out.println("Username already exists. Please choose another one.");
        } else {
            System.out.print("Enter a password: ");
            String newPassword = scanner.next();
            accounts.put(newUsername, new Account(newUsername, newPassword, 0));
            System.out.println("Registration successful. You can now login.");
        }
    }

    private static void showMainMenu(Account account) {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = scanner.nextInt();
                    if (withdrawAmount <= 0 || withdrawAmount > account.getBalance()) {
                        System.out.println("Invalid amount. Please try again.");
                    } else {
                        account.setBalance(account.getBalance() - withdrawAmount);
                        System.out.println("Withdrawal successful. Your new balance: " + account.getBalance());
                    }
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount. Please try again.");
                    } else {
                        account.setBalance(account.getBalance() + depositAmount);
                        System.out.println("Deposit successful. Your new balance: " + account.getBalance());
                    }
                    break;
                case 4:
                    System.out.println("Logged out. Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}