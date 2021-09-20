package string;

import org.junit.Test;

public class T678_有效的括号字符串 {
    private int lmax = 0;
    private int lmin = 0;
    private int r = 0;
    private int m = 0;
    @Test
    public void test() {
        System.out.println(checkValidString("(*)"));
    }
    public boolean checkValidString(String s) {
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    lmax++;
                    lmin++;
                    break;
                case ')':
                    lmax--;
                    lmin = Math.max(lmin - 1, 0);
                    if (lmax < 0) {
                        return false;
                    }
                    break;
                default:
                    lmax++;
                    lmin = Math.max(lmin - 1, 0);
            }
        }
        return lmin == 0;
    }
}
