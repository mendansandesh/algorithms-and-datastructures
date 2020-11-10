package interview.sigmoid;

import binarysearchtree.BinarySearchTreeByLinkedList;
import node.BinaryNode;

/**
 * @author sandesh.mendan on 27/10/20
 * @project algorithms-and-datastructures
 */
public class KthSmallestInBST {

    public static void main(String[] args) {

        BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();

        System.out.println("Inserting 5 nodes in Tree");
        tree.insert(100);
        tree.insert(80);
        tree.insert(70);
        tree.insert(120);

        System.out.println(kthSmallest(tree.getRoot(), 3));
    }

    public static int kthSmallest(BinaryNode root, int k) {
        int[] res = new int[2]; //0th index: kth position; 1st index: kth position's value
        inorder(root, k, res);
        return res[1];
    }

    private static void inorder(BinaryNode root, int k, int[] res){
        if(root == null)
            return;
        inorder(root.left, k, res);
        if(++res[0] == k){
            res[1] = root.key;
            return;
        }
        inorder(root.right, k, res);
    }
}
