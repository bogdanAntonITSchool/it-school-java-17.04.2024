package oop;

public class BankAccount {
    private String accountHolderName;
    private double balance;
    private String accountNumber;

    public BankAccount(String accountHolderName, double balance, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        balance += amount;
        System.out.println("Deposit successful");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }

        balance -= amount;
        System.out.println("Withdraw successful");
    }

    public void display() {
        System.out.println("-------------------------");
        System.out.println("Account holder name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Account number: " + accountNumber);
        System.out.println("-------------------------");
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        // We can add custom validation here, so by encapsulating the fields, we can control the access to them
        if (accountHolderName == null || accountHolderName.isEmpty()) {
            System.out.println("Invalid account holder name");
            return;
        }
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Invalid balance");
            return;
        }
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            System.out.println("Invalid account number");
            return;
        }
        this.accountNumber = accountNumber;
    }
}
