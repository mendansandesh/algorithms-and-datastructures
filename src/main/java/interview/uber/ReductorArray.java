package interview.uber;

/**
 * @author sandesh.mendan on 27/10/20
 * @project algorithms-and-datastructures
 */
// Problem: Given 2 array 'a', 'b' and integer value 'd', our task is to find comparator value between these array
// Comparator value is the count of elements in 'a' whose absolute difference against each elem in 'b', should be greater
// than given value 'd'
public class ReductorArray {
    public static void main(String[] args){
        int[] a = {7, 5, 9};
        int[] b = {13, 1, 4};
        int d = 3;
        System.out.println(reductorArray(a, b, d));
    }

    private static int reductorArray(int[] a, int[] b, int d) {
        boolean allGreat;
        int comparator = 0;
        for (int i = 0; i < a.length; i++) {
            allGreat = true;

            for (int j = 0; j < b.length; j++) {

                int diff = Math.abs(a[i]- b[j]);

                if(diff <= d) {
                    allGreat = false;
                    break;
                }
            }

            if (allGreat) comparator++;
        }
        return comparator;
    }
}
