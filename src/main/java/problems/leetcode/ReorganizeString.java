package problems.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
    Problem: https://leetcode.com/problems/reorganize-string/
    TimeComplexity:
        - MaxHeap create O(N)
        - MaxHeap remove O(N logN)
        - StringBuilder O(N)
    SpaceComplexity: minimum of M and N
*/
public class ReorganizeString {
    public static void main(String[] args){
        System.out.println(reorganizeString("aab"));
    }

    public static String reorganizeString(String S) {
        //create char frequency of occurrences
        Map<Character, Integer> charFreqCounter = new HashMap<>();
        for(Character c : S.toCharArray())
            charFreqCounter.put(c, charFreqCounter.getOrDefault(c, 0) + 1);

        //create maxHeap
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charFreqCounter.get(b) - charFreqCounter.get(a));
        pq.addAll(charFreqCounter.keySet());

        //sb to store final result
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){ // handle the case of last remaining char at the end
            char firstHighest  = pq.remove();   //take char from maxHeap
            char secondHighest = pq.remove();
            sb.append(firstHighest);    //add to sb
            sb.append(secondHighest);
            charFreqCounter.put(firstHighest, charFreqCounter.get(firstHighest) - 1); //decrement its count from charFreqCounter
            charFreqCounter.put(secondHighest, charFreqCounter.get(secondHighest) - 1);
            if(charFreqCounter.get(firstHighest) > 0) //if char count is not 0, then add it back to maxHeap
                pq.add(firstHighest);
            if(charFreqCounter.get(secondHighest) > 0)
                pq.add(secondHighest);
        }

        if(!pq.isEmpty()){ //for last char
            char lastChar = pq.remove();
            if(charFreqCounter.get(lastChar) > 1) //still its char count > 1, then it has to adjacent in sb, so return ""
                return "";
            sb.append(lastChar); // else add to sb
        }

        return sb.toString();
    }
}
