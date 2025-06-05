package main.java.banki.model;

public class Account {
    private String accountId;
    private String holderName;
    private double balance;

    public Account(String accountId, String holderName, double balance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters y Setters
    public String getAccountId() { return accountId; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }

    @Override
    public String toString() {
        return "Cuenta: " + accountId + " | Titular: " + holderName + " | Saldo: $" + balance;
    }
}
