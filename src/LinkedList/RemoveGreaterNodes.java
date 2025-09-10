package LinkedList;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class RemoveGreaterNodes {
    static Node head = null;

    public static void main(String[] args) {
        head = insertEnd(head, 12);
        head = insertEnd(head, 15);
        head = insertEnd(head, 10);
        head = insertEnd(head, 11);
        head = insertEnd(head, 5);
        head = insertEnd(head, 6);
        head = insertEnd(head, 2);
        head = insertEnd(head, 3);

        display(head);
        head = removeNodes(head);
        display(head);

    }

    private static Node removeNodes(Node head) {
        if(head == null ) return null;
        head = reverse(head);

        //Node curr = head;
        Node maxNode = head;
        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data < maxNode.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
                maxNode = temp;
            }
        }

        head = reverse(head);
        return head;
    }


    public static Node reverse(Node head){
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node insertEnd(Node head, int data) {
        Node nn = new Node(data);

        if (head == null) {
            return nn;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = nn;

        return head;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
