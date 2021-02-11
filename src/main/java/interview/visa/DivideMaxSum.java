package interview.visa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    online test: keep dividing the list elems by 2 for k times, such that sum of list elems after division is maximum
 */
public class DivideMaxSum {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(10);num.add(20);num.add(7);

        System.out.println(maxSum(num, 4));
    }
    public static int maxSum(List<Integer> num, int k) {
        int result = 0;
        num.sort(Collections.reverseOrder());

        while (k > 0){
            for(int i = 0; k > 0 && i < num.size(); i++) {
                int val = (int) Math.ceil(num.get(i)/2.0);
                System.out.print(val+ " ");
                num.set(i, val);
                k--;
            }

        }

        for(Integer item : num)
            result += item;
        System.out.println();
        return result;
    }
}
