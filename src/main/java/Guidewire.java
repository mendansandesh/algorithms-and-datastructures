import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guidewire {
    public static void main(String[] args){
        System.out.println(solution(new int[]{1,12,42,70, 36, -4, 43, 15}, new int[]{5,15,44,72,36,2,69,24}));
    }

    public static int solution(int[] A, int[] B) {
        //assuming A and B are same length
        int[][] intervals = createIntervals(A, B); // new int[][]{{-4, 5},{12,24},{42,69},{70,72},{36,36}}; //

        if (intervals.length <= 1)
            return -1;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.size();
    }

    public static int[][] createIntervals(int[] A, int[] B) {

        int[][] intervals = new int[A.length][2];
        for(int i = 0; i < A.length; i++){
            intervals[i][0] = A[i];
            intervals[i][1] = B[i];
        }
        return intervals;
    }
}
