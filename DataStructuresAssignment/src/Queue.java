public class Queue<T> {
    private T[] queue;       // Array to hold queue elements
    private int front;       // Index of the front element
    private int rear;        // Index of the last element
    private int size;        // Current number of elements
    private int capacity;    // Maximum capacity of the queue

    // Constructor to initialize the queue with a given capacity
    @SuppressWarnings("unchecked")
    public Queue(int capacity){
        this.capacity = capacity;
        queue = (T[]) new Object[capacity]; // Create a generic array via casting
        front = 0;
        rear = -1; // No element is inserted
        size = 0;
    }

    // Inserts an element at the rear of the queue
    public void enqueue(T value) {
        if (size == capacity) {
            // Queue is full, cannot insert
            System.out.println("The queue reached the limit, cannot insert: " + value);
        } else {
            // Use circular increment for rear index
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            System.out.println(value + " successfully inserted in the queue");
        }
    }

    // Removes and returns the element at the front of the queue
    public T dequeue(){
        if (size == 0){
            // Queue is empty
            System.out.println("The queue is empty!");
            return null;
        }
        // Retrieve and remove front element, then move front forward
        T temp = queue[front];
        System.out.println(temp + " successfully deleted from the queue");
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    // Returns the number of elements in the queue
    public int size(){
        return size;
    }

    // Checks if the queue is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns the front element without removing it
    public T first(){
        if (size == 0){
            // Queue is empty
            System.out.println("The queue is empty!");
            return null;
        }
        return queue[front];
    }

    public static void main(String[] args) {
        // Create a queue with capacity 3
        Queue<Integer> queue = new Queue<>(3);

        // Test isEmpty on a new queue: expected true
        System.out.println("Is queue empty? " + queue.isEmpty()); // true

        // Enqueue elements
        queue.enqueue(10); // Expected: "10 successfully inserted in the queue"
        queue.enqueue(20); // Expected: "20 successfully inserted in the queue"
        queue.enqueue(30); // Expected: "30 successfully inserted in the queue"

        // Try to enqueue when full
        queue.enqueue(40); // Expected: "The queue reached the limit, cannot insert: 40"

        // Test size: expected 3
        System.out.println("Queue size: " + queue.size()); // 3

        // Test first element without removing: expected 10
        System.out.println("First element: " + queue.first()); // 10

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: "10 successfully deleted from the queue"
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: "20 successfully deleted from the queue"

        // Test size after two deletions: expected 1
        System.out.println("Queue size: " + queue.size()); // 1

        // Add one more element to check circular nature
        queue.enqueue(40); // Expected: "40 successfully inserted in the queue"

        // Dequeue remaining elements
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: "30 successfully deleted from the queue"
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: "40 successfully deleted from the queue"

        // Try to dequeue from empty queue
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: "The queue is empty!" + null

        // Final check
        System.out.println("Is queue empty? " + queue.isEmpty()); // true
        System.out.println("Queue size: " + queue.size());        // 0
    }
}
