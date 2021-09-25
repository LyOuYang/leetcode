package medium;

import org.junit.Test;

import java.util.Arrays;
public class T1143_最长公共子序列 {
    @Test
    public void test() {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        longestCommonSubsequence(text1, text2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[2][l1 + 1];
        Arrays.fill(dp[0], 0);
        int max = 0;
        for (int i = 1; i < l2 + 1; i++) {
            for (int j = 1; j < l1 + 1; j++) {
                if (text1.charAt(j - 1) == text2.charAt(i - 1)) {
                    dp[1][j] = dp[0][j - 1] + 1;
                    max = Math.max(max, dp[1][j]);
                } else {
                    dp[1][j] = Math.max(dp[1][j-1], dp[0][j]);
                }
            }
            dp[0] = Arrays.copyOf(dp[1], l1 + 1);
        }
        return max;
    }
}
