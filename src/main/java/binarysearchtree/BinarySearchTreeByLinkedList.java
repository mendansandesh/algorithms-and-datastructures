package binarysearchtree;

import node.BinaryNode;

/**
 * @author Sandesh Mendan on 29/06/20
 * @project algorithms-and-datastructures
 */

public class BinarySearchTreeByLinkedList {
    BinaryNode root;

    public BinaryNode getRoot() {
        return root;
    }

    // Constructor
    BinarySearchTreeByLinkedList() {
        root = null;
    }

    // Insert values in BST
    void insert(int value) {
        root = insert(root, value);
    }

    private BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null){
            root = new BinaryNode(value);
            return root;
        }else if(value <= currentNode.key){
            currentNode.setLeft(insert(currentNode.left, value));
            return currentNode;
        }else {
            currentNode.setRight(insert(currentNode.right, value));
            return currentNode;
        }
    }

    boolean search(int value) {
       return search(root, value);
    }

    // Search a node in BST
    boolean search(BinaryNode currentNode, int value) {
        if(currentNode == null){
            return false;
        }
        if(value == currentNode.key){
            return true;
        }else if(value < currentNode.key){
            return search(currentNode.left, value);
        }else {
            return search(currentNode.right, value);
        }
    }

    public void deleteNodeOfBST(int value) {
        System.out.println("\n\nDeleting " + value + " from BST...");
        deleteNodeOfBST(root, value);
    }

    private BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
        if(root == null){
            System.out.println("Value not found in BST");
            return null;
        }
        if(value < root.key){
            root.setLeft(deleteNodeOfBST(root.getLeft(), value));
        }else if(value > root.key){
            root.setRight(deleteNodeOfBST(root.getRight(), value));
        }else { //current is the node to be deleted
            if(root.getLeft() != null && root.getRight() != null){ //if it has both child
                BinaryNode minInRightSubTree = findMinElem(root.getRight()); //find min elem in right subtree
                root.setKey(minInRightSubTree.getKey()); //replace curr node key with minInRightSubTree key
                root.setRight(deleteNodeOfBST(root.getRight(), minInRightSubTree.getKey())); //delete minInRightSubTree node
            }else if(root.getLeft() != null){  //if it has only left child
                root = root.getLeft();
            }else if(root.getRight() != null){ //if it has only right child
                root = root.getRight();
            }else { //if it has no child
                root = null;
            }
        }
        return root;
    }

    public BinaryNode findMinElem(BinaryNode temp) {
        if(temp.getLeft() == null)
            return temp;
        BinaryNode prev = temp;
        while (temp != null) {
            prev = temp;
            temp = temp.getLeft();
        }
        return prev;
    }

    public void deleteTree() {
        root = null;
    }
}
