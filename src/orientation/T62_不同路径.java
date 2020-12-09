package orientation;

public class T62_不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }
    public static int uniquePaths(int m, int n) {
        if (m > n) {
            m += n;
            n = m - n;
            m -=  n;
        }
        int[][] tb = new int[m+1][n+1];
        return uniquePaths(m, n, tb);
    }

    public static int uniquePaths(int m, int n, int[][] tb) {
        if (m > n) {
            m += n;
            n = m - n;
            m -=  n;
        }

        if (tb[m][n] != 0) {
            return tb[m][n];
        }

        if (m == 1) {
            return 1;
        }
        tb[m][n] = uniquePaths(m - 1, n, tb) + uniquePaths(m, n - 1, tb);
        return tb[m][n];
    }
}
