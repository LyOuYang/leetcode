package medium;

import java.util.*;

class RichNet {
    int num;
    RichNet(int num) {
        this.num = num;
    }

    int mostQuite = -1;

    List<RichNet> next = new ArrayList<>();
}
public class T851_喧闹和富有 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, RichNet> map = new HashMap<>();
        for (int i = 0; i < quiet.length; i++) {
            RichNet richNet = new RichNet(i);
            map.put(i, richNet);
        }

        for (int[] rich : richer) {
            map.get(rich[0]).next.add(map.get(rich[1]));
        }

        int[][] q = new int[quiet.length][2];
        for (int i = 0; i < quiet.length; i++) {
            q[i][0] = i;
            q[i][1] = quiet[i];
        }

        Arrays.sort(q, Comparator.comparingInt(q2 -> q2[1]));

        for (int i = 0; i < quiet.length; i++) {
            int index = q[i][0];
            matchMap(map, index, index);
        }

        for (int i = 0; i < quiet.length; i++) {
            quiet[i] = map.get(i).mostQuite == -1 ? i : map.get(i).mostQuite;
        }

        return quiet;
    }

    private void matchMap(Map<Integer, RichNet> map, int num, int value) {
        if (map.get(num).mostQuite == -1) {
            map.get(num).mostQuite = value;
            for (RichNet richNet : map.get(num).next) {
                matchMap(map, richNet.num, value);
            }
        }
    }
}
