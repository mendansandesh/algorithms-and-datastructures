package binarytree;

import node.BinaryNode;

/**
 * @author Sandesh Mendan on 28/06/20
 * @project algorithms-and-datastructures
 */
public class BinaryTreeByLinkedListMain {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(10);
        root.left = new BinaryNode(11);
        root.left.left = new BinaryNode(7);
        root.right = new BinaryNode(9);
        root.right.left = new BinaryNode(15);
        root.right.right = new BinaryNode(8);

        System.out.print( "\nInorder traversal before insertion: ");
        BinaryTreeByLinkedList.inorder(root);

        int key = 12;
        BinaryTreeByLinkedList.insert(root, key);

        System.out.print("\nInorder traversal after insertion: ");
        BinaryTreeByLinkedList.inorder(root);

        System.out.print("\nPreorder traversal after insertion: ");
        BinaryTreeByLinkedList.preorder(root);

        System.out.print("\nPostorder traversal after insertion: ");
        BinaryTreeByLinkedList.postorder(root);

        System.out.print("\nLevelorder traversal after insertion: ");
        BinaryTreeByLinkedList.levelorder(root);

        if(BinaryTreeByLinkedList.search(root, 15))
            System.out.println("\nNode 15 found in tree");
        else
            System.out.println("Node 15 not found in tree");

        if(BinaryTreeByLinkedList.search(root, 150))
            System.out.println("Node 150 found in tree");
        else
            System.out.println("Node 150 not found in tree");

        BinaryTreeByLinkedList.deleteNodeOfBinaryTree(root, 11);

        System.out.print("\nLevelorder traversal after deletion: ");
        BinaryTreeByLinkedList.levelorder(root);
    }
}
