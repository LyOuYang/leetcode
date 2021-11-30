package hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class T786_第K个最小的素数分数 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Queue<int[]> queue = new PriorityQueue<int[]>(((x, y) -> arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]]));
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            queue.offer(new int[]{0, i});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x + 1 < y) {
                queue.offer(new int[]{x + 1, y});
            }
        }

        return new int[]{arr[queue.peek()[0]], arr[queue.peek()[1]]};
    }

    double eps = 1e-8;
    int[] arr;
    int n, a, b;
    public int[] kthSmallestPrimeFraction2(int[] _arr, int k) {
        arr = _arr;
        n = arr.length;
        double l = 0, r = 1;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (check(mid) >= k) r = mid;
            else l = mid;
        }
        return new int[]{a, b};
    }
    int check(double x){
        int ans = 0;
        for (int i = 0, j = 1; j < n; j++) {
            while (arr[i + 1] * 1.0 / arr[j] <= x) i++;
            if (arr[i] * 1.0 / arr[j] <= x) ans += i + 1;
            if (Math.abs(arr[i] * 1.0 / arr[j] - x) < eps) {
                a = arr[i]; b = arr[j];
            }
        }
        return ans;
    }
}
