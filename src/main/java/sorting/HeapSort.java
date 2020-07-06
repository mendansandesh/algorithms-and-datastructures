package sorting;

import binaryheap.HeapByArray;

/**
 * @author Sandesh Mendan on 05/07/20
 * @project algorithms-and-datastructures
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 5, 30, 15, 50, 6};
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        HeapByArray heap = new HeapByArray(arr.length); //earlier created min heap
        for(int elem : arr)
            heap.insertInHeap(elem);    //insert into heap

        heap.levelOrder(); //heap after insertion

        System.out.println("Sorted Elements..");
        while (!heap.isHeapEmpty())
            System.out.print(heap.extractHeadOfHeap() + " ");   //extract heap to get sorted elements
    }
}