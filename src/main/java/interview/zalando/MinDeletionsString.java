package interview.zalando;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
//Time O(N)
//Space O(1)
public class MinDeletionsString {
    public static void main(String[] args){
        System.out.println(minDeletions("ccaafff"));
    }

    private static int minDeletions(String s) {
        int minDeletions = 0;
        int[] frequency = new int[26];
        Set<Integer> occurredCount = new HashSet<>();

        for(int i = 0; i < s.length(); i++)
            ++frequency[s.charAt(i) - 'a'];

        for(int i = 0; i < 26; i++){
            while(frequency[i] > 0 && !occurredCount.add(frequency[i])){
                    --frequency[i];
                    minDeletions++;
            }
        }
        return minDeletions;
    }
}
