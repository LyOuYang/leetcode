package orientation;

import java.util.Arrays;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 */
public class T767_重构字符串 {
    public static void main(String[] args) {
        String S = "vvvlo";
        String res = reorganizeString(S);
        System.out.println(res);
    }

    public static String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int len = S.length();
        int[] alphabet = new int[26];
        int max = 0;
        int maxAlphbet = 0;
        for (char c : S.toCharArray()) {
            if (max < ++alphabet[c - 'a']) {
                maxAlphbet = c - 'a';
                max++;
            }
        }
        if (max - 1 > len - max) {
            return "";
        }

        int index = 0;
        char[] res = new char[len];
        while (alphabet[maxAlphbet]-- > 0) {
            res[index] = (char) (maxAlphbet + 'a');
            index += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (alphabet[i]-- > 0) {
                if (index >= len) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }
}
