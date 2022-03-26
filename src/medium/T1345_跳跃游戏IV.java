package medium;

import java.util.*;

public class T1345_跳跃游戏IV {
    public static void main(String[] args) {
        int[] arr = {7,7,2,1,7,7,7,3,4,1};
        System.out.println(minJumps(arr));

    }
    static int INF = 0x3f3f3f3f;
    public static int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 倒序插入 list，相当于给 deque 增加一个同层「下标越大，优先出队」的作用
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(0);
        dist[0] = 0;
        while (!d.isEmpty()) {
            int t = d.pollFirst(), step = dist[t];
            if (t == n - 1) return step;
            if (t + 1 < n && dist[t + 1] == INF) {
                d.addLast(t + 1);
                dist[t + 1] = step + 1;
            }
            if (t - 1 >= 0 && dist[t - 1] == INF) {
                d.addLast(t - 1);
                dist[t - 1] = step + 1;
            }
            List<Integer> list = map.getOrDefault(arr[t], new ArrayList<>());
            for (int ne : list) {
                if (dist[ne] == INF) {
                    d.addLast(ne);
                    dist[ne] = step + 1;
                }
            }
            map.remove(arr[t]);
        }
        return -1; // never
    }
}
