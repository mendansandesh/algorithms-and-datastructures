package problems.leetcode;

import node.BinaryNode;
//https://leetcode.com/problems/sum-of-left-leaves/
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(3);
        root.left = new BinaryNode(9);
        root.right = new BinaryNode(20);
        root.right.left = new BinaryNode(15);
        root.right.right = new BinaryNode(7);
        System.out.print(sumOfLeftLeaves(root));
    }
    public static int sumOfLeftLeaves(BinaryNode root) {
        if(root == null)
            return 0;
        else if(root.left != null && (root.left.left == null && root.left.right == null))
            return root.left.key + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
