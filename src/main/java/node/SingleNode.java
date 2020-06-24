package node;

public class SingleNode {
    int value;
    SingleNode next;

    @Override
    public String toString() {
        return value + "";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}
