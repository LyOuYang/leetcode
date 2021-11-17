package simple;

import org.junit.Test;

public class T598_范围求和2 {
    @Test
    public void test() {
        int m = 3;
        int n = 3;
        int[][] ops = {{2,2}, {3,3}};
        maxCount( m, n, ops);
    }
    public int maxCount(int m, int n, int[][] ops) {
        int minW = m;
        int minH = n;
        for (int[] o : ops) {
            minW = Math.min(minW, o[0]);
            minH = Math.min(minH, o[1]);
        }
        return minH * minW;
    }
}
