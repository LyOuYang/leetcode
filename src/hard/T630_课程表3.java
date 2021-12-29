package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T630_课程表3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int costTime = 0;
        for(int[] courseTime : courses) {
            if (courseTime[1] < courseTime[0]) continue;
            if (costTime + courseTime[0] <= courseTime[1]) {
                costTime += courseTime[0];
                maxHeap.add(courseTime);
            } else {
                if (!maxHeap.isEmpty() && maxHeap.peek()[0] > courseTime[0]) {
                    costTime -=maxHeap.poll()[0];
                    costTime += courseTime[0];
                    maxHeap.add(courseTime);
                    costTime += courseTime[0];
                }
            }
        }
        return maxHeap.size();
    }
}
