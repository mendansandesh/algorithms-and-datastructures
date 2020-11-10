package interview.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sandesh.mendan on 10/11/20
 * @project algorithms-and-datastructures
 */
// Problem: print pythagorean triplet; one triplet
public class PythagoreanTriplet {
    public static void main(String[] args){
        int[] arr = {9,3,1,6,10,4,8};
        System.out.println(findPythagoreanTriplet(arr));
    }

    private static List<Integer> findPythagoreanTriplet(int[] arr) {
        List<Integer> result = new ArrayList<>();
        //square each elem
        int[] squaredArray = Arrays.stream(arr).map(x -> x * x).toArray();

        //sort the squared elements
        Arrays.sort(squaredArray);

        // pick z from lastIndex to 2nd index
        // x starts from 0 and y from z-1
        // find (x, y) if (sum( squaredArray(x), squaredArray(y) == squaredArray(z) )) return true/add to result
        //             else if( sum( squaredArray(x), squaredArray(y) < squaredArray(z) ) ) x++ //skip small nums
        //             else y-- //skip big nums
        for(int z = squaredArray.length-1; z >= 2; z--){
            int x = 0;
            int y = z-1;
            while (x < y){
                if(squaredArray[x] + squaredArray[y] == squaredArray[z]){
                    result.addAll(Arrays.asList((int)Math.sqrt(squaredArray[x]), (int)Math.sqrt(squaredArray[y]), (int)Math.sqrt(squaredArray[z])));
                    return result;
                }
                if(squaredArray[x] + squaredArray[y] < squaredArray[z])
                    x++;
                else
                    y--;
            }
        }
        return result;
    }

}
