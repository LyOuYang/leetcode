package simple;

import org.junit.Test;

public class T_蛇形 {
    @Test
    public void test() {
        printSnack(100);
    }
    public void printSnack(int n) {
        int[][] table = new int[n][n];
        int x = 0;
        int y = 0;
        int count = 1;
        table[0][0] = 1;
        while (x != n-1 || y != n-1) {
            while (x - 1 >= 0 && y + 1 < n) {
                x--;
                y++;
                table[x][y] = ++count;
            }

            if (y + 1 < n) {
                y++;
            } else {
                x++;
            }
            table[x][y] = ++count;
            while (x + 1 < n && y - 1 >= 0) {
                x++;
                y--;
                table[x][y] = ++count;
            }
            if (x + 1 < n) {
                x++;
            } else {
                y++;
            }

            table[x][y] = ++count;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-4s", table[i][j]);
            }
            System.out.println();
        }
    }
}
