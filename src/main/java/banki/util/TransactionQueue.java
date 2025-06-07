package main.java.banki.util;

import main.java.banki.model.Transaction;

public class TransactionQueue {
    private static class Node {
        Transaction transaction;
        Node next;
        Node(Transaction transaction) {
            this.transaction = transaction;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public TransactionQueue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(Transaction transaction) {
        Node newNode = new Node(transaction);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Transaction dequeue() {
        if (front == null) return null;
        Node temp = front;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return temp.transaction;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}