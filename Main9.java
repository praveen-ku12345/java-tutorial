import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Inserted " + data + " at the beginning.");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Inserted " + data + " at the end.");
    }

    public void insertAtSpecificLocation(int data, int position) {
        Node newNode = new Node(data);
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        Node current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;

        System.out.println("Inserted " + data + " at position " + position + ".");
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Deleted from the beginning.");
    }

    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Deleted from the end.");
    }

    public void deleteFromSpecificLocation(int position) {
        if (position < 0 || head == null) {
            System.out.println("Invalid position or list is empty");
            return;
        }

        if (position == 0) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        if (current == tail) {
            deleteFromEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("Deleted from position " + position + ".");
        }
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert at a specific location");
            System.out.println("4. Delete from the beginning");
            System.out.println("5. Delete from the end");
            System.out.println("6. Delete from a specific location");
            System.out.println("7. Display the list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to insert at the beginning: ");
                    int dataBeginning = scanner.nextInt();
                    doublyLinkedList.insertAtBeginning(dataBeginning);
                    break;

                case 2:
                    System.out.print("Enter the data to insert at the end: ");
                    int dataEnd = scanner.nextInt();
                    doublyLinkedList.insertAtEnd(dataEnd);
                    break;

                case 3:
                    System.out.print("Enter the data to insert: ");
                    int data = scanner.nextInt();
                    System.out.print("Enter the position to insert: ");
                    int position = scanner.nextInt();
                    doublyLinkedList.insertAtSpecificLocation(data, position);
                    break;

                case 4:
                    doublyLinkedList.deleteFromBeginning();
                    break;

                case 5:
                    doublyLinkedList.deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter the position to delete: ");
                    int deletePosition = scanner.nextInt();
                    doublyLinkedList.deleteFromSpecificLocation(deletePosition);
                    break;

                case 7:
                    doublyLinkedList.displayList();
                    break;

                case 8:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}