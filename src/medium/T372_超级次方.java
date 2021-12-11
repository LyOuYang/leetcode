package medium;

public class T372_超级次方 {
    int N = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    private int dfs(int a, int[] b, int index) {
        if (index == -1) {
            return 1;
        }
        return qPow(dfs(a, b, index - 1), 10) * qPow(a, b[index]) % N;
    }

    private int qPow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        a = a % N;
        int t = qPow(a, b >> 1);
        t = t % N;
        return (b % 2 == 0 ? t  * t % N : t * t % N * a) % N;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % N);
            }
            x = (int) ((long) x * x % N);
            n /= 2;
        }
        return res;
    }
}
