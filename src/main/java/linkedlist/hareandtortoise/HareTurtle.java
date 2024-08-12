package linkedlist.hareandtortoise;

public class HareTurtle {

    public static  class Node {
        int val;
        Node next;

        Node (int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node node7 = new Node(2,null);
        Node node6 = new Node(2,node7);
        Node node5 = new Node(2,node6);
        Node node4 = new Node(1,node5);
        Node node3 = new Node(2,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        Node head = node1;

        printLinkedList(head);

/*        System.out.println("Print form the middle");
        printLinkedList(getMiddleOfLinkedList(head));

        System.out.println("Reversing the linked list");
        printLinkedList(reverseList(head));*/

        if(isPalindrome(head)){
            System.out.println("Palindrome");
        } else {
            System.out.println("NOT a Palindrome");
        }


    }

    public static void printLinkedList(Node head){
        System.out.println("List is:");
        Node curr = head;
        while (curr!=null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }



    // check for palindrome
    public static boolean isPalindrome (Node head){
        if (head==null || head.next==null){
            return true;
        }
        // find the middle of the linked list
        Node middle = getMiddleOfLinkedList(head);

        // reverse the second half of the linked list

        Node secondHead = reverseList(middle.next);

        while (head != null && secondHead !=null){
            if (head.val != secondHead.val){
                return false;
            } else
                {
                    head = head.next;
                    secondHead = secondHead.next;
                }
            }
        return true;
        }

    private static Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr=temp;
        }
        return prev;
    }

    private static Node getMiddleOfLinkedList(Node head) {
        Node hare = head;
        Node turtle = head;

        while (hare.next != null && hare.next.next !=null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

}
