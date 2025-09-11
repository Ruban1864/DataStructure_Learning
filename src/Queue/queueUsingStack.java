package Queue;
import java.util.Scanner;

class MyQueue {
    private int[] stack;   // underlying array
    private int front;     // points to front element
    private int back;      // points to last element
    private int size;      // current number of elements
    private int capacity;  // max capacity

    public MyQueue(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        front = 0;
        back = -1;
        size = 0;
    }

    // Insert element into queue
    public void push(int x) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        back = (back + 1) % capacity; // circular increment
        stack[back] = x;
        size++;
        System.out.println(x + " pushed into the queue");
    }

    // Remove element from queue
    public int pop() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = stack[front];
        front = (front + 1) % capacity; // move front
        size--;
        return val;
    }

    // Get the front element
    public int peek() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return stack[front];
    }

    // Check if queue is empty
    public boolean empty() {
        return size == 0;
    }

    // Print queue elements
    public void display() {
        if (empty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(stack[index] + " ");
        }
        System.out.println();
    }
}

public class queueUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyQueue queue = new MyQueue(10); // capacity 10
        int choice, val;

        while (true) {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check Empty");
            System.out.println("5. Display Queue");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    val = sc.nextInt();
                    queue.push(val);
                    break;
                case 2:
                    val = queue.pop();
                    if (val != -1) {
                        System.out.println("Popped: " + val);
                    }
                    break;
                case 3:
                    val = queue.peek();
                    if (val != -1) {
                        System.out.println("Front element: " + val);
                    }
                    break;
                case 4:
                    System.out.println(queue.empty() ? "Queue is empty" : "Queue is not empty");
                    break;
                case 5:
                    queue.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
