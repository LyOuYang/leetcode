package simple;

public class T661_图片平滑器 {
    public int[][] imageSmoother(int[][] img) {
        int r = img.length;
        int c = img[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                fill(img,res,i,j);
            }
        }
        return res;
    }

    private void fill(int[][] img, int[][] res, int i, int j) {
        int c = 0;
        int[][] f = {{0,0},{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        for (int k = 0; k < f.length; k++) {
            int x = i + f[k][0];
            int y = j + f[k][1];
            if (x >= 0 && y >=0 && x < res.length && y < res[0].length) {
                c++;
                res[i][j] += img[x][y];
            }
        }
        res[i][j] /= c;
    }
}
