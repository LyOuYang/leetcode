package orientation;

import java.util.Arrays;

/**
 * 给定长度分别为m和n的两个数组，其元素由0-9构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n)个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为k的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 */
public class T321_拼接最大数 {
    public static void main(String[] args) {
        int[] nums1 = {2,5,6,4,4,0};
        int[] nums2 = {7,3,8,0,6,5,7,6,2};
        int k = 15;
        System.out.println(Arrays.toString(maxNumber(nums1,nums2,k)));
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // nums1 最小必须数字个数
        int nums1MinNeed = Math.max(0, k - len2);

        // nums1 最大必须数字个数
        int nums1MaxNeed = Math.min(k, len1);
        int[] resMax = new int[k];
        for (int num1Need = nums1MinNeed; num1Need <= nums1MaxNeed; num1Need++) {
            int[] num1ArrayMax = getMaxArray(nums1, num1Need);
            int[] num2ArrayMax = getMaxArray(nums2, k - num1Need);
            int[] res = getMaxArray(num1ArrayMax,num2ArrayMax);
            if (!compare(resMax,0,res,0)) {
                System.arraycopy(res, 0, resMax, 0, k);
            }
        }
        return resMax;
    }

    public static boolean compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference > 0;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2) > 0;
    }

    /**
     * 在nums顺序取值的情况下，可得到的长度为k的最大值数组
     *
     * @param nums 取值数组
     * @param k 需要取值的元素
     * @return 最大取值数组
     */
    public static int[] getMaxArray(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    private static int[] getMaxArray(int[] a1, int[] a2) {
        int i1 = 0;
        int i2 = 0;
        int r = 0;
        int l1 = a1.length;
        int l2 = a2.length;
        int tl = l1 + l2;
        int[] res = new int[tl];
        while (i1 < l1 && i2 < l2) {
            if (a1[i1] > a2[i2]) {
                res[r++] = a1[i1++];
            } else if (a1[i1] < a2[i2]){
                res[r++] = a2[i2++];
            } else {
                if (compare(a1,i1,a2,i2)) {
                    res[r++] = a1[i1++];
                } else {
                    res[r++] = a2[i2++];
                }
            }
        }
        while (i1 < l1) {
            res[r++] = a1[i1++];
        }
        while (i2 < l2) {
            res[r++] = a2[i2++];
        }
        return res;
    }
}
