package problems.leetcode;

import node.BinaryNode;

public class InvertBinaryTree {
    public static void main(String[] args) {

        BinaryNode tree1 = new BinaryNode(4);
        tree1.left = new BinaryNode(2);
        tree1.left.left = new BinaryNode(1);
        tree1.left.right = new BinaryNode(3);
        tree1.right = new BinaryNode(7);
        tree1.right.left = new BinaryNode(6);
        tree1.right.right = new BinaryNode(9);

        System.out.println(invertTree(tree1).right.left.key); //should be 3
    }
    public static BinaryNode invertTree(BinaryNode root) {
        if(root == null)
            return null;

        BinaryNode left = invertTree(root.left);
        BinaryNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
