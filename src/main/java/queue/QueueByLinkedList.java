package queue;

import linkedlist.SinglyLinkedList;

public class QueueByLinkedList {
    SinglyLinkedList list;

    public QueueByLinkedList() {
        list =  new SinglyLinkedList();
    }

    boolean isQueueEmpty(){
        return list.getSize() == 0;
    }

    public void enQueue(int num) {
        if(isQueueEmpty())
            list.createSinglyLinkedList(num);
        else
            list.insertInLinkedList(num, list.getSize());
    }

    public int peek(){
        if(isQueueEmpty()) {
            System.out.println("Stack underflow error!!");
            return -1;
        }
        else
            return list.getHead().getValue();
    }

    public int deQueue() {
        int front = -1;
        if (isQueueEmpty())
            System.out.println("Queue underflow error!!");
        else {
            front = list.getHead().getValue();
            list.deletionOfNode(0);
        }
        return front;
    }
}
