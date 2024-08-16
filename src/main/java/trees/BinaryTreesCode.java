package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesCode {

    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static class BTree{
        public static int indx = -1;
        public static Node buildTree(int nodes[]){
            indx++;
            // base condition
            if (nodes[indx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[indx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preOrderPrint(Node root){
        // base condition
        if (root == null){
           // System.out.println(-1);
            return;
        }

        // small work condition and recurse
        // move left
        System.out.print(root.value);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public static void inOrderPrint(Node root){
        // base condition
        if (root == null){
            //System.out.println(-1);
            return;
        }

        // small work condition and recurse
        // move left
        inOrderPrint(root.left);
        System.out.print(root.value);
        inOrderPrint(root.right);
    }

    public static void postOrderPrint(Node root){
        // base condition
        if (root == null){
            //System.out.println(-1);
            return;
        }

        // small work condition and recurse
        // move left
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.print(root.value);
    }

    public static void levelOrderTraversal(Node root){

        Queue<Node> myQueue = new LinkedList<>();
        Node traverseNode = root;
        myQueue.add(root);
        myQueue.add(null);
        while (!myQueue.isEmpty()){
            Node curr = myQueue.remove();

            if(curr == null){
                System.out.println();
                //queue empty
                if(myQueue.isEmpty()) {
                    break;
                } else {
                    myQueue.add(null);
                }
            } else {
                System.out.print(curr.value + ",");
                if (curr.left!=null) {
                    myQueue.add(curr.left);
                }
                if (curr.right!=null){
                    myQueue.add(curr.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BTree tree = new BTree();

        Node root = tree.buildTree(nodes);
        System.out.println("Pre Order traversal");
        preOrderPrint(root);
        System.out.println();
        System.out.println("In order traversal");
        inOrderPrint(root);
        System.out.println();
        System.out.println("Post order traversal");
        postOrderPrint(root);
        System.out.println();
        System.out.println("level order traversal");
        levelOrderTraversal(root);

    }
}
