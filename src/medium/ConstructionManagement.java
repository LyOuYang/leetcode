package medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ConstructionManagement {
    @Test
    public void  test() {
        List<List<Integer>> cost = Arrays.asList(Arrays.asList(1,2,3),
                Arrays.asList(1,1,3),
                Arrays.asList(4,5,1));
        System.out.println(minCost(cost));
    };;
    int[][] table;
    public int minCost(List<List<Integer>> cost) {
        table = new int[cost.size()][cost.get(0).size()];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cost.size(); i++) {
            min = Math.min(minCost(cost, 0, i), min);
        }
        return min;
    }

    // 要x, y 的情况下， 最小情况。
    public int minCost(List<List<Integer>> cost, int x, int y) {
        if (x == cost.size()) {
            return 0;
        }

        if (table[x][y] != 0) {
            return table[x][y];
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < cost.get(0).size(); j++) {
            if (y == j) continue;
            min = Math.min(minCost(cost, x + 1, j), min);
        }

        table[x][y] =  min + cost.get(x).get(y);
        return table[x][y];
    }

    public static int segment(int x, List<Integer> space) {
        // Write your code here
        x = Math.min(x, space.size());
        int min = space.get(0);
        int minIndex = 0;
        int max;
        for (int i = 0; i < x; i++) {
            if (space.get(i) <= min) {
                min = space.get(i);
                minIndex = i;
            }
        }
        max = min;

        for (int i = x; i < space.size(); i++) {
            int rm = i - x;
            if (rm == minIndex) {
                min = space.get(rm + 1);
                minIndex = rm + 1;
                for (int j = rm + 1; j <= i; j++) {
                    if (space.get(j) < min) {
                        min = space.get(j);
                        minIndex = j;
                    }
                }
            } else {
                if (space.get(i) < min) {
                    min = space.get(i);
                    minIndex = i;
                }
            }
            max = Math.max(min, max);
        }
        return max;
    }
}
