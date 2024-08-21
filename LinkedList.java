package com.test;

public class LinkedList {

	Node head; // head of list

	// Linked list Node.
	static class Node {
		int data;
		Node next;

		// Constructor
		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method to insert a new node
	public static LinkedList insert(LinkedList list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);

		// If the Linked List is empty, then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	// Method to reverse the linked list
	public static LinkedList reverse(LinkedList list) {
		Node prev = null;
		Node current = list.head;
		Node next = null;
		while (current != null) {
			next = current.next; // Store next node
			current.next = prev; // Reverse current node's pointer
			prev = current; // Move pointers one position ahead
			current = next;
		}
		list.head = prev; // Reset the head to the last node
		return list;
	}

	// Method to delete a node by key
	public static LinkedList deleteByKey(LinkedList list, int key) {
		Node currNode = list.head, prev = null;

		// Case 1: If the head node itself holds the key to be deleted
		if (currNode != null && currNode.data == key) {
			list.head = currNode.next; // Changed head
			System.out.println(key + " found and deleted");
			return list;
		}

		// Case 2: If the key is somewhere other than at head
		while (currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}

		// If the key was present, it should be at currNode
		if (currNode != null) {
			prev.next = currNode.next;
			System.out.println(key + " found and deleted");
		}

		// Case 3: The key is not present
		if (currNode == null) {
			System.out.println(key + " not found");
		}

		return list;
	}

	// Method to print the LinkedList.
	public static void printList(LinkedList list) {
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");

			// Go to next node
			currNode = currNode.next;
		}
		System.out.println();
	}

	public static void printHead(LinkedList list) {
		if (list.head != null) {
			System.out.println("Head Node: " + list.head.data);
		} else {
			System.out.println("The list is empty.");
		}
	}

	// Driver code
	public static void main(String[] args) {
		/* Start with the empty list. */
		LinkedList list = new LinkedList();

		// Insert the values
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);

		// Print the LinkedList
		System.out.println("Original LinkedList:");
		printList(list);

		// Reverse the LinkedList
		list = reverse(list);
		System.out.println("Reversed LinkedList:");
		printList(list);

		// Delete node with value 4
		list = deleteByKey(list, 4);
		System.out.println("LinkedList after deleting node 4:");
		printList(list);

		// Delete node with value 10 (not present)
		list = deleteByKey(list, 10);
		System.out.println("LinkedList after trying to delete node 10:");
		printList(list);
		
		
		printHead(list);
	}
}
