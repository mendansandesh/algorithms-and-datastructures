package stack;

import linkedlist.SinglyLinkedList;

public class StackByLinkedList {
    private SinglyLinkedList list;

    public StackByLinkedList(){
        list = new SinglyLinkedList();
    }

    boolean isStackEmpty(){
        return list.getSize() == 0;
    }

    void push(int num){
        if(isStackEmpty())
            list.createSinglyLinkedList(num);
        else
            list.insertInLinkedList(num, 0);
    }

    int pop(){
        int topOfStack = -1;
        if(isStackEmpty())
            System.out.println("Stack underflow error!!");
        else {
            topOfStack = list.getHead().getValue();
            list.deletionOfNode(0);
        }
        return topOfStack;
    }

    int peek(){
        if(isStackEmpty()) {
            System.out.println("Stack underflow error!!");
            return -1;
        }
        else
            return list.getHead().getValue();
    }
}
