package interview.linkedin;

/**
 * @author sandesh.mendan on 27/11/20
 * @project algorithms-and-datastructures
 */
// Problem: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
// Time: O(N)
// Space: O(N)
public class RemoveDuplicates2 {
    public static void main(String[] a){
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s); //to add/delete char from string
        int[] freqCount = new int[sb.length()]; //to track count of corresponding char from sb
        int index = 0; //

        while (index < sb.length()){
                if(index == 0 || sb.charAt(index) != sb.charAt(index - 1)) {
                    freqCount[index] = 1;
                }
                else{
                    freqCount[index] = freqCount[index - 1] + 1;
                    if(freqCount[index] == k){
                        sb.delete(index - k + 1, index + 1); //+1 because index starting from 0
                        index = index - k;
                    }
                }
                index++;
        }

        return sb.toString();
    }
}
