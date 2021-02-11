package problems.leetcode;

import node.BinaryNode;
// Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// TimeComplexity: O(H)
// SpaceComplexity:
public class LowestCommonAncestorBinarySearchTree {
    public static void main(String[] args) {

        BinaryNode tree = new BinaryNode(6);
        tree.left = new BinaryNode(2);
        tree.left.left = new BinaryNode(0);
        tree.left.right = new BinaryNode(4);
        tree.left.right.left = new BinaryNode(3);
        tree.left.right.right = new BinaryNode(5);
        tree.right = new BinaryNode(8);
        tree.right.left = new BinaryNode(7);
        tree.right.left = new BinaryNode(9);

        System.out.println(lowestCommonAncestor(tree, tree.left, tree.right).key);
    }
    public static BinaryNode lowestCommonAncestor(BinaryNode root, BinaryNode p, BinaryNode q) {
        if(root == null) return null;
        if(root.key > Math.max(p.key, q.key)) return lowestCommonAncestor(root.left, p, q);
        else if(root.key < Math.min(p.key, q.key)) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
