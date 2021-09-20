package hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T502_IPO {
    @Test
    public void test() {
        int[] profits = {1,2,3};
        int[] capital = {0,1,2};
        int r = findMaximizedCapital(10, 0, profits, capital);
        System.out.println(r);
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }

    private int findMaximizedCapital(int k, int w, int[][] arr) {
        while (k > 0) {
            boolean b = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] <= w) {
                    w += arr[i][1];
                    k--;
                    b = false;
                    break;
                }
            }
            if (b) return w;
        }
        return w;
    }

    private int findMaximizedCapital(int k, int w, int[] profits, int[] capital, boolean[] mark) {
        while (k > 0) {
            boolean b = true;
            for (int i = 0; i < capital.length; i++) {
                if (mark[i] && capital[i] <= w) {
                    mark[i] = false;
                    w += profits[i];
                    k--;
                    b = false;
                    break;
                }
            }
            if (b) return w;
        }
        return w;
    }

    private void sort(int[] profits, int[] capital) {
        boolean b = true;
        for (int i = 0; i < profits.length; i++) {
            for (int j = profits.length - 1; j > i; j--) {
                if (profits[j - 1] <= profits[j]) {
                    swap(j, j - 1, profits, capital);
                    b = false;
                }
            }
            if (b) return;
        }
    }

    private void sort2(int[] profits, int[] capital, int l, int r) {
        if (l >= r) {
            return;
        }
        int tl = l;
        int tr = r;
        while (tl < tr) {
            while (tl <= tr && profits[tl] >= profits[tr--]);
            tr++;
            swap(tl, tr, profits, capital);
            tl++;
            while (tl <= tr && profits[tl++] >= profits[tr]);
            tl--;
            swap(tl, tr, profits, capital);
            tr--;
        }
        sort2(profits, capital,l, tl - 1);
        sort2(profits, capital,tl + 1, r);
    }

    private void swap(int l, int r, int[] profits, int[] capital) {
        if (l == r) return;
        profits[l] += profits[r];
        profits[r] = profits[l] - profits[r];
        profits[l] = profits[l] - profits[r];

        capital[l] += capital[r];
        capital[r] = capital[l] - capital[r];
        capital[l] = capital[l] - capital[r];
    }
}
