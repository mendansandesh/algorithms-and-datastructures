package linkedlist;

public class CircularDoublyLinkedListMain {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.createCircularDoublyLinkedList(5);
        list.insertInLinkedList(10, 1);
        list.insertInLinkedList(20, 2);
        list.insertInLinkedList(30, 2);
        list.insertInLinkedList(40, 1);

        System.out.println("List Now: ");
        list.traverseLinkedList();

        list.traverseLinkedListInReverseOrder();


        System.out.println("\n\nSearching the node having value 40...");
        if(list.searchNode(40))
            System.out.println("found..");
        else
            System.out.println("not found..");

        System.out.println("Searching the node having value 500...");
        if(list.searchNode(200))
            System.out.println("found..");
        else
            System.out.println("not found..");


        System.out.println("\n\nDeleting the node having location = 0: ");
        System.out.println("Before Deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(0);
        System.out.println("\nAfter Deletion...");
        list.traverseLinkedList();

        System.out.println("\n\nDeleting the node having location = 3: ");
        System.out.println("Before Deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(3);
        System.out.println("\nAfter Deletion...");
        list.traverseLinkedList();

        System.out.println("\n\nDeleting the node having location = 20: ");
        System.out.println("Before Deletion...");
        list.traverseLinkedList();
        list.deletionOfNode(20);
        System.out.println("\nAfter Deletion...");
        list.traverseLinkedList();


        list.deleteLinkedList();
        list.traverseLinkedList();

    }
}
