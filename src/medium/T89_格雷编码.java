package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T89_格雷编码 {
    @Test
    public void test() {
        List<Integer> integers = grayCode(3);
        System.out.println(integers.toString());
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        int m = 2;
        while (m < Math.pow(2,n)) {
            for (int i = m - 1; i >= 0; i--) {
                res.set(i, res.get(i) << 1);
                res.add(res.get(i) + 1);
            }
            m = res.size();
        }

        return res;
    }
}
