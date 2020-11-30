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
        String s = "deeedbbcccbdppaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        char[] chars = new char[s.length()];//to add/delete char from string
        int[] freqCount = new int[chars.length]; //to track count of corresponding char from sb
        int i = 0;//index to track chars array
        for(int j = 0; j < s.length(); j++){
            char currChar = s.charAt(j);
            if(i > 0 && chars[i-1] == currChar){
                chars[i] = currChar;
                freqCount[i] = freqCount[i-1] + 1;
                if(freqCount[i] == k) // when freqCount reaches threshold k; remove that char by decrementing i by k
                    i = i - k;
            }else {
                chars[i] = currChar;
                freqCount[i] = 1;
            }
            i++;
        }
        return new String(chars, 0, i);

        //below also same logic; coded slightly differently
        /*StringBuilder sb = new StringBuilder(s); //to add/delete char from string
        int[] freqCount = new int[sb.length()]; //to track count of corresponding char from sb
        int i = 0; //index to track sb

        while (i < sb.length()){
                if(i > 0 && sb.charAt(i) == sb.charAt(i - 1)){
                    freqCount[i] = freqCount[i - 1] + 1;
                    if(freqCount[i] == k){
                        sb.delete(i - k + 1, i + 1);
                        i = i - k;
                    }
                }else {
                    freqCount[i] = 1;
                }
                *//*if(index == 0 || sb.charAt(index) != sb.charAt(index - 1)) {
                    freqCount[index] = 1;
                }
                else{
                    freqCount[index] = freqCount[index - 1] + 1;
                    if(freqCount[index] == k){
                        sb.delete(index - k + 1, index + 1); //+1 because index starting from 0
                        index = index - k;
                    }
                }*//*
                i++;
        }

        return sb.toString();*/
    }
}
