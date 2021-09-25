package medium;

import java.util.Arrays;

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 */
public class T583_两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[2][l1 + 1];
        Arrays.fill(dp[0], 0);
        int max = 0;
        for (int i = 1; i < l2 + 1; i++) {
            for (int j = 1; j < l1 + 1; j++) {
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[1][j] = dp[0][j - 1] + 1;
                    max = Math.max(max, dp[1][j]);
                } else {
                    dp[1][j] = Math.max(dp[1][j-1], dp[0][j]);
                }
            }
            dp[0] = Arrays.copyOf(dp[1], l1 + 1);
        }
        return l1 + l2 - max << 1;
    }
}
