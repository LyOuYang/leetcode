package medium;

public class T2028_找出缺失的观测数据 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int y = 0;
        for (int r : rolls) {
            y += mean - r;
        }
        y += mean * n;   //12
        int cs = y / n;
        if (cs < 0 || cs > 6) return new int[0];
        int ys = y % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cc = Math.min(6 - cs, ys);
            ys -= cc;
            res[i] = cs + cc;
        }
        return ys == 0 ? res : new int[0];
    }
}
