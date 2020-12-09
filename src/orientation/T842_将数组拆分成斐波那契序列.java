package orientation;

import java.util.ArrayList;
import java.util.List;

public class T842_将数组拆分成斐波那契序列 {
    public static void main(String[] args) {
        String s = "0123";
        List<Integer> res = splitIntoFibonacci(s);
        System.out.println(res.toString());
    }
    public static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        return fillList(res, S) ? res : new ArrayList<>();
    }

    private static boolean fillList(List<Integer> res, String s) {
        if (s == null || s.length() == 0) {
            return res.size() > 2;
        }

        char firstChar = s.charAt(0);
        if (firstChar == '0' && res.size() >= 2) {
            if (res.get(res.size() - 1) != 0 || res.get(res.size() - 2) != 0) {
                return false;
            }
        }

        if (firstChar == '0') {
            res.add(0);
            if (fillList(res, s.substring(1))) {
                return true;
            }
            res.remove(res.size() - 1);
            return false;
        }
        String ms = String.valueOf(Integer.MAX_VALUE);
        boolean f = false;
        for (int i = 1; i < s.length() + 1; i++) {
            String ns = s.substring(0,i);
            if (ms.length() < ns.length() || (ms.length() == ns.length() && ms.compareTo(ns) < 0)) {
                return false;
            }

            int v = Integer.parseInt(ns);
            if (res.size() < 2 || (v - res.get(res.size() - 1)) == res.get(res.size() - 2)) {
                res.add(v);
                if (fillList(res, s.substring(i))) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
