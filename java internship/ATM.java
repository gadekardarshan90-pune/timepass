import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount deposited successfully. Updated balance: ruppes%.2f%n", balance);
        } else {
            System.out.println("Please enter a valid amount greater than ruppes0.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid amount greater than ruppes0.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance. Cannot proceed with withdrawal.");
            return false;
        }

        balance -= amount;
        System.out.printf("Amount withdrawn successfully. Remaining balance: ruppes%.2f%n", balance);
        return true;
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(10000.00); // Starting balance in ruppes 

        System.out.println("🙏 Welcome to the ATM!");

        boolean running = true;

        while (running) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1 to 4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current account balance is: %.2f%n ruppes ", account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ruppes");
                    double deposit = scanner.nextDouble();
                    account.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ruppes ");
                    double withdraw = scanner.nextDouble();
                    account.withdraw(withdraw);
                    break;
                case 4:
                    running = false;
                    System.out.println("🙏 Thank you for using the ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid option. Kindly choose a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}
