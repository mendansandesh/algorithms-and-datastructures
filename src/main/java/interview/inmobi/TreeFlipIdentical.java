package interview.inmobi;

import node.BinaryNode;
// Problem: https://leetcode.com/problems/flip-equivalent-binary-trees/
// TimeComplexity:
// SpaceComplexity:
public class TreeFlipIdentical {
    public static void main(String[] args) {

        BinaryNode tree1 = new BinaryNode(1);
        tree1.left = new BinaryNode(2);
        tree1.left.left = new BinaryNode(4);
        tree1.left.right = new BinaryNode(5);
        tree1.left.right.left = new BinaryNode(7);
        tree1.left.right.right = new BinaryNode(8);
        tree1.right = new BinaryNode(3);
        tree1.right.left = new BinaryNode(6);

        BinaryNode tree2 = new BinaryNode(1);
        tree2.left = new BinaryNode(3);
        tree2.left.right = new BinaryNode(6);
        tree2.right = new BinaryNode(2);
        tree2.right.left = new BinaryNode(4);
        tree2.right.right = new BinaryNode(5);
        tree2.right.right.left = new BinaryNode(8);
        tree2.right.right.right = new BinaryNode(7);

        System.out.println(flipEquiv(tree1, tree2));
    }

    public static boolean flipEquiv(BinaryNode root1, BinaryNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return((root1.key == root2.key) &&
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left) ||
                        flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)));
    }
}
