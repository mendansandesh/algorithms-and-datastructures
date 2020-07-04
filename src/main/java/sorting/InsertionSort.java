package sorting;

/**
 * @author Sandesh Mendan on 04/07/20
 * @project algorithms-and-datastructures
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] arr = { 10, 5, 30, 15, 50, 6 };
        insertionSort(arr);
        printArray(arr);
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++){    //unsorted array
            for(int j = i; j >= 0 && arr[j] < arr[j-1]; j--){   //creates sorted array backwards direction until it finds first sorted position
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
