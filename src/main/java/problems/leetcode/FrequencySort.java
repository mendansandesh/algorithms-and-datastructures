package problems.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sandesh.mendan on 30/11/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/sort-characters-by-frequency/
// Time: O(N + Log(N))
// Space: O(N)
public class FrequencySort {
    public static void main(String[] a){
        System.out.println(frequencySort("Aabb"));
    }

    private static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char top = maxHeap.poll();
            for(int i = 0; i < map.get(top); i++)
                sb.append(top);
        }
        return sb.toString();
    }
}
