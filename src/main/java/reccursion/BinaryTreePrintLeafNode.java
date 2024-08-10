package reccursion;

public class BinaryTreePrintLeafNode {

    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode right;
        BinaryTreeNode left;

        BinaryTreeNode (int value, BinaryTreeNode left, BinaryTreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode parentNode = new BinaryTreeNode( 100, null, null);

        parentNode = insertInBinaryTree( parentNode, new BinaryTreeNode(90,null,null));

        parentNode = insertInBinaryTree( parentNode, new BinaryTreeNode(190,null,null));

        parentNode = insertInBinaryTree( parentNode, new BinaryTreeNode(155,null,null));
        parentNode = insertInBinaryTree( parentNode, new BinaryTreeNode(135,null,null));
        parentNode = insertInBinaryTree( parentNode, new BinaryTreeNode(145,null,null));
        parentNode = insertInBinaryTree( parentNode, new BinaryTreeNode(180,null,null));
        parentNode = insertInBinaryTree( parentNode, new BinaryTreeNode(165,null,null));
        printLeafNode(parentNode);

        System.out.println("Test stop");

    }


    public static void printLeafNode(BinaryTreeNode node){

        // base condition
        if(node==null){
            return;
        }
        if (node.left==null && node.right==null){
            System.out.print("->" + node.value);
        }

        if (node.left!=null){
            printLeafNode(node.left);
        }
        if (node.right!=null){
            printLeafNode(node.right);
        }

    }

    public static BinaryTreeNode insertInBinaryTree( BinaryTreeNode treeNode, BinaryTreeNode insertNode){
        // base condition
        if (treeNode == null){
            return insertNode;
        }


        //minimal recursive task
        if(insertNode.value > treeNode.value){
            treeNode.right= insertInBinaryTree(treeNode.right, insertNode);
            return treeNode;
        }else if (insertNode.value< treeNode.value){
            treeNode.left= insertInBinaryTree( treeNode.left, insertNode);
            return treeNode;
        } else{
            //value is already present
            System.out.println("Value already present in binary tree");
            return treeNode;
        }
    }
}
