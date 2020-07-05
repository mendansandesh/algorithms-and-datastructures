package sorting;

/**
 * @author Sandesh Mendan on 05/07/20
 * @project algorithms-and-datastructures
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = { 10, 5, 30, 15, 50, 6  };
        quickSort(arr, 0, arr.length-1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int pivot = partition(arr, start, end);
        if(start < pivot-1)
            quickSort(arr, start, pivot-1);
        if(pivot < end)
            quickSort(arr, pivot, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end){
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
