package problems.geeksforgeeks.string;

/**
 * @author sandesh.mendan on 25/07/20
 * @project algorithms-and-datastructures
 * Problem: https://practice.geeksforgeeks.org/problems/palindrome-string/0
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindromeCheck("abba") ? "Yes" : "No");
    }

    private static boolean palindromeCheck(String str) {
        char[] chars = str.toCharArray();
        int j = (str.length() % 2 == 0) ? str.length()/2 : (str.length()/2) + 1;
        for(int i = (str.length()/2) - 1; i >= 0 && j < str.length(); i--, j++)
            if(chars[i] != chars[j])
                return false;
        return true;
    }
}
