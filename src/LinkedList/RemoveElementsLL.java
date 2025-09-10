package LinkedList;

//Leetcode : 203. Remove Linked List Elements
public class RemoveElementsLL {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        // Traverse the list
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // skip the node
            } else {
                curr = curr.next;
            }
        }

        return dummy.next; // new head
    }

    // Example main method for testing
    public static void main(String[] args) {
        RemoveElementsLL obj = new RemoveElementsLL();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode newHead = obj.removeElements(head, 6);

        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        // Output: 1 2 3 4 5
    }
}
