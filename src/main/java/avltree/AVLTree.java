package avltree;

import node.BinaryNode;

/**
 * @author Sandesh Mendan on 30/06/20
 * @project algorithms-and-datastructures
 */

public class AVLTree {
    BinaryNode root;

    int height(BinaryNode node){
        return (node == null) ? 0 : node.height;
    }

    int getBalance(BinaryNode node){
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    int calculateHeight(BinaryNode node){
        return 1 + Math.max(height(node.left), height(node.right));
    }

    BinaryNode rightRotate(BinaryNode node){
        BinaryNode newRoot = node.left;
        node.left = node.left.right;
        newRoot.right = node;
        newRoot.height = calculateHeight(newRoot);
        node.height = calculateHeight(node);
        return newRoot;
    }

    BinaryNode leftRotate(BinaryNode node){
        BinaryNode newRoot = node.right;
        node.right = node.right.left;
        newRoot.left = node;
        newRoot.height = calculateHeight(newRoot);
        node.height = calculateHeight(node);
        return newRoot;
    }

    BinaryNode insert(BinaryNode node, int key){
        if(node == null)
            return new BinaryNode(key);
        if(key < node.key)
            node.left = insert(node.left, key);
        else if(key > node.key)
            node.right = insert(node.right, key);
        else    //duplicate keys not allowed
            return node;

        int balance = getBalance(node);

        if(balance > 1){
            //we can also check below condition using getBalance method;
            if(key < node.left.key) //LL rotation;
                node = rightRotate(node);
            else{
                node.left = leftRotate(node.left);   //LR rotation
                node = rightRotate(node);
            }
        }
        if(balance < -1){
            if(key > node.right.key)    //RR rotation
                node = leftRotate(node);
            else {
                node.right = rightRotate(node.right);   //RL rotation
                node = leftRotate(node);
            }
        }
        node.height = calculateHeight(node);
        return node;
    }

    public BinaryNode deleteNode(BinaryNode node, int key) {
        if(node == null)
            return null;
        if(key < node.key)
            node.left = deleteNode(node.left, key);
        else if(key > node.key)
            node.right = deleteNode(node.right, key);
        else {
            if (node.left != null && node.right != null){
                BinaryNode minValueNode = findMinValueNode(node.right);
                node.key = minValueNode.key;
                node.right = deleteNode(node.right, key);
            }else if(node.left != null){
                node = node.left;
            }else if(node.right != null){
                node = node.right;
            }else {
                node = null;
            }
        }

        if (node == null)
            return node;

        int balance = getBalance(node);

        //now we cant check key comparision because actual key is already deleted!; so we check balance
        if(balance > 1){
            if(getBalance(node.left) >= 0) //LL rotation; todo check why = ?
                node = rightRotate(node);
            else {
                node.left = leftRotate(node.right);    //LR rotation
                node = rightRotate(node);
            }
        }
        if(balance < -1){
            if(getBalance(node.right) <= 0)    //RR rotation
                node = leftRotate(node);
            else {
                node.right = rightRotate(node.right);   //RL rotation
                node = leftRotate(node);
            }
        }
        node.height = calculateHeight(node);
        return node;
    }

    BinaryNode findMinValueNode(BinaryNode node){
        BinaryNode curr = node;
        while (node != null){
            curr = node;
            node = node.left;
        }
        return curr;
    }

    void preOrder(BinaryNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
