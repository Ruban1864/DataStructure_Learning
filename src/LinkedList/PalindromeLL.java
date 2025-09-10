package LinkedList;
//Leetcode : 234. Palindrome Linked List
public class PalindromeLL {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Function to check if linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // 0 or 1 node → palindrome

        // Step 1: Find the middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode head2 = reverseList(slow);

        // Step 3: Compare both halves
        ListNode p1 = head, p2 = head2;
        while (p2 != null) { // only need to check second half
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Helper: reverse linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev; // new head
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example 1: Palindrome list 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.print("List 1: ");
        printList(head1);
        System.out.println("Is palindrome? " + isPalindrome(head1));

        // Example 2: Non-palindrome list 1 -> 2 -> 3
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.print("List 2: ");
        printList(head2);
        System.out.println("Is palindrome? " + isPalindrome(head2));

        // Example 3: Odd length palindrome 1 -> 2 -> 3 -> 2 -> 1
        ListNode head3 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)))));
        System.out.print("List 3: ");
        printList(head3);
        System.out.println("Is palindrome? " + isPalindrome(head3));
    }
}
