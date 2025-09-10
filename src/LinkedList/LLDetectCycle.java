package LinkedList;

public class LLDetectCycle {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Function to detect cycle and return the start node
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move one step
            fast = fast.next.next;     // move two steps

            if (slow == fast) { // Cycle detected
                // Step 2: Find cycle start
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow; // start node of cycle
            }
        }
        return null; // No cycle
    }

    // Example main method to test
    public static void main(String[] args) {
        LLDetectCycle obj = new LLDetectCycle();

        // Create a linked list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create cycle: tail (-4) connects to node with value 2
        head.next.next.next.next = head.next;

        ListNode cycleNode = obj.detectCycle(head);
        if (cycleNode != null) {
            System.out.println("Cycle starts at node with value: " + cycleNode.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}

