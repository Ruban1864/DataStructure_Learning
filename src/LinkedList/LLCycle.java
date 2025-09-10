package LinkedList;

// Leetcode :   141. Linked List Cycle
public class LLCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to detect if the linked list has a cycle
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Create nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // Connect nodes: 1 -> 2 -> 3 -> 4
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Optional: create a cycle for testing
        // node4.next = node2; // Uncomment this line to create a cycle

        // Test if the linked list has a cycle
        boolean result = hasCycle(node1);
        System.out.println("Does the linked list have a cycle? " + result);
    }
}

