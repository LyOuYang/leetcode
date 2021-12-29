package medium;

public class T807_保持城市天际线 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int [] rowMax = new int[n];
        int [] colMax = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(grid[i][j], rowMax[i]);
                colMax[j] = Math.max(grid[i][j], colMax[j]);
            }
        }
        int increaseHeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                increaseHeight += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return increaseHeight;
    }
}
