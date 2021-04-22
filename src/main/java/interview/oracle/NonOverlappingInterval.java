package interview.oracle;

import java.util.*;

public class NonOverlappingInterval {
    public static void main(String[] args){
        //[[3,6],[1,2][3,4][5,7]]
        // [[1,2],[3,4],[3,6],[5,7]]
        // [1,7],[2,3] [2,6] [4,5]
        // [1,7],[2,6] [2,3] [4,5]
        //System.out.println(maxNonOverLappingInterval(new int[][]{{3,6},{1,2},{3,4},{5,7}}));
        System.out.println(maxNonOverLappingInterval(new int[][]{{2,3},{2,6},{1,7},{4,5}}));
    }
    public static int maxNonOverLappingInterval(int[][] input){
        int maxCount = 1;

        List<Interval> intervalList = new LinkedList<>();
        for(int i = 0; i < input.length; i++){
            Interval interval = new Interval(input[i][0], input[i][1]);
            intervalList.add(interval);
        }

        //sort
        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return ( (i1.start != i2.start) ? (i1.start - i2.start) : (i2.end - i1.end));
            }
        });

        for(int i = 0; i < intervalList.size() - 1; i++){
            if(intervalList.get(i).end < intervalList.get(i+1).start){
                maxCount++;
            }
        }
        return maxCount;
    }
}
class Interval{
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
