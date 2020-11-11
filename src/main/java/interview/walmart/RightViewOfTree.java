package interview.walmart;

import node.BinaryNode;
import java.util.LinkedList;

/**
 * @author sandesh.mendan on 11/11/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/problems/binary-tree-right-side-view/
public class RightViewOfTree {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.left.right = new BinaryNode(5);
        root.right = new BinaryNode(3);
        root.right.right = new BinaryNode(4);

        printRightView(root);
    }

    private static void printRightView(BinaryNode root) {
        LinkedList<BinaryNode> queue = new LinkedList<>(); //bfs fashion
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size(); //size = no of children in each level at a time
            for(int i = 0; i < size; i++){
                BinaryNode node = queue.remove();
                if(i == size-1)
                    System.out.print(node.key +" ");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
    }
}