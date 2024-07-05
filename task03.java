//task03: atm interface
import java.util.Scanner;
public class atm {

    private BankAccount account;
    public atm(BankAccount account) {
        this.account = account;
    }

    public void atmenu() {
        System.out.println("\n****** ATM Menu ******");
        System.out.println("1. withdraw");
        System.out.println("2. deposit");
        System.out.println("3. check balance");
        System.out.println("4. exit");
        System.out.println("enter your choice: ");
    }

    public void processChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                withdraw(scanner);
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                checkbal();
                break;
            case 4:
                System.out.println("ATM terminated succesfully!");
                break;
            default:
                System.out.println("invalid Choice!");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.println("enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("withdrawal successful!");
        } else {
            System.out.println("insufficient funds!");
        }
    }

    private void deposit(Scanner scanner) {
        System.out.println("enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("deposit successful!");
    }

    private void checkbal() {
        System.out.println("your current balance: Rs." + account.checkbal());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        atm atm = new atm(account);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.atmenu();
            int choice = scanner.nextInt();
            atm.processChoice(choice);
            if (choice == 4) {
                break;
            }
        }
        scanner.close();
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double checkbal() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
