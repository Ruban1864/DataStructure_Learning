package LinkedList;

//Leetcode : 92. Reverse Linked List II
class ReverseBetween {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        // Step 1: create dummy node
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // Step 2: move prev to the node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: reverse sublist between left and right
        ListNode start = prev.next;       // first node in sublist
        ListNode then = start.next;       // node to move

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        // Step 4: return new head
        return dummy.next;
    }

    // Test the code
    public static void main(String[] args) {
        ReverseBetween sol = new ReverseBetween();

        // Build list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse between positions 2 and 4
        ListNode newHead = sol.reverseBetween(head, 2, 4);

        // Print result: expected 1 -> 4 -> 3 -> 2 -> 5
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
