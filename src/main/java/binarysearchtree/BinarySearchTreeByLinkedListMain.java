package binarysearchtree;

import binarytree.BinaryTreeByLinkedList;

/**
 * @author Sandesh Mendan on 29/06/20
 * @project algorithms-and-datastructures
 */

public class BinarySearchTreeByLinkedListMain {
    public static void main(String[] args) {

        //Constructor
        BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();

        //Inserting values in BST
        System.out.println("Inserting 5 nodes in Tree");
        tree.insert(100);
        tree.insert(80);
        tree.insert(70);
        tree.insert(120);
        tree.insert(90);
        tree.insert(60);
        tree.insert(75);
        tree.insert(87);
        tree.insert(95);

        //tree.printTreeGraphically();

        //Searching non-existing value in Tree
        System.out.println("\n\nSearching for value on BST...");
        if(tree.search(70))
            System.out.println("Node 70 found in tree");
        else
            System.out.println("Node 15 not found in tree");

        if(tree.search(150))
            System.out.println("Node 150 found in tree");
        else
            System.out.println("Node 150 not found in tree");


        System.out.print("\nLevelorder traversal before deletion: ");
        BinaryTreeByLinkedList.levelorder(tree.getRoot());
        //Deleting Node from Tree
        tree.deleteNodeOfBST(80); //Node is having 2 Child; also try with 0 child, 1 child as well
        System.out.print("\nLevelorder traversal after deletion: ");
        BinaryTreeByLinkedList.levelorder(tree.getRoot());


		//Deleting entire Tree
		tree.deleteTree();

		//Traversing Tree
        if(tree.root == null)
            System.out.println("\n\nTree do not exist");

    }
}
