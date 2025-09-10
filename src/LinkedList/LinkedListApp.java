package LinkedList;
import java.util.Scanner;

class MyLinkedList {
    private Node head;
    private int size;

    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        return temp.val;
    }

    public void addAtHead(int val) {
        head = new Node(val, head);
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) { addAtHead(val); return; }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) curr = curr.next;
        curr.next = new Node(val, curr.next);
        size++;
    }

    public void deleteFirst() {
        if (head == null) return;
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) temp = temp.next;
            temp.next = null;
        }
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) { deleteFirst(); return; }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) curr = curr.next;
        curr.next = curr.next.next;
        size--;
    }

    public void deleteMiddle() {
        if (head == null || head.next == null) {
            head = null;
            size = 0;
            return;
        }
        int mid = size / 2;
        deleteAtIndex(mid);
    }

    public void reverseList() {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) return true;

        // find middle
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        Node secondHalf = reverse(slow.next);
        Node copySecondHalf = secondHalf;

        // compare
        Node firstHalf = head;
        boolean isPalin = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // restore list
        slow.next = reverse(copySecondHalf);
        return isPalin;
    }

    private Node reverse(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int findMiddle() {
        if (head == null) return -1;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class LinkedListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();
        int choice;

        do {
            System.out.println("\n--- Linked List Operations ---");
            System.out.println("1. Add at Head");
            System.out.println("2. Add at Tail");
            System.out.println("3. Add at Index");
            System.out.println("4. Get Element");
            System.out.println("5. Delete First");
            System.out.println("6. Delete Middle");
            System.out.println("7. Delete at Index");
            System.out.println("8. Delete Last");
            System.out.println("9. Check Palindrome");
            System.out.println("10. Reverse List");
            System.out.println("11. Find Middle Element");
            System.out.println("12. Print List");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.addAtHead(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    list.addAtTail(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int idx = sc.nextInt();
                    System.out.print("Enter value: ");
                    list.addAtIndex(idx, sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter index: ");
                    int gIdx = sc.nextInt();
                    int result = list.get(gIdx);
                    if (result == -1) System.out.println("Invalid index");
                    else System.out.println("Value at index " + gIdx + ": " + result);
                    break;
                case 5:
                    list.deleteFirst();
                    break;
                case 6:
                    list.deleteMiddle();
                    break;
                case 7:
                    System.out.print("Enter index: ");
                    list.deleteAtIndex(sc.nextInt());
                    break;
                case 8:
                    list.deleteLast();
                    break;
                case 9:
                    System.out.println("Is Palindrome? " + list.checkPalindrome());
                    break;
                case 10:
                    list.reverseList();
                    break;
                case 11:
                    int mid = list.findMiddle();
                    if (mid == -1) System.out.println("List is empty");
                    else System.out.println("Middle Element: " + mid);
                    break;
                case 12:
                    list.printList();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
