package com.test;

public class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    // Constructor to initialize the stack with a specific size
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // indicates an empty stack
    }

    // Method to add an element to the stack
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow");
        } else {
            stackArray[++top] = value;
        }
    }

    // Method to remove an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1; // return -1 if stack is empty
        } else {
            return stackArray[top--];
        }
    }

    // Method to peek at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }
    
    // Method to get the size of the stack
    public int size() {
        return top + 1;
    }

    // Method to print all elements in the stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Stack with size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Print the stack
        stack.printStack();

        // Peek at the top element
        System.out.println("Top element is: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Print the stack after popping elements
        stack.printStack();
        

        // Check if the stack is empty again
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true

        // Size of the stack after popping all elements
        System.out.println("Stack size: " + stack.size()); // Output: 0
    }
}
