public class DoubleLinkedList<T> {

    // Node class for doubly linked list
    private class Node {
        T data; // Data stored in the node
        Node next; // Pointer to the next node
        Node prev; // pointer to the previous node

        // Node constructor
        Node(T value) {
            this.data = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head, tail;

    // Constructor initialise an empty list
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    // Inserts a new node with the given value at the front of the list
    public void insert_front(T value) {
        Node newNode = new Node(value); // Create a new node
        newNode.next = head; // New node points to the current head
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode; // Update head to new node
        // If the list is empty, tail is also a new node
        if(tail == null) {
            tail = newNode;
        }
    }

    // Inserts a new node with the given value at the end of the list
    public void insert_end(T value){
        Node newNode = new Node(value);
        newNode.prev = tail; // New node's prev pointer points to current tail
        if(tail != null) {
            tail.next = newNode; // Link the new node after the tail
        }
        tail = newNode; // update tail pointer
        // If the list is empty, head and tail are the same
        if (head == null) {
            head = tail = newNode;
        }
    }

    // Deletes the first occurrence of a node with the given value from the list
    public void delete(T value) {
        Node current = head;

        // Handle empty list
        if (head == null) {
            return;
        }

        // Traverse the list to find the node to delete, keeping track of the previous node
        while(current != null &&
                !((current.data == null && value == null) ||
                        (current.data != null && current.data.equals(value)))){
            current = current.next;
        }

        // Exits if no node is found
        if (current == null) {
            return;
        }

        // If the node to delete is the head
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        // If the node to delete is the tail
        if (current == tail) {
            tail = tail.prev; // Move tail backward
            tail.next = null; // Tail's next pointer is null
            return;
        }
        // If the node is in the middle bypass from both sides
        current.prev.next = current.next; // Bypass current node
        current.next.prev = current.prev; // Adjust the previous pointer

    }

    // Displays all the elements from head to tail
    public void display() {
        StringBuilder sb= new StringBuilder();
        DoubleLinkedList.Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            if (current == tail) break;
            current = current.next; // Move to the next node
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
//         Create a new empty doubly linked list for testing
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();


        // Test: insert_front on empty list
        System.out.println("Test: insert_front(10) on empty list:");
        list.insert_front(10);
        list.display();               // Expected output: 10
        System.out.println("---");

        // Test: insert_front on non-empty list
        System.out.println("Test: insert_front(20) on [10]:");
        list.insert_front(20);
        list.display();               // Expected output: 20 10
        System.out.println("---");

        // Test: insert_end on non-empty list
        System.out.println("Test: insert_end(30) on [20 10]:");
        list.insert_end(30);
        list.display();               // Expected output: 20 10 30
        System.out.println("---");

        // Test: insert_end on empty list (new instance)
        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        System.out.println("Test: insert_end(40) on empty list:");
        list2.insert_end(40);
        list2.display();              // Expected output: 40
        System.out.println("---");

        // Test: delete head node
        System.out.println("Test: delete(20) from [20 10 30]:");
        list.delete(20);
        list.display();               // Expected output: 10 30
        System.out.println("---");

        // Test: delete tail node
        System.out.println("Test: delete(30) from [10 30]:");
        list.delete(30);
        list.display();               // Expected output: 10
        System.out.println("---");

        // Prepare list for middle-deletion test
        // Currently list is [10]
        list.insert_front(5);         // list becomes [5 10]
        list.insert_end(30);          // list becomes [5 10 30]
        list.insert_end(40);          // list becomes [5 10 30 40]
        System.out.println("Test: delete(30) from [5 10 30 40]:");
        list.delete(30);
        list.display();               // Expected output: 5 10 40
        System.out.println("---");

        // Test: delete non-existent value
        System.out.println("Test: delete(99) from [5 10 40]:");
        list.delete(99);
        list.display();               // Expected output: 5 10 40 (unchanged)
        System.out.println("---");

        // Test: delete only element from single-element list
        DoubleLinkedList<Integer> list3 = new DoubleLinkedList<>();
        list3.insert_front(100);      // list3 is [100]
        System.out.println("Test: delete(100) from [100]:");
        list3.delete(100);
        list3.display();              // Expected output: (blank line)
        System.out.println("---");

        // Test: delete on empty list
        System.out.println("Test: delete(5) on empty list:");
        list3.delete(5);
        list3.display();              // Expected output: (blank line, no error)
        System.out.println("---");

        // Edge Case Tests: handling of null values
        DoubleLinkedList<Integer> list4 = new DoubleLinkedList<>();
        System.out.println("Test 12: insert_front(null), insert_end(null), delete(null):");
        list4.insert_front(null);     // list4 is [null]
        list4.insert_end(null);       // list4 is [null, null]
        list4.display();              // Expected output: null null
        list4.delete(null);
        list4.display();              // Expected output: null
        list4.delete(null);
        list4.display();              // Expected output: (blank line)
        System.out.println("---");

    }
}
