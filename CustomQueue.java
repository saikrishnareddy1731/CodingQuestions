package com.test;

public class CustomQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue
    public CustomQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Method to add an element to the end of the queue
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    // Method to remove and return the element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Method to return the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to get the number of elements in the queue
    public int size() {
        return size;
    }

    // Method to print all elements in the queue
    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a queue with a capacity of 5
        CustomQueue queue = new CustomQueue(5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Print the queue
        queue.printQueue(); // Output: Queue: 10 20 30

        // Peek at the front element
        System.out.println("Front element: " + queue.peek()); // Output: Front element: 10

        // Dequeue an element
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: Dequeued element: 10

        // Print the queue
        queue.printQueue(); // Output: Queue: 20 30

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

        // Check the size of the queue
        System.out.println("Queue size: " + queue.size()); // Output: Queue size: 2
    }
}
