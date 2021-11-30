package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T78_子集 {
    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res.toString());
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> last, int lastIndex, int[] nums) {
        List<Integer> tem = new ArrayList<>(last);
        res.add(tem);
        for (int i = lastIndex; i < nums.length; i++) {
            last.add(nums[i]);
            dfs(res, last, i + 1, nums);
            last.remove(last.size()-1);
        }
    }
}
