package orientation;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * <p>
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 10^9 + 7 取余 后的结果。
 */
public class T576_出界的路径数 {
    int[][] dbt;
    int m;
    int n;

    @Test
    public void findPath(){
//        int r = findPaths(2, 2, 3, 0, 0);
//        System.out.println(r);
        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        IntStream stream = Arrays.stream(arr).flatMapToInt(x -> Arrays.stream(x));
        int[] a = stream.toArray();
        System.out.println(Arrays.toString(a));
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        dbt = new int[m*n][maxMove+1];
        for (int i = 0; i < m*n; i++) {
            Arrays.fill(dbt[i], -1);
        }

        return findPathCount(maxMove, startRow, startColumn);
    }

    public int findPathCount(int maxMove, int startRow, int startColumn) {
        if (startRow == -1 || startColumn == -1 || startRow == m || startColumn == n) {
            return 1;
        }

        if (maxMove == 0) {
            return 0;
        }

        int curIndex = startRow * n + startColumn;
        if (dbt[curIndex][maxMove] != -1) {
            return dbt[curIndex][maxMove];
        }

        long count = findPathCount(maxMove - 1, startRow -1, startColumn);
        count += findPathCount(maxMove - 1, startRow + 1, startColumn);
        count += findPathCount(maxMove - 1, startRow, startColumn - 1);
        count += findPathCount(maxMove - 1, startRow, startColumn + 1);
        dbt[curIndex][maxMove] = (int)(count % 1000000007);
        return dbt[curIndex][maxMove];
    }
}