package problems.leetcode;

/**
 * @author sandesh.mendan on 27/11/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
// Time: O(N)
// Space: O(N)
public class RemoveDuplicates {
    public static void main(String[] a){
        String s = "deeedbbcccbdaa";
        System.out.println(removeDuplicates(s));
    }

    private static String removeDuplicates(String S) {
        char[] chars = new char[S.length()];//to add/delete char from string
        int i = 0;//index to track chars array
        for(int j = 0; j < S.length(); j++){
            char currChar = S.charAt(j);
            if(i > 0 && chars[i-1] == currChar){
                i--;
            }else {
                chars[i] = currChar;
                i++;
            }
        }
        return new String(chars, 0, i);
    }

}
