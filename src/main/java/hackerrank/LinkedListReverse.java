package hackerrank;

import linkedlist.SinglyLinkedList;
import node.SingleNode;

/**
 * @author sandesh.mendan on 23/07/20
 * @project algorithms-and-datastructures
 */

//Problem: https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
public class LinkedListReverse {
    public static void main(String[] args){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.createSinglyLinkedList(20);
        linkedList.insertInLinkedList(40, 1);
        linkedList.insertInLinkedList(70, 2);

        linkedList.setHead(reverse(linkedList.getHead()));

        linkedList.traverseLinkedList();
    }

    static SingleNode reverse(SingleNode node) {
        SingleNode prev = null;
        SingleNode curr = node;
        SingleNode next;

        while(curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
