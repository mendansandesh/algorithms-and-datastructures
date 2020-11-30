package problems.leetcode;

import problems.utils.Helper;

/**
 * @author sandesh.mendan on 30/11/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/string-compression/
// Time: O(N)
// Space: O(1)
public class RunningLengthEncoding {
    public static void main(String[] a){
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'b'};
        System.out.println(compress(chars));
    }

    private static int compress(char[] chars){
        int resultIndex = 0; //to store the result in same input array
        int i = 0; //pointer 1
        int j; //pointer 2
        while (i < chars.length){
            j = i+1;
            while (j < chars.length && chars[i] == chars[j]){
                j++;
            }
            chars[resultIndex++] = chars[i];
            if(j-i > 1) { //consider to print count only if the character is repeated atleast twice
                String count = j - i + ""; //convert occurrence digit to String
                for (char c : count.toCharArray()) //need for loop in case of 2 digits long
                    chars[resultIndex++] = c;
            }
            i = j;
        }
        return resultIndex; //do not use chars.length as it will give initial input length
    }
}
