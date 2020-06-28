package node;

/**
 * @author Sandesh Mendan on 28/06/20
 * @project algorithms-and-datastructures
 */
public class BinaryNode {
    public int key;
    public BinaryNode left;
    public BinaryNode right;

    // constructor
    public BinaryNode(int key){
        this.key = key;
        left = null;
        right = null;
    }
}
