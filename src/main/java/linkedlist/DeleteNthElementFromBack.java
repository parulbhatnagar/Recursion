package linkedlist;


public class DeleteNthElementFromBack {

    // static variable to keep track of size
    public static int sizeFromBack = 0;

    public static class Node{
        int value;
        Node next;

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node node7 = new Node(7,null);
        Node node6 = new Node(6,node7);
        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        Node head = node1;
        int size=0;
        int N=3; // third node from back
        for(Node traverseNode = head;traverseNode !=null;traverseNode=traverseNode.next){
            size ++;
        }
        System.out.println("Size of linked list at start = " + size);
        printLinkedList(head);

        head = deleteNthElementFromBack(head,N);
        System.out.println("Linked List after deletion");
        printLinkedList(head);

    }

    private static Node deleteNthElementFromBack(Node node, int n) {
        // base condition
        if (node == null){
            return null;
        }
        if (node.next == null){
            sizeFromBack++;
            return node;
        }
        // do small work and recursive
        node.next = deleteNthElementFromBack(node.next,n);
        if (sizeFromBack == n){
            node.next = node.next.next;
            sizeFromBack++;
            return node;
        }
        sizeFromBack++;
        return node;

    }

    public static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}
