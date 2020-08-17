package problems.geeksforgeeks.array;

/**
 * @author sandesh.mendan on 14/08/20
 * @project algorithms-and-datastructures
 */
public class RepeatedAndMissingNumber {
    public static void main(String[] args){
        int[] arr = {2, 1, 3, 2};
        findRepeatedAndMissingNumber(arr);
    }

    private static void findRepeatedAndMissingNumber(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int absVal = Math.abs(arr[i]);
            if(arr[absVal - 1] > 0)
                arr[absVal - 1] = -arr[absVal - 1];
            else
                System.out.println("Repeated num is: " + absVal);
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0)
                System.out.println("Missing num is: " + (i+1));
        }
    }
}