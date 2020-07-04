package sorting;

/**
 * @author Sandesh Mendan on 04/07/20
 * @project algorithms-and-datastructures
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] arr = { 10, 5, 30, 15, 50, 6 };
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){    //sorted array portion
            int minElemPosition = i;
            for(int j = i+1; j < arr.length; j++){  //find minElemPosition from unsorted portion of array
                if(arr[j] < arr[minElemPosition])
                    minElemPosition = j;
            }
            //swap if some other minElemPosition is found (than earlier set ith position)
            if(minElemPosition != i){
                int temp = arr[i];
                arr[i] = arr[minElemPosition];
                arr[minElemPosition] = temp;
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
