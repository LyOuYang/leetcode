package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class T391_完美矩形 {
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length << 1, index = 0;
        //扫描线数组，四元组：[横坐标，纵坐标起点，纵坐标终点，左线段还是右线段]
        int[][] lines = new int[n][4];
        for (int[] rectangle : rectangles) {
            //加入四元组，1表示左线段，-1表示右线段
            lines[index++] = new int[]{rectangle[0], rectangle[1], rectangle[3], 1};
            lines[index++] = new int[]{rectangle[2], rectangle[1], rectangle[3], -1};
        }
        //对扫描线进行排序预处理，方便后续的线段判断
        Arrays.sort(lines, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
        //分别存储相同横坐标下的 [左边线段] 和 [右边线段]，在对横坐标进行一次处理后，存放的应该是对应方向合并后的线段
        List<int[]> leftLine = new ArrayList<>(), rightLine = new ArrayList<>();
        //双指针遍历每一个集合中的横坐标，通过横坐标获取到矩形的纵线段
        for (int left = 0; left < n; ) {
            int right = left;
            leftLine.clear();
            rightLine.clear();
            //找到left横坐标相同的部分，使得区间[left, right)的横坐标都是相同的
            while (right < n && lines[left][0] == lines[right][0]) right++;
            //遍历这个区间内的线段（横坐标相同）
            for (int i = left; i < right; i++) {
                //得到当前横坐标上的线段，二元组 [纵坐标起始位置，纵坐标终止位置]
                int[] yLine = new int[]{lines[i][1], lines[i][2]};
                //引用传递，line直接指向左线段或者右线段集合
                List<int[]> line = lines[i][3] == 1 ? leftLine : rightLine;
                if (line.isEmpty()) line.add(yLine);
                else {
                    //如果能进来这个else，说明在当前横坐标上有多条“左边”或“右边”，将当前边和上一次的边取出对比，如果当前边的纵坐标起点和上一条边出现了交叉，必然不是完美矩阵
                    int[] prevYLine = line.get(line.size() - 1);
                    //线段有交叉，说明必然有交叉矩阵，不符合题意
                    if (yLine[0] < prevYLine[1]) return false;
                    else if (yLine[0] == prevYLine[1]) {
                        //如开始的x坐标是1，对应的线段是左线段[1,3]和[3,4]，当前线段和上一条线段能够刚好相接，直接修改上一条线段的纵坐标终止位置为当前线段的终止位置
                        prevYLine[1] = yLine[1];
                    } else {
                        Executors.newCachedThreadPool();
                        line.add(yLine);
                    }
                }
            }
            if (left > 0 && right < n) {
                //若不是完美矩形的边缘竖边，检查放入的左线段和右线段，因为在上面的循环操作中，合法线段都最后合并成一条，所以还需要比较左线段和右线段对应的起始和终止点
                if (leftLine.size() != rightLine.size()) return false;
                for (int i = 0; i < leftLine.size(); i++) {
                    if (leftLine.get(i)[0] == rightLine.get(i)[0] && leftLine.get(i)[1] == rightLine.get(i)[1])
                        continue;
                    return false;
                }
            } else {
                //左边缘竖边在经过合并后存放大小为1的线段数组，如x=1时，存放的是[1,4]，此时如果存在右边缘线段，必然不是完美矩形，反之亦然
                if (leftLine.size() + rightLine.size() != 1) return false;
            }
            //移动left指针，继续寻找下一个x坐标对应的所有线段数组
            left = right;
        }
        return true;
    }
}
