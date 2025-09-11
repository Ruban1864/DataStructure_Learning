package LinkedList;
//Leetcode : 83. Remove Duplicates from Sorted List
class deleteDuplicatesLL {

    // Inner Node class
    static class Node {
        int val;
        Node next;

        Node() {}

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public Node deleteDuplicates(Node head) {
        if (head == null) return null;

        Node temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next; // skip duplicate
            } else {
                temp = temp.next; // move forward
            }
        }
        return head;
    }

    // For testing locally
    public static void main(String[] args) {
        // Create linked list: 1 -> 1 -> 2 -> 3 -> 3
        Node head = new Node(1, new Node(1, new Node(2, new Node(3, new Node(3)))));

        deleteDuplicatesLL sol = new deleteDuplicatesLL();
        Node newHead = sol.deleteDuplicates(head);

        // Print result
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        // Expected Output: 1 2 3
    }
}

