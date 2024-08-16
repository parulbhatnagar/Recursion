package linkedlist;

/**
 * 92. Reverse Linked List II
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * Follow up: Could you do it in one pass?
 */
public class ReverseLinkedListSubset {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void printList(ListNode list){
        ListNode curr = list;
        System.out.println("list is: ");
        while (curr!=null){
            System.out.print(curr.val + "->");
            curr=curr.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode leftMinus1 = null;
        ListNode leftNode = null;
        int currentPosition = 0;
        if (head==null || head.next==null || left == right){
            return head;}
        while (curr!=null){
            currentPosition++;
            // 1.  move till left-1 and store the node as this next will point to the
            // rth element once discovered and left.next will point to right.next
            if (currentPosition <left){
                prev = curr;
                curr = curr.next;
            }
            if (currentPosition == left) {
                leftMinus1 = prev;
                leftNode = curr;
            }
            if(currentPosition== right ){
                if (leftMinus1!=null){
                    leftMinus1.next= curr;}
                leftNode.next = curr.next;
            }
            if (currentPosition>= left && currentPosition<=right){
                // reverse the linked list
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }
            if(currentPosition>right){
                break;
            }
            // 2. from left till right current position reverse linked list
            // 3.point the ones identified in step 1
        }
        if (left == 1){
            //this means head is also changed to right node
            return prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7,null);
        ListNode node6 = new ListNode(6,node7);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        printList(node1);

        ListNode reversed = reverseBetween(node1,2,7);

        printList(reversed);
    }
}
