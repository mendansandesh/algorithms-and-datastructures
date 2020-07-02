package binaryheap;

/**
 * @author Sandesh Mendan on 02/07/20
 * @project algorithms-and-datastructures
 */
public class HeapByArray {
    int[] arr;
    int sizeOfTree;
    //Note: Min Heap implementation

    public HeapByArray(int size) {
        arr = new int[size + 1]; //to exclude first array index i.e., first elem starts from position 1
        this.sizeOfTree = 0;
    }

    public boolean isHeapEmpty(){
        return sizeOfTree <= 0;
    }

    public void insertInHeap(int value) {
        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree);
        System.out.println("Inserted " + value + " successfully in Heap !");
    }

    private void heapifyBottomToTop(int index) {
        int parent = index / 2;
        if(index <= 1)
            return;
        if(arr[index] < arr[parent]){
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
        }
        heapifyBottomToTop(parent);
    }

    public void levelOrder() {
        System.out.println("Printing all the elements of this Heap...");// Printing from 1 because 0th cell is dummy
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    public int extractHeadOfHeap() {
        if(isHeapEmpty()){
            System.out.println("Heap is empty heap! Returning -1");
            return -1;
        }else {
            int topElemOfHeap = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1);
            return topElemOfHeap;
        }
    }

    private void heapifyTopToBottom(int index) {
        int leftChildIndex  = 2 * index;
        int rightChildIndex = 2 * index + 1;
        int smallestChildIndex = 0;

        if(sizeOfTree < leftChildIndex) //i.e., sizeOfTree is 1
            return;
        else if(sizeOfTree == leftChildIndex){ //only one child
            if(arr[index] > arr[leftChildIndex]){
                int temp = arr[index];
                arr[index] = arr[leftChildIndex];
                arr[leftChildIndex] = temp;
            }
            return;
        }else {
            smallestChildIndex = (arr[leftChildIndex] < arr[rightChildIndex]) ? leftChildIndex : rightChildIndex;
            if(arr[index] > arr[smallestChildIndex]){
                int temp = arr[index];
                arr[index] = arr[smallestChildIndex];
                arr[smallestChildIndex] = temp;
            }
        }
        heapifyTopToBottom(smallestChildIndex); //todo check if it is necessary in case root is already sorted
    }
}
