package interview.walmart;

import java.util.ArrayList;
import java.util.List;

public class PatternMatch {
    public static void main(String[] args){
        System.out.println(patternMatch("AABBCCDD", "A#B#D"));
    }

    private static boolean patternMatch(String input, String pattern) {
        //prev and curr pointer
        //case if 0th is alphabet in pattern
            //neutralize the same position in input
            //if next is #, then till we get first alphabet post  #+1's position in input string; create temp string and put to result
        //case if 0th is #, then till we get first alphabet post  #+1's position in input string; create temp string and put to result
        //if j == pattern lengthhashPositionInPattern
        int nextChar = 0;
        int prevChar = 0;
        int hashPositionInPattern = 0;
        int inputIndex = 0;
        int patternIndex = 0;
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        while(patternIndex <= pattern.length()){
            hashPositionInPattern = pattern.substring(hashPositionInPattern).indexOf("#"); //hashPositionInPattern + 1
            prevChar = input.indexOf(pattern.toCharArray()[hashPositionInPattern - 1]);
            nextChar = input.indexOf(pattern.toCharArray()[hashPositionInPattern + 1]);
            temp.append(input, prevChar, nextChar);
            prevChar = nextChar;

        }
        return false;
    }

}
