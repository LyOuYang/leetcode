package orientation;

import java.util.HashMap;

public class T454_四数相加_II {
    int sum = 0;
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = A[i] + B[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = -A[i] - B[j];
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }
        return res;
    }
}
