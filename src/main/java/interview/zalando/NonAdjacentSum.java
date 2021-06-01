package interview.zalando;

//https://gist.github.com/johnelm/7e9c86c043d804f1b0b1446421034973
//Time O(N)
//Space O(1)
public class NonAdjacentSum {
    public static void main(String[] args){
        int[] arr = {5,2,4,6,3,7};
        System.out.println(minimumSumOfNonAdjacentElements(arr));
    }
    public static int minimumSumOfNonAdjacentElements(int[] array) {
        int result = Integer.MAX_VALUE;
        int min = array[1];
        for (int i = 3; i < array.length - 1; i++) {
            min = Math.min(min, array[i - 2]);
            result = Math.min(result, min + array[i]);
        }
        return result;
    }

    public static int minimumSumOfNonAdjacentElements1(int[] a) {
        // the result for the sequence a[1:i]
        int minSum = Integer.MAX_VALUE;
        int minSumElement1 = Integer.MAX_VALUE;
        int minSumElement2 = Integer.MAX_VALUE;

        // the minimum element eligible for joining with a[i], i.e. from a[1 : i-2]
        int minElement = a[1];

        int prevElement = a[2]; // a[i - 1]
        for (int i = 3; i+1 < a.length; i++) {
            int sum = minElement + a[i];
            if (sum < minSum) {
                minSum = sum;
                minSumElement1 = minElement;
                minSumElement2 = a[i];
            }

            if (prevElement < minElement) {
                minElement = prevElement;
            }
            prevElement = a[i];
        }

        return minSumElement1 + minSumElement2;
    }
}
