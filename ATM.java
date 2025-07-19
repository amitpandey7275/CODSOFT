import java.util.Scanner;

// Class representing user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("✅ Successfully withdrawn ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }
}

// ATM Interface Class
public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00);  // starting with ₹1000

        System.out.println("🏦 Welcome to the ATM Machine!");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. 🏧 Withdraw");
            System.out.println("2. 💵 Deposit");
            System.out.println("3. 📊 Check Balance");
            System.out.println("4. ❌ Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }
}
