package main.java.banki;

import main.java.banki.model.Account;
import main.java.banki.model.Transaction;
import main.java.banki.model.TransactionType;
import main.java.banki.util.AccountList;
import main.java.banki.util.TransactionQueue;

public class Main {
    public static void main(String[] args) {
        // 1. Crear cuentas usando AccountList (lista enlazada)
        AccountList accounts = new AccountList();
        accounts.add(new Account("C001", "Ramon Castro", 5000));
        accounts.add(new Account("C002", "Javier Moreno", 3000));
        
        // 2. Mostrar todas las cuentas
        accounts.displayAll();
        
        // 3. Procesar transacciones con TransactionQueue (cola)
        TransactionQueue queue = new TransactionQueue();
        queue.enqueue(new Transaction("T1001", TransactionType.DEPOSITO, 2000, "C001"));
        queue.enqueue(new Transaction("T1002", TransactionType.RETIRO, 500, "C002"));
        
        System.out.println("\n--- PROCESANDO TRANSACCIONES ---");
        while (!queue.isEmpty()) {
            Transaction t = queue.dequeue();
            Account acc = accounts.find(t.getAccountId());
            if (acc != null) {
                switch (t.getType()) {
                    case DEPOSITO -> acc.deposit(t.getAmount());
                    case RETIRO -> acc.withdraw(t.getAmount());
                    case TRANSFERENCIA, CREDITO -> 
                        System.out.println(t + " | Operación pendiente (no implementada)");
                }
                System.out.println(t + " | Cuenta actualizada: " + acc.getAccountId());
            }
        }
        
        // 4. Mostrar cuentas después de transacciones
        accounts.displayAll();
    }
}