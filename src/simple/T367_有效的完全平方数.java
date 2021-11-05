package simple;

import org.junit.Test;

public class T367_有效的完全平方数 {
    @Test
    public void test() {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        isPerfectSquare(808201);
    }
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int l = 0;
        int r = num >> 1;
        while (l <= r) {
            int m = l + r >> 1;
            if (m > 46340) {
                r = m - 1;
                continue;
            }
            if (m * m == num) {
                return true;
            }

            if (m * m < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}
