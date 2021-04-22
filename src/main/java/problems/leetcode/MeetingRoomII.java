package problems.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
    Problem: https://www.lintcode.com/problem/meeting-rooms-ii/
    TimeComplexity:
    SpaceComplexity:
*/
public class MeetingRoomII {
    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);
        System.out.println(minMeetingRooms(new Interval[]{i1, i2, i3}));

        Interval i4 = new Interval(7, 10);
        Interval i5 = new Interval(2, 4);
        System.out.println(minMeetingRooms(new Interval[]{i4, i5}));
    }

    public static int minMeetingRooms(Interval[] intervals){
        if(intervals == null || intervals.length == 0)
            return 0;

        //idea is: if overlapping meeting time for 2 meeting then need different room;
        //if non-overlapping meetings, then can use same room

        //sort based on start time
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        //minHeap sorted by end time
        //used to store meeting intervals: for multiple meeting if non-overlapping, merge the interval;
        // so that its count is considered as 1 (one meeting room)
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        minHeap.add(intervals[0]); //first Interval needs 1 meeting room; so directly add to minHeap

        for(int i = 1; i < intervals.length; i++){
            Interval earliestEnd = minHeap.remove();
            Interval current = intervals[i];

            //add to minHeap if curr startTime is less than earliest endTime;
            if(current.start < earliestEnd.end)
                minHeap.add(current);
            else //update the current endTime to earliest endTime; kind of extending/merging the interval => using same meeting room
                earliestEnd.end = current.end;

            //update minHeap by adding it back
            minHeap.add(earliestEnd);
        }

        return minHeap.size();
    }
}
