package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeCode {

    public static class Node{
        int val;
        Node left;
        Node right;

        Node (int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node insert(int val, Node root){
        // base condition
        if (root == null ){
            return new Node (val, null, null);
        }
        // small work and recurse
        if (val < root.val){
            root.left = insert(val, root.left);
        }else{
            root.right = insert(val,root.right);
        }
        return root;
    }


    public static void printInOrder(Node root){
        // base condition
        if (root == null ){
            return;
        }
        // small work and recurse
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);

    }

    public static void printLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()){
            Node traverseNode = queue.remove();

            if (traverseNode == null){
                System.out.println();
                if (queue.isEmpty()){
                    break;
                } else{
                    queue.add(null);
                }
            }
            else {
                System.out.print(traverseNode.val + " ");
                if (traverseNode.left !=null){
                    queue.add(traverseNode.left);
                }
                if (traverseNode.right !=null){
                    queue.add(traverseNode.right);
                }

            }


        }
    }

    public static boolean search(Node root , int searchValue){
        //base condition
        if (root== null){
            return false;
        }
        // some work and recurse

        if (searchValue < root.val){ // search left
            return search(root.left, searchValue);
        }
        else if (searchValue > root.val){
            return search(root.right, searchValue);
        }
        else {//root.val == searchValue
            return true;
        }

    }

    public static Node delete (Node root, int deleteValue){
        // base condition
        if (root == null){
            return null;
        }
        // Some theory, we have three possible scenarios
        // case 1 : if node we are searching is leaf node (i.e. lef=right=null)
        // then just delete the node by marking parent not point to nul instead
        //
        // case 2 : if node has one single child then just replace child with the node
        //
        // case 3 : if it has two child then parent will be replaced by the next inOrder
        // element (which can only  be leaf node or a single child node)

        if (deleteValue < root.val){
            root.left = delete( root.left, deleteValue);
        } else if (deleteValue > root.val) {
            root.right = delete(root.right, deleteValue);
        } else {
            // root is the node to be deleted
            // case 1
            if (root.left == null && root.right == null){
                return null;
            }
            // case 2
            else if (root.left == null && root.right != null){
                return root.right;
            }
            else if (root.left != null && root.right == null){
                return root.left;
            }else {
                Node inOrderSuccessor = inOrderSuccessor(root.right);
                root.val = inOrderSuccessor.val;
                root.right = delete(root.right, inOrderSuccessor.val);
               /* Node traverseNode = root.right;
                // Case 3
                while (traverseNode != null && traverseNode.left != null){
                    traverseNode = traverseNode.left;
                }
                traverseNode.left = root.left;
                return traverseNode;*/
            }
        }
        return root;
    }

    private static Node inOrderSuccessor(Node root) {
        while (root != null && root.left != null){
            root = root.left;
        }
        return root;
    }

    private static void printInRange(Node root, int x, int y){
        // base condition
        if (root == null){
            return;
        }

        // some work and recurse

        if (root.val > y) {
            printInRange(root.left, x, y);
        }
        else if (root.val < x){
            printInRange(root.right, x, y);
        }
        else if (root.val >= x && root.val <= y){
            System.out.print( root.val  + " ");
            printInRange(root.left, x, y);
            printInRange(root.right, x, y);

        }
    }


    public static void main(String[] args) {

        int [] input = {8,5,3,1,4,6,10,11,14};
                //{5,1,3,4,2,7};

        Node bst=null;

        for(int val:input){
            bst = insert(val,bst);
        }

        System.out.println("In Order Traversal");
        printInOrder(bst);
        System.out.println();
        System.out.println("Level Order Traversal");
        printLevelOrder(bst);

        System.out.println("is 6 present "+ search(bst, 6));
        System.out.println("is 1 present "+ search(bst, 1));

        bst = delete(bst, 3);

        printLevelOrder(bst);
        System.out.println();
        printInOrder(bst);
        System.out.println();

        System.out.println("Print in range");

        printInRange(bst, 4, 9);


    }
}
