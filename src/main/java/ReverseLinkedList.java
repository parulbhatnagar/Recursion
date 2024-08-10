public class ReverseLinkedList {

    static class Node{
        int num;
        Node next;

        public int getNum() {
            return num;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setNum(int num) {
            this.num = num;
        }
        Node(int num){
            this.num = num;
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        printLinkedList(node1);

        Node reversed = reverseLinkedList(node1);

        printLinkedList(reversed);
        
    }

    private static Node reverseLinkedList(Node node) {
        //base condition
        if (node==null || node.getNext()==null){
            return node;
        }

        // do small work of changing the linked list
        Node nextReverseNodeHead = reverseLinkedList(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return nextReverseNodeHead;
    }

    private static void printLinkedList(Node node) {
        Node traverseNode = node;
        while(traverseNode!= null){
            System.out.println(traverseNode.getNum());
            traverseNode = traverseNode.getNext();
        }
    }


}
