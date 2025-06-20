import java.util.Scanner;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    static Scanner scanner = new Scanner(System.in);

    public DoublyLinkedList() {
        head = null;
        tail = null;
        System.out.println("An empty doubly linked list is created");
    }

    public DoublyNode createNode() {
        System.out.println("Enter Id and Name of the Person:");
        int id = scanner.nextInt();
        String name = scanner.next();
        Person person = new Person(id, name);
        return new DoublyNode(person);
    }

    // Insert at front of the list
    public void insertAtFront() {
        DoublyNode newNode = createNode();

        if (head == null) { // List is empty
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        System.out.println("Inserted " + newNode + " at front");
    }

    // Insert at rear of the list
    public void insertAtRear() {
        DoublyNode newNode = createNode();

        if (tail == null) { // List is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        System.out.println("Inserted " + newNode + " at rear");
    }

    // Insert at a specific position
    public void insertAtPosition() {
        System.out.print("Enter position to insert at: ");
        int position = scanner.nextInt();

        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtFront();
            return;
        }

        DoublyNode newNode = createNode();
        DoublyNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.getNext();
            count++;
        }

        if (current == null) {
            System.out.println("Position exceeds list size. Inserting at rear.");
            insertAtRear();
            return;
        }

        newNode.setNext(current.getNext());
        newNode.setPrev(current);

        if (current.getNext() != null) {
            current.getNext().setPrev(newNode);
        } else {
            tail = newNode; // Update tail if inserting at end
        }

        current.setNext(newNode);
        System.out.println("Inserted " + newNode + " at position " + position);
    }

    // Delete from front of the list
    public void deleteFromFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Deleted " + head + " from front");

        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
    }

    // Delete from rear of the list
    public void deleteFromRear() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Deleted " + tail + " from rear");

        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }

    // Delete from a specific position
    public void deleteFromPosition() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Enter position to delete from: ");
        int position = scanner.nextInt();

        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            deleteFromFront();
            return;
        }

        DoublyNode current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.getNext();
            count++;
        }

        if (current == null) {
            System.out.println("Position exceeds list size");
            return;
        }

        System.out.println("Deleted " + current + " from position " + position);

        if (current == tail) {
            deleteFromRear();
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
    }

    // Display list from front to rear
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("List contents (front to rear):");
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    // Display list from rear to front
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("List contents (rear to front):");
        DoublyNode current = tail;
        while (current != null) {
            System.out.print(current + " <-> ");
            current = current.getPrev();
        }
        System.out.println("null");
    }
}