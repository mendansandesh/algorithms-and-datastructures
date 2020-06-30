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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
