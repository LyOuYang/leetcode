package hard;

import org.junit.Test;

public class T440_字典序的第K小数字2 {
    @Test
    public void test() {
        findKthNumber(13, 2);
    }
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int step = getStep(curr, n);
            if (step <= k) {
                k -= step;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int getStep(int root, int n) {
        int step = 0;
        int f = root;
        int l = root;
        while (f <= n) {
            if (l > n)
                step += n - f + 1;
            else
                step += l - f + 1;
            f = f * 10;
            l = l * 10 + 9;
        }
        return step;
    }
}
