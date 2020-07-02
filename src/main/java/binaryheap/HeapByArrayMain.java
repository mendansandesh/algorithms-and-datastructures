package binaryheap;

/**
 * @author Sandesh Mendan on 02/07/20
 * @project algorithms-and-datastructures
 */
public class HeapByArrayMain {
    public static void main(String[] args) {
        System.out.println("Creating a blank Heap");
        HeapByArray heap = new HeapByArray(10);

        //Note: Min Heap implementation
        heap.insertInHeap(100);
        heap.insertInHeap(90);
        heap.insertInHeap(80);
        heap.insertInHeap(70);
        heap.insertInHeap(60);
        heap.insertInHeap(50);
        heap.insertInHeap(40);
        heap.insertInHeap(30);
        heap.insertInHeap(20);
        heap.levelOrder();

        System.out.println("Extract top of heap: " + heap.extractHeadOfHeap());
        heap.levelOrder();

        heap.insertInHeap(110);
        System.out.println();
        heap.levelOrder();

        System.out.println("\nExtract top of heap: " + heap.extractHeadOfHeap());
        heap.levelOrder();
    }
}
