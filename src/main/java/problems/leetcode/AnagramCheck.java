package problems.leetcode;
/*
    Problem: https://leetcode.com/problems/valid-anagram/
    TimeComplexity:
    SpaceComplexity:
*/

public class AnagramCheck {
    public static void main(String[] args) {
        System.out.println(anagramCheck("madam", "damam"));
    }

    private static boolean anagramCheck(String s1, String s2) {
        //cant be anagram if 2 lengths are not same
        if(s1.length() != s2.length())
            return false;

        int[] charCounts = new int[26];

        //for each s1 char store its occurrences in charCounts; and for each s2 decrement from charCounts
        for(int i = 0; i < s1.length(); i++){
            charCounts[s1.charAt(i) - 'a']++;
            charCounts[s2.charAt(i) - 'a']--;
        }

        //thus if s1 and s2 are anagrams, charCounts should have all zeros as its values stored
        for(int i = 0; i < charCounts.length; i++){
            if(charCounts[i] != 0)
                return false;
        }
        return true;
    }
}
