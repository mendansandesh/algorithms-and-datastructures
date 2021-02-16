package problems.leetcode;

import node.BinaryNode;
// Problem: https://leetcode.com/problems/subtree-of-another-tree/
// TimeComplexity: O(M x N) where M is nodes in tree1, N is nodes in tree2
// SpaceComplexity: minimum of M and N
public class SubTree {
    public static void main(String[] args) {

        BinaryNode tree1 = new BinaryNode(1);
        tree1.left = new BinaryNode(2);
        tree1.right = new BinaryNode(3);
        tree1.left.left = new BinaryNode(4);
        tree1.left.right = new BinaryNode(5);

        BinaryNode tree2 = new BinaryNode(2);
        tree2.left = new BinaryNode(4);
        tree2.right = new BinaryNode(5);

        System.out.println(isSubtree(tree1, tree2));
    }
    public static boolean isSubtree(BinaryNode s, BinaryNode t) {
        if(s == null && t == null) return true;
        else if(s == null || t == null) return false;
        else if (TreeIdentical.isSameTree(s, t)) return true;
        else return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
