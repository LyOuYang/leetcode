package simple;

public class T268_丢失的数字 {
    public int missingNumber(int[] nums) {
        int total = (1 + nums.length) * nums.length >> 1;
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
        }
        return total;
    }
}
