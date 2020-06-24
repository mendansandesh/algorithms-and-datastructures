package linkedlist;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.createDoublyLinkedList(5);

        list.insertInLinkedList(10, 1);
        list.insertInLinkedList(20, 2);
        list.insertInLinkedList(30, 3);
        list.insertInLinkedList(40, 4);

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


        System.out.println("\n\nLinkedList in order");
        list.traverseLinkedList();
        System.out.println("\nLinked List in reverse order");
        list.traverseLinkedListInReverseOrder();


        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("List before deletion: ");
        list.traverseLinkedList();
        list.deletionOfNode(2);
        System.out.println("\nList after deletion: ");
        list.traverseLinkedList();


        System.out.println("\n\nDeleting the node having location = 3: ");
        System.out.println("List before deletion: ");
        list.traverseLinkedList();
        list.deletionOfNode(3);
        System.out.println("\nList after deletion: ");
        list.traverseLinkedList();


        list.deleteLinkedList();
        list.traverseLinkedList();

    }
}
