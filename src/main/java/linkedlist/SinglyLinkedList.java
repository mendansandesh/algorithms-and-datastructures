package linkedlist;

import node.SingleNode;

public class SinglyLinkedList {
    private SingleNode head;
    private SingleNode tail;
    private int size;

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SingleNode createSinglyLinkedList(int nodeValue) {
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void traverseLinkedList(){
        if(linkedListIsExists()){
            SingleNode curr = head;
            while(curr != null){
                System.out.print(curr.getValue() +" ");
                curr = curr.getNext();
            }
        }
    }

    public boolean linkedListIsExists(){
        return size != 0;
    }

    public void insertInLinkedList(int nodeValue, int position){
        if(!linkedListIsExists()){
            System.out.println("LinkedList does not exists!");
            return;
        }

        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        if (position == 0) {      //insert at start
            node.setNext(head);
            head = node;
        } else if (position >= size-1) {   //insert at end
            tail.setNext(node);
            node.setNext(null);
            tail = node;
        } else {                         //insert in between start and end
            SingleNode curr = head;
            int i = 0;
            while (i != position - 1) {
                curr = curr.getNext();
                i++;
            }
            node.setNext(curr.getNext());
            curr.setNext(node);
        }
        setSize(getSize() + 1);
    }

    public boolean searchNode(int searchValue) {
        if(linkedListIsExists()){
            SingleNode curr = head;
            while(curr != null && curr.getValue() != searchValue)
                curr = curr.getNext();
            return curr != null;
        }
        return false;
    }

    public void deletionOfNode(int position){
        if(linkedListIsExists()) {
            SingleNode curr = head;

            if (getSize() == 1) { //case: single node case
                head = null;
                tail = null;
            } else {        //case: more than one node
                if(position == 0){      //start position
                    head = head.getNext();
                }else {
                    if(position >= size - 1){ //delete last position for position >= size-1
                        position = size-1;
                    }
                    for(int i = 0; i <= position-2; i++) // 0 1 2 3 4
                        curr = curr.getNext();
                    if(position == size - 1) {
                        curr.setNext(null);
                        tail = curr;
                    }
                    else //in between start and last position
                        curr.setNext(curr.getNext().getNext());
                }
            }
            setSize(getSize() - 1);
        }
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("\n\nLinked List deleted successfully !");
    }
}
