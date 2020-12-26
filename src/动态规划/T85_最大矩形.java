package 动态规划;

import java.util.ArrayDeque;
import java.util.Deque;

public class T85_最大矩形 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] -= '0';
                if (matrix[i][j] != 0 && i != 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            ans = Math.max(ans, getMaxArea(matrix[i]));
        }
        return ans;
    }

    private static int getMaxArea(char[] matrix) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newMatrix = new int[matrix.length + 2];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i + 1] = matrix[i];
        }
        stack.addLast(0);
        int area = 0;
        for (int i = 1; i < newMatrix.length; i++) {
            while (newMatrix[stack.peekLast()] > newMatrix[i]) {
                int topHeight = newMatrix[stack.removeLast()];
                int width = i - 1 - stack.peekLast();
                area = Math.max(area, topHeight * width);
            }
            stack.addLast(i);
        }
        return area;
    }
}
