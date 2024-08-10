package reccursion;

public class MergeSortedLinkedList {
    static class Node{
        public int value;
        public Node next;
        Node(int value, Node next){
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        //List 1
        Node node4 = new Node(12,null);
        Node node3 = new Node(10,node4);
        Node node2 = new Node(8,node3);
        Node node1 = new Node(-1,node2);

        //List 2
        Node node4_1 = new Node(15,null);
        Node node3_1 = new Node(13,node4_1);
        Node node2_1 = new Node(8,node3_1);
        Node node1_1 = new Node(0,node2_1);
        System.out.println("First List");
        printList(node1);
        System.out.println("Second List");
        printList(node1_1);

        Node mergedList = mergelist(node1, node1_1);
        System.out.println("Merged List");
        printList(mergedList);
    }

    private static Node mergelist(Node firstList, Node secondList) {
        // base condition
        if (firstList== null){
            return secondList;
        }
        if (secondList == null){
            return firstList;
        }

        //Work to be done
        if (firstList.value < secondList.value){
            firstList.next = mergelist(firstList.next,secondList);
            return firstList;
        }
        else {
            secondList.next = mergelist(firstList,secondList.next);
            return secondList;
        }
    }

    private static void printList(Node node1) {
        Node traverseNode = node1;
        while(traverseNode != null){
            System.out.print(traverseNode.value+"->");
            traverseNode = traverseNode.next;
        }
    }
}
