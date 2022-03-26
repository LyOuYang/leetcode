package simple;

import org.junit.Test;

public class T553_最优除法 {
    @Test
    public void test() {
        optimalDivision(new int[] {1000,1,10,2});
    }
    StringBuffer sb = new StringBuffer();
    public String optimalDivision(int[] nums) {
        int dfs = (int) dfs(0, nums, true);
        System.out.println(dfs);
        return "123";
    }

    private double dfs(int i, int[] nums, boolean isMax) {
        if (i >= nums.length) {
            return 1.0;
        }
        double v1 = nums[i] / dfs(i + 1, nums, !isMax);

        double v2 = nums[i] / (i+1== nums.length? 1 : nums[i+1]) / dfs(i + 2, nums, !isMax);
        return isMax?Math.max(v1, v2) : Math.min(v1,v2);
    }
}
