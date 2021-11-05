package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T407_接雨水2 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int i = 0;
        int j = 0;
        while (j < n) queue.add(new int[]{i, j, heightMap[i][j++]});
        j--;
        while (++i < m) queue.add(new int[]{i, j, heightMap[i][j]});
        i--;
        while (--j >= 0) queue.add(new int[]{i, j, heightMap[i][j]});
        j++;
        while (--i > 0) queue.add(new int[]{i, j, heightMap[i][j]});


        int ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int[] dir = {-1, 0, 1, 0, -1};
            for (int k = 0; k < 4; k++) {
                int x1 = cur[0] + dir[k];
                int y1 = cur[1] + dir[k+1];
                if (x1 > 0 && x1 < m -1 && y1 > 0 && y1 < n - 1 && heightMap[x1][y1] != -1) {
                    queue.add(new int[]{x1, y1, Math.max(heightMap[x1][y1], cur[2])});
                    ans += Math.max(cur[2] - heightMap[x1][y1], 0);
                    heightMap[x1][y1] = -1;
                }
            }
        }
        return ans;
    }

    public int trapRainWater2(int[][] heightMap) {
        // 解决特殊情况
        int r = heightMap.length;
        int c = heightMap[0].length;
        if(r < 3 || c < 3) return 0;
        // 构建pq， 将最外圈放入pq，同时标记visited
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || i == r - 1 || j == 0 | j == c - 1) {
                    queue.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        // 循环从pq取出元素，遍历其左上右下结点，如果找到比他小的内部节点，就灌水到等高
        // 元素出队，入队内部节点，标记visited
        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int[] dir = {-1, 0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i];
                int ny = cur[1] + dir[i + 1];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]) {
                    int temp = cur[2] - heightMap[nx][ny];
                    if(temp > 0){
                        res += temp;
                    }
                    queue.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], cur[2])});
                    visited[nx][ny] = true;
                }
            }

        }
        return res;
    }
}
