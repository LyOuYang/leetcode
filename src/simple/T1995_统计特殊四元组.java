package simple;

public class T1995_统计特殊四元组 {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[101];
        int count = 0;
        for (int b = n - 3; b >= 1; b--) {
            int c = b + 1;
            for (int d = c + 1; d < n; d++) {
                if (nums[d] - nums[c] > 0)
                    cnt[nums[d] - nums[c]]++;
            }

            for (int a = 0; a < b; a++) {
                if (nums[a] + nums[b] <= 100)
                    count += cnt[nums[a] + nums[b]];
            }
        }

        return count;
    }
}
