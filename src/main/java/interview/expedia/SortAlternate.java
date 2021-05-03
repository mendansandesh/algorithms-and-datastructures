package interview.expedia;
/**
 *     Generate all possible sorted arrays from alternate elements of two given sorted arrays
 *     A = {10, 15, 25}
 *     B = {1, 5, 20, 30}
 *
 *     TimeComplexity:
 *     O((aLength x bLength) + (bLength x aLength))
 *
 *     The resulting arrays are:
 *             10 20
 *             10 20 25 30
 *             10 30
 *             15 20
 *             15 20 25 30
 *             15 30
 *             25 30
 *             10 20 25
 */

public class SortAlternate {

    void printAlternateElements(int[] a, int[] b){
        int aLength = a.length;
        int bLength = b.length;
        int[] c = new int[aLength + bLength];
        printAlternateElements(a, b, c, 0, 0, aLength, bLength, 0, true);
    }

    void printAlternateElements(int[] a, int[] b, int[] c, int i, int j, int m, int n, int index, boolean alternateFlag){
        printResultArray(c);
        if(alternateFlag){
            for(int k = i; k < m; k++){
                if(index == 0){
                    c[index] = a[k];
                    printAlternateElements(a, b, c, k+1, j, m, n, index+1, !alternateFlag);
                }else if (a[k] > c[index]){
                        c[index++] = a[k];
                        printAlternateElements(a, b, c, k+1, j, m, n, index+1, !alternateFlag);
                }
            }
        }else {
            for(int l = j; l < n; l++){
                if(b[l] > c[index]){
                    c[index++] = b[l];
                    printAlternateElements(a, b, c, i, l+1, m, n, index+1, !alternateFlag);
                }
            }
        }
    }

    void printResultArray(int[] c){
        for(int i = 0; i < c.length; i++){
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }
}
