package hard;

import org.junit.Test;

/**
 * 假设有 n台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 *
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 *
 * 给定一个整数数组machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 */
public class T517_超级洗衣机 {
    @Test
    public void test() {
        int[] machines = {1, 0, 5};
        int r = findMinMoves(machines);
        System.out.println(r);
    }

    public int findMinMoves(int[] machines) {
        // 1 0 5
        // 1 1 4
        // 1 2 3
        // 2 2 2

        // 6 4 3 1 0 10
        // 5 4 4 1 1 9
        // 4 4 4 2 2 8
        // 4 4 4 2 3 7
        // 4 4 4 2 4 6
        // 4 4 4 3 4 5
        // 4 4 4 4 4 4
        int l = 0;
        int r = machines.length - 1;
        int total = 0;
        for (int m : machines) {
            total += m;
        }
        if (total % machines.length != 0) {
            return -1;
        }
        int env = total / machines.length;
        int result = 0;
        boolean swap = true;
        while (swap) {
            swap = false;
            while (l < r && l + 1 < machines.length) {
                if (machines[l] > machines[l + 1] && machines[l] > env) {
                    machines[l]--;
                    machines[l+1]++;
                    swap = true;
                }
                l++;
            }

            while (l < r && r - 1 >= 0) {
                if (machines[r] > machines[r-1] && machines[r] > env) {
                    machines[r]--;
                    machines[r-1]++;
                    swap = true;
                }
                r--;
            }

            if (swap) {
                result++;
                l = 0;
                r = machines.length - 1;
            }
        }

        return result;


        // 4 4 4 4 4 4
        // 5 4 4 1 0 10
        // 1 0 0 -3 4 6
        // 0 0 0 -2 4 6

        // 4 4 4 2 0 9
        // 4 4 4 3 1 8
        // 4 4 4 3 2 7
        // 4 4 4 3 3 6
        // 4 4 4 3 4 5
        // 4 4 4 4 4 4


    }
}
