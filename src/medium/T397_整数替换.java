package medium;

import org.junit.Test;

public class T397_整数替换 {
    @Test
    public void test() {
        System.out.println(integerReplacement(2147483647));
//        System.out.println(Integer.toBinaryString(25));
    }
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int count = 0;
        while (n != 1) {
            System.out.println(Integer.toBinaryString(n));
            if (n == 3) {
                return count + 2;
            }
            if (n % 2 == 0) {
                n >>= 1;
            } else {
                if ((n & 3) == 3) {
                    n += 1;
                } else {
                    n -= 1;
                }
            }
            count++;
        }
        return count;
    }
}
