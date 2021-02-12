package interview.salesforce;

import node.BinaryNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSerialize {
    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(1);
        root.left = new BinaryNode(2);
        root.left.left = new BinaryNode(4);
        root.right = new BinaryNode(3);
        root.right.right = new BinaryNode(5);
        List<BinaryNode> serializedList = serialize(root);
        for (BinaryNode node : serializedList)
            System.out.print((node != null) ? node.key + " " : "null ");
        //System.out.println(deserialize(serializedList).right.key);
    }

    private static List<BinaryNode> serialize(BinaryNode temp) {
        Queue<BinaryNode> queue = new LinkedList<>();
        List<BinaryNode> serializedList = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.remove();
            if(temp.key != -1) {
                serializedList.add(temp);
                if(temp.left != null && temp.left.key != -1)
                    queue.add(temp.left);
                else
                    queue.add(new BinaryNode(-1));
                if(temp.right != null && temp.right.key != -1)
                    queue.add(temp.right);
                else
                    queue.add(new BinaryNode(-1));
            }
            else
                serializedList.add(new BinaryNode(-1));
        }
        System.out.println();
        return serializedList;
    }
}
