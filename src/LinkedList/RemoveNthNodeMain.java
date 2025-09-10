package LinkedList;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Solution class
class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both slow and fast until fast reaches null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete nth node
        slow.next = slow.next.next;

        return dummy.next;
    }
}

// Main class for testing
public class RemoveNthNodeMain {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        RemoveNthNode sol = new RemoveNthNode();

        int n = 2; // Remove 2nd node from end
        ListNode result = sol.removeNthFromEnd(head, n);

        // Print final linked list
        System.out.print("Resultant Linked List: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

