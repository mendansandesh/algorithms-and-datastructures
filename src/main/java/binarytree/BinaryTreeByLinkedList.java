package binarytree;

import node.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sandesh Mendan on 28/06/20
 * @project algorithms-and-datastructures
 */
public class BinaryTreeByLinkedList {
    BinaryNode root;
    BinaryNode temp = root;

    public static void insert(BinaryNode temp, int key){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(temp);

        //perform level order traversal to find empty slot to insert the new node
        while (!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();

            if(temp.left == null){
                temp.left = new BinaryNode(key);
                break;
            }else
                queue.add(temp.left);

            if(temp.right == null){
                temp.right = new BinaryNode(key);
                break;
            }else
                queue.add(temp.right);
        }
    }

    public static void inorder(BinaryNode root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void preorder(BinaryNode root) {
        if(root == null)
            return;
        System.out.print(root.key + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public static void postorder(BinaryNode root) {
        if(root == null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.key + " ");
    }

    public static void levelorder(BinaryNode temp) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.peek();
            System.out.print(temp.key +" ");
            queue.remove();
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    public static boolean search(BinaryNode temp, int searchValue) {
        if(temp == null){
            System.out.println("No tree exists!");
            return false;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();
            if(temp.key == searchValue)
                return true;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return false;
    }

    public static void deleteNodeOfBinaryTree(BinaryNode temp, int deleteValue) {
        if(temp == null)
            System.out.println("No tree exists, cant perform deletion");
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();
            if(temp.key == deleteValue) {
                BinaryNode deepestNode = getDeepestNode(temp);
                temp.key = deepestNode.key;
                //deleteDeepestNode(); TODO delete deepestNode
                return;
            }else {
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public static BinaryNode getDeepestNode(BinaryNode temp) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(temp);
        BinaryNode deepestNodesParent;
        while (!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();

            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return temp;
    }
}
