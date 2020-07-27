package problems.geeksforgeeks.string;

/**
 * @author sandesh.mendan on 26/07/20
 * @project algorithms-and-datastructures
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println(anagramCheck("abt", "bat") ? "Yes" : "No");
    }

    private static boolean anagramCheck(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        char[] chars = str1.toCharArray();
        for(int i = 0; i < str1.length(); i++)
            if(str2.indexOf(chars[i]) == -1)
                return false;
        return true;
    }
}
