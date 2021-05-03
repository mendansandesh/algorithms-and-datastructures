package interview.walmart;

import java.util.*;

/*Given a non-empty list of words, return the 'k' most frequent elements. Your answer should be sorted by frequency from highest to lowest.

example =
Input: ["bat", "bat", "the", "wall", "wall", "bat", "cat", "sun"], k = 2
Output: ["bat", "wall"]

bat - 3
wall - 3


result: bat wall

Input: ["a", "bat", "the", "wall", "wall", "bat", "cat", "sun", "sun", "sun"], k = 3
Output: ["sun", "bat", "wall"]
*/
public class KmostFrequentWords {

    public static void main(String[] args){
        String[] strings = {"bat", "bat", "the", "wall", "wall", "bat", "cat", "sun"};
        for(String str : kFrequentWords(Arrays.asList(strings), 2))
            System.out.print(str + " ");
    }

    public static List<String> kFrequentWords(List<String> input, int k){
        //construct freq count map -- N : length of input
        //construct maxHeap of size k based on freqCount -- log k
        //remove all words from maxHeap  logK

        //totalComplx: N * logK
        //Space: O(N)

        List<String> result = new LinkedList<>();
        Map<String, Integer> freqCounter = new HashMap<>();
        for(String word : input){
            freqCounter.put(word, freqCounter.getOrDefault(word, 0) + 1);
        }

        //maxHeap construction and fill
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>
                (k, (a, b) -> (!b.getValue().equals(a.getValue())) ?
                        (b.getValue() - a.getValue()) : b.getKey().compareTo(a.getKey())); // handle same word case

        maxHeap.addAll(freqCounter.entrySet());

        while(k > 0){
            String maxHeapContent = maxHeap.remove().getKey();
            result.add(maxHeapContent);
            k--;
        }

        return result;

    }

}
