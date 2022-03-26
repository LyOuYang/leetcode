package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T969_煎饼排序 {
    @Test
    public void test() {
        int[] arr = {3,2,4,1};

        List<Integer> integers = pancakeSort(arr);
        System.out.println(integers);
    }
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        int last = n - 1;
        List<Integer> res = new ArrayList<>();
        while (last != 0) {
            while (arr[last] == last + 1) {
                last--;
                if (last == -1) return res;
            }
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == last + 1) {
                    k = i;
                    break;
                }
            }

            if (k != 0) {
                turnArr(arr, k);
                res.add(k + 1);
            }

            turnArr(arr, last);
            res.add(last + 1);
        }
        return res;
    }

    private void turnArr(int[] arr, int k) {
        for (int i = 0; i <= k / 2; i++) {
            if (i == k - i) continue;
            arr[i] += arr[k - i];
            arr[k - i] = arr[i] - arr[k - i];
            arr[i] = arr[i] - arr[k - i];
        }
    }
}
