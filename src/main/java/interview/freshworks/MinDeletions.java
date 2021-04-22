package interview.freshworks;

import java.util.Arrays;

public class MinDeletions {
    public static void main(String[] args) {
        System.out.println(minDeletions("heap", "pea"));
    }

    private static int minDeletions(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        int lengthOfLongestCommonSubsequence = minDeletions(dp, s1, 0, s2, 0);
        int lengthOfLongestCommonSubsequenceInS1S2 = lengthOfLongestCommonSubsequence * 2;
        int lengthOfS1AndS2 = s1.length() + s2.length();
        int minDeletions = lengthOfS1AndS2 - lengthOfLongestCommonSubsequenceInS1S2;
        return minDeletions;
    }

    private static int minDeletions(int[][] dp, String s1, int i, String s2, int j) {
        if(i == s1.length() || j == s2.length())
            return 0;
        if(dp[i][j] == -1){
            int case1 = 0;
            if(s1.charAt(i) == s2.charAt(j))
                case1 = 1 + minDeletions(dp, s1, i+1, s2, j+1);
            int case2 = minDeletions(dp, s1, i, s2, j+1);
            int case3 = minDeletions(dp, s1, i+1, s2, j);
            dp[i][j] = Math.max(case1, Math.max(case2, case3));
        }
        return dp[i][j];
    }

}
