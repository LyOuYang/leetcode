package medium;

public class T1218_最长定差子序列 {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[40001];
        int ans = 0;
        for(int i : arr) {
            int j = i + 20000;
            dp[j] = dp[j - difference] + 1;
            ans = Math.max(dp[j], ans);
        }
        return ans;
    }
}
