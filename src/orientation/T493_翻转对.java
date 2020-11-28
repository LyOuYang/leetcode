package orientation;

/**
 * 给定一个数组nums，如果i < j且nums[i] > 2*nums[j]我们就将(i, j)称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 */
public class T493_翻转对 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        int res = reversePairs(nums);
        System.out.println(res); // 2
    }
    public static int reversePairs(int[] nums) {
        // 通过排序来降低时间复杂度
        int res = getReversePairs(nums, 0, nums.length - 1);
        return res;
    }

    private static int getReversePairs(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + right >> 1;
        int lc = getReversePairs(nums,left,mid);
        int rc = getReversePairs(nums,mid + 1, right);
        int res = lc + rc;
        int ls = left;
        int ms = mid + 1;
        while (ls <= mid) {
            while (ms <= right && nums[ls] > ((long)2) * nums[ms]) {
                ms++;
            }
            ls++;
            res += ms - mid - 1;
        }

        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int p = 0;
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                temp[p++] = nums[l++];
            } else {
                temp[p++] = nums[r++];
            }
        }
        while (l <= mid) temp[p++] = nums[l++];
        while (r <= right) temp[p++] = nums[r++];
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
        return res;
    }
}
