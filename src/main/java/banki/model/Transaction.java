package main.java.banki.model;

public class Transaction {
    private String transactionId;
    private TransactionType type;
    private double amount;
    private String accountId; // Cuenta origen/destino

    public Transaction(String transactionId, TransactionType type, double amount, String accountId) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.accountId = accountId;
    }

    // Getters
    public String getTransactionId() { return transactionId; }
    public TransactionType getType() { return type; }
    public double getAmount() { return amount; }
    public String getAccountId() { return accountId; }

    @Override
    public String toString() {
        return "Transacción: " + transactionId + " | Tipo: " + type + " | Monto: $" + amount;
    }
}