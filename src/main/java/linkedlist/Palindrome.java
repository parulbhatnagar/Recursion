package linkedlist;

public class Palindrome {

    public static class Node{
        int value;
        Node next;

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    static int lengthOfLinkedList=1, currentDepth=0;

    public static void main(String[] args) {
        Node node7 = new Node(1, null);
        Node node6 = new Node(2, node7);
        Node node5 = new Node(3, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node head = node1;

        Node secondHead = breakInHalf(node1);
        System.out.println("First half");
        printLinkedList(head);
        System.out.println("\nsecond half");
        printLinkedList(secondHead);
        System.out.println();
        boolean isPalindrome = true;

        while (head!=null && secondHead != null){
            if (head.value == secondHead.value){
                head = head.next;
                secondHead = secondHead.next;
            }
            else{
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome){
            System.out.println("LinkedList is palindrome");
        }
        else {
            System.out.println("Linked List is not palindrome");
        }


        // reverse list through middle (both odd or even size)
        // then compare  the head to head
        // given 1->2->3->4->5->6->7->null
        // turn it to 1->2->3-null and 7->6->5->null

/*        Node node4_1 = new Node(4, null);
        Node node3_1 = new Node(3, node4_1);
        Node node2_1 = new Node(2, node3_1);
        Node node1_1 = new Node(1, node2_1);

        Node secondHead_1 = breakInHalf(node1_1);
        System.out.println("\nFirst half");
        printLinkedList(node1_1);
        System.out.println("\nsecond half");
        printLinkedList(secondHead_1);*/

    }

    public static Node breakInHalf(Node node){
        // base condition
        if (node == null  || node.next==null){
            currentDepth++;
            return node;
        }

        // small work and recurse
        // node1->node2->node3
        // node3.next = node2
        // node2.next=null
        lengthOfLinkedList++;
        Node head = breakInHalf(node.next);
        System.out.println("Length = " + lengthOfLinkedList);
        currentDepth++;
        if (lengthOfLinkedList/2>=currentDepth){
            node.next.next = node;
            node.next = null;
        }
        else if(lengthOfLinkedList/2 <= (lengthOfLinkedList - currentDepth + 1)){
            node.next = null;
        }
        return head;
    }

    public static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}
