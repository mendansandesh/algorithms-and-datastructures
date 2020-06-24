package linkedlist;

import node.DoubleNode;
import node.SingleNode;

public class CircularDoublyLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DoubleNode createCircularDoublyLinkedList(int nodeValue) {
        head = new DoubleNode();
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        node.setPrev(node);
        node.setNext(node);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public boolean linkedListIsExists(){
        return size != 0;
    }

    public void insertInLinkedList(int nodeValue, int position){
        if(!linkedListIsExists()){
            System.out.println("LinkedList does not exists!");
            return;
        }

        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);

        if (position == 0) {      //insert at start
            node.setNext(head);
            node.setPrev(tail);
            head = node;
        }else if(position >= size-1){  //insert at end
            node.setPrev(tail);
            node.setNext(head);
            tail.setNext(node);
            tail = node;
        }else {                       //insert in between start and end 0 1 2 3
            DoubleNode curr = head;
            int i = 0;
            while (i != position){
                curr = curr.getNext();
                i++;
            }
            node.setPrev(curr.getPrev());
            node.setNext(curr);
            node.getPrev().setNext(node);
            node.getNext().setPrev(node);
        }
        size++;
    }

    public void traverseLinkedList(){
        if(linkedListIsExists()){
            DoubleNode curr = head;
            int i = 0;
            while(i != size){
                System.out.print(curr.getValue() +" ");
                curr = curr.getNext();
                i++;
            }
        }
    }

    public void traverseLinkedListInReverseOrder() {
        if(linkedListIsExists()){
            DoubleNode curr = tail;
            int i = 0;
            System.out.println();
            while(i != size){
                System.out.print(curr.getValue() +" ");
                curr = curr.getPrev();
                i++;
            }
        }
    }

    public boolean searchNode(int searchValue) {
        if(linkedListIsExists()){
            DoubleNode curr = head;
            int i = 0;
            while(i != size && curr.getValue() != searchValue) {
                curr = curr.getNext();
                i++;
            }
            return i != size;
        }
        return false;
    }

    public void deletionOfNode(int position) {
        if(linkedListIsExists()) {
            DoubleNode curr = head;

            if (getSize() == 1) { //case: single node case
                head = null;
                tail = null;
            } else {        //case: more than one node
                if(position == 0){      //start position
                    head = head.getNext();
                    head.setPrev(tail);
                }else {
                    if(position >= size - 1){ //delete last position for position >= size-1
                        position = size-1;
                    }
                    for(int i = 0; i <= position-2; i++) // 0 1 2 3 4
                        curr = curr.getNext();
                    if(position == size - 1) {
                        curr.getPrev().setNext(curr);
                        curr.setNext(head);
                        tail = curr;
                    }
                    else { //in between start and last position
                        curr.getNext().getNext().setPrev(curr);
                        curr.setNext(curr.getNext().getNext());
                    }
                }
            }
            size--;
        }
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("\n\nLinked List deleted successfully !");
    }
}
