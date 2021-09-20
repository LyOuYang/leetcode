package medium;

public class T673_最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        int l =  nums.length, maxLen = 0, ans = 0;;
        int[] dp = new int[l];
        int[] ct = new int[l];

        for (int i = 0; i < l; i++) {
            dp[i] = 1;
            ct[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        ct[i] = ct[j];
                    } else if (dp[i] == dp[j] + 1) {
                        ct[i] += ct[j];
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = ct[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += ct[i];
            }
        }
        return ans;
    }
}
