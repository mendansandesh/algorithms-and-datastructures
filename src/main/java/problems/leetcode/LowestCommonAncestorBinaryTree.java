package problems.leetcode;

import node.BinaryNode;
// Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// TimeComplexity: O(N)
// SpaceComplexity:
public class LowestCommonAncestorBinaryTree {
    public static void main(String[] args) {

        BinaryNode tree = new BinaryNode(3);
        tree.left = new BinaryNode(5);
        tree.left.left = new BinaryNode(6);
        tree.left.right = new BinaryNode(2);
        tree.left.right.left = new BinaryNode(7);
        tree.left.right.right = new BinaryNode(4);
        tree.right = new BinaryNode(1);
        tree.right.left = new BinaryNode(0);
        tree.right.right = new BinaryNode(8);

        System.out.println(lowestCommonAncestor(tree, tree.left, tree.left.right.right).key);
    }
    public static BinaryNode lowestCommonAncestor(BinaryNode root, BinaryNode p, BinaryNode q) {
        if(root == null) return null;
        if(root.key == p.key || root.key == q.key) return root;
        BinaryNode left = lowestCommonAncestor(root.left, p, q);
        BinaryNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        if(left == null && right == null) return null;
        return (left != null) ? left : right;
    }
}

