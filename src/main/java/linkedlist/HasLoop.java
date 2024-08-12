package linkedlist;

public class HasLoop {
    public static class Node {
        int val;
        Node next;
        Node (int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static boolean hasCycle(Node head){
        if (head == null){
           return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null || fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        node5.next = node2;
        Node head = node1;

        if (hasCycle(node1)){
            System.out.println("It has cycle, lets break it");
            head = breakTheCycle(node1);

        }else {
            System.out.println("No Cycle");
        }

        printLinkedList(head);


    }

    private static Node breakTheCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null || fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                 break; // reached the meeting point
            }
        }
        //Now move slow back to head and move both one step at a time
        slow = head;
        while (slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }

    public static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
