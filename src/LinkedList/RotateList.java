package LinkedList;
//Leetcode : 61. Rotate List
public class RotateList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Function to rotate list
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Find length of list
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // 2. Adjust k
        k = k % n;
        if (k == 0) return head;

        // 3. Make circular
        tail.next = head;

        // 4. Find new tail
        ListNode newTail = head;
        for (int i = 1; i < n - k; i++) {
            newTail = newTail.next;
        }

        // 5. Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1: head = [1,2,3,4,5], k = 2
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.print("Original List 1: ");
        printList(head1);
        ListNode rotated1 = rotateRight(head1, 2);
        System.out.print("Rotated List 1 (k=2): ");
        printList(rotated1);

        // Example 2: head = [0,1,2], k = 4
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        System.out.print("\nOriginal List 2: ");
        printList(head2);
        ListNode rotated2 = rotateRight(head2, 4);
        System.out.print("Rotated List 2 (k=4): ");
        printList(rotated2);
    }
}

