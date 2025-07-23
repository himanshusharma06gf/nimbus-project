import java.util.Scanner;

public clas Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.performOperations();
    }

    static class Account {
        private static int idCounter = 1000;
        private static int accNumCounter = 50000;

        private String accountHolderName;
        private String email;
        private String phone;
        private String bankName;
        private String accountNumber;
        private String accountId;
        private double balance;

        public Account(String name, String email, String phone, String bank) {
            this.accountHolderName = name;
            this.email = email;
            this.phone = phone;
            this.bankName = bank;
            this.accountNumber = "ACC" + (++accNumCounter);
            this.accountId = "ID" + (++idCounter);
            this.balance = 0.0;
        }

        public void creditAmount(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Amount Credited: ₹" + amount);
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
            }
        }

        public void debitAmount(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Amount Debited: ₹" + amount);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        }

        public void viewBalance() {
            System.out.println("Current Balance: ₹" + balance);
        }

        public void displayDetails() {
            System.out.println("Account Details:");
            System.out.println("Holder Name: " + accountHolderName);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account ID: " + accountId);
            System.out.println("Balance: ₹" + balance);
        }
    }

    static class AccountManager {
        private Account account;
        private Scanner scanner = new Scanner(System.in);

        public void performOperations() {
            System.out.println("=== Create New Account ===");
            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter Bank Name: ");
            String bank = scanner.nextLine();

            account = new Account(name, email, phone, bank);
            System.out.println("Account created successfully!\n");

            while (true) {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Credit Amount");
                System.out.println("2. Debit Amount");
                System.out.println("3. View Balance");
                System.out.println("4. Display Account Details");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to credit: ");
                        double creditAmount = scanner.nextDouble();
                        account.creditAmount(creditAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to debit: ");
                        double debitAmount = scanner.nextDouble();
                        account.debitAmount(debitAmount);
                        break;
                    case 3:
                        account.viewBalance();
                        break;
                    case 4:
                        account.displayDetails();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you!");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        }
    }
}
