package problems.leetcode;

import java.util.Arrays;

/*
    Problem: https://www.lintcode.com/problem/meeting-rooms/
    TimeComplexity:
    SpaceComplexity:
*/
public class MeetingRoomI {
    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);
        System.out.println(canAttendMeetings(new Interval[]{i1, i2, i3}));

        Interval i4 = new Interval(7, 10);
        Interval i5 = new Interval(2, 4);
        System.out.println(canAttendMeetings(new Interval[]{i4, i5}));
    }
    public static boolean canAttendMeetings(Interval[] intervals){
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < intervals.length - 1; i++){
            if(starts[i + 1] < ends[i])
                return false;
        }
        return true;
    }
}
class Interval {
    int start;
    int end;
    Interval(){
        this.start = 0;
        this.end = 0;
    }
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
