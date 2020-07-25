package problems.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sandesh.mendan on 23/07/20
 * @project algorithms-and-datastructures
 */

//Problem: https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedString {
    public static void main(String[] args){
        String s = "a";
        long n = 1000000000;
        System.out.println(repeatedString(s, n));
    }

    static long repeatedString(String s, long n) {
        int occurrenceOfAs = countAcharInstring(s, 'a');
        long t1 = (n/s.length()) * occurrenceOfAs;
        int occ = 0;
        if(n % s.length() == 0)
            return t1;
        else {
            int rem = (int) (n % s.length());
            String ss = s.substring(0, rem);
            occ = countAcharInstring(ss, 'a');
        }
        return t1+occ;
    }

    private static int countAcharInstring(String s, char ch) {
        Matcher matcher = Pattern.compile(String.valueOf(ch)).matcher(s);
        int res = 0;
        while (matcher.find()) {
            res++;
        }
        return res;
    }
}
