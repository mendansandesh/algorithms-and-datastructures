package problems.leetcode;

import node.BinaryNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-largest-value-in-each-tree-row/submissions/
public class MaxOfEachLevelinBT {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(3);
        root.left.left = new BinaryNode(5);
        root.left.right = new BinaryNode(3);
        root.right = new BinaryNode(2);
        root.right.right = new BinaryNode(9);
        List<Integer> maxValues = largestValues(root);
        for (Integer elem : maxValues)
            System.out.print(elem + " ");
    }
    public static List<Integer> largestValues(BinaryNode root){
        if(root == null) return null;
        List<Integer> maxValues = new ArrayList<>();
        largestValues(root, maxValues, 0);
        return maxValues;
    }
    public static List<Integer> largestValues(BinaryNode root, List<Integer> maxValues, int level){
        if(root == null)
            return null;
        if(level == maxValues.size()){
            maxValues.add(root.key);
        }else {
            maxValues.set(level, Math.max(maxValues.get(level), root.key));
        }
        largestValues(root.left, maxValues, level+1);
        largestValues(root.right, maxValues, level+1);
        return maxValues;
    }
}
