package medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class T470_用Rand7实现Rand10 {
    boolean b = start() == 0;
    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int v = rand10();
            if (!map.containsKey(v)) {
                map.put(v, 0);
            }
            map.put(v, map.get(v) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + " | value=" + entry.getValue());
        }
    }
    public int rand10() {
        int v = rand5();
        return (b = !b) ? v : v + 5;
    }

    private int rand5() {
        int v = rand7();
        while (v > 5) {
            v = rand7();
        }
        return v;
    }

    private int start() {
        int ans = rand7();
        return ans == 7 ? start() : ans % 2;
    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
