package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    Problem: https://leetcode.com/problems/group-anagrams/
    TimeComplexity:
    SpaceComplexity:
*/

public class AnagramGroups {
    public static void main(String[] args) {
        List<String> listOfWords = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        System.out.println(groupAnagrams(listOfWords));
    }

    private static List<List<String>> groupAnagrams(List<String> listOfWords) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        HashMap<String, List<String>> sortedWordTracker = new HashMap<>();
        //foreach word; sort it and store in hashmap as key = sortedWord and value is List<actualWord>
        for(String word : listOfWords){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String wordSorted = new String(chars);
            if(!sortedWordTracker.containsKey(wordSorted)){
                sortedWordTracker.put(wordSorted, new ArrayList<>());
            }
            sortedWordTracker.get(wordSorted).add(word);
        }
        groupedAnagrams.addAll(sortedWordTracker.values());
        return groupedAnagrams;
    }
}
