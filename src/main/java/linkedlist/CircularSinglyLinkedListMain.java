package linkedlist;

public class CircularSinglyLinkedListMain {
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.createCircularSinglyLinkedList(5);

        list.insertInLinkedList(10, 1);
        list.insertInLinkedList(20, 2);
        list.insertInLinkedList(30, 3);
        list.insertInLinkedList(40, 4);
        list.insertInLinkedList(35, 4);
        list.insertInLinkedList(1, 0);
        list.insertInLinkedList(100, 10);
        list.traverseLinkedList();

        System.out.println("\nSearching the node having value 40: ");
        if (list.searchNode(40))
            System.out.println("found");
        else
            System.out.println("not found");

        System.out.println("\nSearching the node having value 200: ");
        if (list.searchNode(200))
            System.out.println("found");
        else
            System.out.println("not found");


        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(2);
        System.out.println("\nAfter deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 0: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(0);
        System.out.println("\nAfter deletion...");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 15: ");
        System.out.println("Before deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(15);
        System.out.println("\nAfter deletion...");
        list.traverseLinkedList();

        list.deleteLinkedList();
        list.traverseLinkedList();
    }
}
