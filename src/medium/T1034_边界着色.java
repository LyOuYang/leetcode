package medium;

import org.junit.Test;

import java.util.Arrays;

public class T1034_边界着色 {
    @Test
    public void test() {
        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
        int row = 1;
        int col = 1;
        int color = 2;
        grid = colorBorder(grid, row, col, color);
        System.out.println();
        Arrays.stream(grid).forEach(g -> System.out.println(Arrays.toString(g)));
    }

    int h;
    int l;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        h = grid.length;
        l = grid[0].length;
        dfs(grid, row, col, grid[row][col], color);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[i][j] == - 1) {
                    grid[i][j] = grid[row][col];
                }

                if (grid[i][j] == - 2) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    public void dfs(int[][] grid, int row, int col,int initColor, int brushColor) {
        int[] direction = {1, 0, -1, 0, 1};
        int isNeedBrushColor = 4;

        // 四个方向尝试
        for (int i = 0; i < 4; i++) {
            int x = row + direction[i];
            int y = col + direction[i + 1];
            if (x < h && y < l && x >= 0 && y >= 0) {
                if (grid[x][y] == initColor) {
                    grid[row][col] = -1;
                    dfs(grid, x, y ,initColor, brushColor);
                    isNeedBrushColor--;
                } else if (grid[x][y] < 0) {
                    isNeedBrushColor--;
                }
            }
        }

        // 这个是否需要染色
        if (isNeedBrushColor == 0) {
            grid[row][col] = -1;
        } else {
            grid[row][col] = -2;
        }
    }
}
