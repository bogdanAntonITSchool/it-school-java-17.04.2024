package oop;

// We can have as many classes using the same name as long as they are in different packages
public class Main {

    // We can have as many main methods as we want, and we decide which one to run
    public static void main(String[] args) {
        BankAccount user = new BankAccount("John Doe", 1000, "123456");
        // Display the initial state of the account
        user.display();

        // Deposit some money
        user.deposit(500);

        // Withdraw some money
        user.withdraw(200);

        // Display the final state of the account
        user.display();
    }
}
