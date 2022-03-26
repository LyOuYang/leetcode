package medium;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class T1405_最快乐字符串 {
    @Test
    public void test() {
        longestDiverseString(1, 1, 7);
    }
    public String longestDiverseString(int a, int b, int c) {
        int[] t1 = new int[]{0, a};
        int[] t2 = new int[]{1, b};
        int[] t3 = new int[]{2, c};
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        if (a > 0)
            queue.add(t1);
        if (b > 0)
            queue.add(t2);
        if (c > 0)
            queue.add(t3);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n-1) == (char) (cur[0] + 'a') && sb.charAt(n - 2) == (char) (cur[0] + 'a')) {
                if (queue.isEmpty()) break;
                int[] cc = queue.poll();
                sb.append((char)(cc[0] +'a'));
                cc[1]--;
                if (cc[1] > 0) queue.add(cc);
            } else {
                sb.append((char)(cur[0] + 'a'));
                cur[1]--;
            }

            if (cur[1] > 0) queue.add(cur);
        }

        return sb.toString();
    }
}
