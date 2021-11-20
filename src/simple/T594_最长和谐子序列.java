package simple;

import java.util.HashMap;
import java.util.Map;

public class T594_最长和谐子序列 {
    public int findLHS(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max,
                    Math.max(map.containsKey(nums[i] + 1) ? map.get(nums[i]) + map.get(nums[i] + 1) : 0,
                            map.containsKey(nums[i] - 1) ? map.get(nums[i]) + map.get(nums[i] - 1) : 0));
        }
        return max;
    }
}
