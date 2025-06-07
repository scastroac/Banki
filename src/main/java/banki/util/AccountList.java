package main.java.banki.util;

import main.java.banki.model.Account;

public class AccountList {
    private static class Node {
        Account account;
        Node next;
        Node(Account account) {
            this.account = account;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public AccountList() {
        head = null;
        size = 0;
    }

    public void add(Account account) {
        Node newNode = new Node(account);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean remove(String accountId) {
        if (head == null) return false;
        if (head.account.getAccountId().equals(accountId)) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.account.getAccountId().equals(accountId)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Account find(String accountId) {
        Node current = head;
        while (current != null) {
            if (current.account.getAccountId().equals(accountId)) {
                return current.account;
            }
            current = current.next;
        }
        return null;
    }

    public void displayAll() {
        Node current = head;
        System.out.println("\n--- LISTA DE CUENTAS ---");
        while (current != null) {
            System.out.println(current.account);
            current = current.next;
        }
        System.out.println("Total cuentas: " + size);
    }
}