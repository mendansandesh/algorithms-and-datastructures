package interview.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sandesh.mendan on 09/11/20
 * @project algorithms-and-datastructures
 */
//Problem: https://leetcode.com/discuss/interview-question/854110/amazon-oa-2020-five-star-sellers
public class FiveStarSeller {
    public static void main(String[] args){
        List<List<Integer>> productRatings = Arrays.asList(Arrays.asList(4,4), Arrays.asList(1,2), Arrays.asList(3,6));
        System.out.println(fiveStarReviews(productRatings, 77));
    }

    public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingThreshold) {
        int result = 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> percChange(l2) - percChange(l1)); // max-heap.
        for (List<Integer> rating : productRatings)
            pq.offer(rating); // initialize PriorityQueue.
        double curRating = 0;
        for (List<Integer> rating : productRatings)
            curRating += 100.0 * rating.get(0) / rating.get(1); // initialize curRating.
        while (curRating < ratingThreshold * productRatings.size()) {
            result++;
            List<Integer> rating = pq.poll();
            List<Integer> newRating = Arrays.asList(rating.get(0) + 1, rating.get(1) + 1);
            curRating = curRating - 100.0 * rating.get(0) / rating.get(1) + 100.0 * newRating.get(0) / newRating.get(1); // keep
            pq.offer(newRating);
        }
        return result;
    }

    private static int percChange(List<Integer> p) {
        double currRating = 100.0 * p.get(0) / p.get(1);
        double newRating = 100.0 * (p.get(0) + 1) / (p.get(1) + 1);
        return (int) (newRating - currRating);
    }
}
