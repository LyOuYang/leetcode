package simple;

import org.junit.Test;

public class t997_找到小镇的法官 {
    @Test
    public void test() {
        int n = 2;
        int[][] trust = {{1,2}};
        findJudge(n, trust);
    }
    public int findJudge(int n, int[][] trust) {
        // 出入
        int[][] trustNet = new int[n + 1][2];
        for(int[] t : trust) {
            trustNet[t[0]][0]++;
            trustNet[t[1]][1]++;
        }

        for (int i = 1; i < n; i++) {
            int[] net = trustNet[i];
            if (net[0] == 0 && net[1] == n - 1) return i;
        }

        return -1;
    }
}
