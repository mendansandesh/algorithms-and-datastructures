package linkedlist;

public class SinglyLinkedListMain {
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();

        list.createSinglyLinkedList(5);

        list.insertInLinkedList(10, 1);
        list.insertInLinkedList(20, 2);
        list.insertInLinkedList(30, 2);
        list.insertInLinkedList(40, 1);

        list.traverseLinkedList();

        System.out.println("\n\nSearching the node having value 40...");
        if(list.searchNode(40))
            System.out.println("found..");
        else
            System.out.println("not found..");


        System.out.println("Searching the node having value 500...");
        if(list.searchNode(500))
            System.out.println("found..");
        else
            System.out.println("not found..");

        System.out.println("\nDeleting the node having location = 0: ");
        System.out.println("Before Deletion:");
        list.traverseLinkedList();
        list.deletionOfNode(0);
        System.out.println("\nAfter Deletion:");
        list.traverseLinkedList();
        System.out.println();

        System.out.println("\nDeleting the node having location = 2: ");
        System.out.println("Before Deletion:");
        list.traverseLinkedList();
        list.deletionOfNode(2); //5 40 10 30 20
        System.out.println("\nAfter Deletion:");
        list.traverseLinkedList();
        System.out.println();


        System.out.println("\nDeleting the node having location = 100: ");
        System.out.println("Before Deletion:");
        list.traverseLinkedList();
        list.deletionOfNode(100);
        System.out.println("After Deletion:");
        list.traverseLinkedList();
        System.out.println();


        list.deleteLinkedList();
        list.traverseLinkedList();
    }
}
