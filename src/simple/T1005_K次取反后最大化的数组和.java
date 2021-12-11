package simple;

import org.junit.Test;

public class T1005_K次取反后最大化的数组和 {
    @Test
    public void test() {
        int[] nums = {-10,-27,-24,-25,-5,-26,-7,20,-11,11,1,9,26,28,1,-6,26,-28,7,-3,26,-16,26,26,-27,-5,-15,27,29,20,-23,-29,-12,0,27,15,-7,-22,8,7,16,-24,16,-10,10,1,24,-17,-8,5,-7,14,24,-2,-7,-7,4,-7,-3,21,19,11,11,-30,-7,25,-9,-30,-15,-21,22,29,24,24,-21,-12,20,21,-28,24,-14,-19,0,10,25,15,4,28,-23,-16,4,-27,7,11,-4,18,-15,-19,17,-7};
        int k = 38;
        int v = largestSumAfterKNegations(nums, k);
        System.out.println(v);
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] table = new int[201];
        for (int i : nums) {
            table[i + 100]++;
        }

        int res = 0;
        int index = 0;

        int min = Integer.MAX_VALUE;
        // 处理负数
        while (k > 0 && index < 100) {
            int count = table[index];
            if (count == 0) {
                index++;
                continue;
            }

            // 负数
            int v = index - 100;
            min = Math.min(-v, min);
            if (k >= count) {
                res += count * -v;
                k -= count;
                index++;
            } else {
                res += k * -v;
                table[index] = count - k;
                k = 0;
                break;
            }
        }

        while (index <= 200) {
            int count = table[index];
            if (count == 0) {
                index++;
                continue;
            }

            // 负数
            int v = index - 100;
            min = Math.min(Math.abs(v), min);

            res += count * v;
            index++;
        }

        if (k % 2 != 0) {
            res -= 2 * min;
        }

        return res;
    }
}
