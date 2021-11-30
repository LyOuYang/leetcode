package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * "cbaebabacd"
 * "abc"
 */
public class T438_找到字符串中所有字母异位词 {
    @Test
    public void test() {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p).toString());
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] table = new int[26];
        int count = 0;
        for (char c : p.toCharArray()) {
            table[c - 'a']++;
            count++;
        }

        List<Integer> res = new ArrayList<>();
        int slow = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table[c - 'a'] > 0) {
                table[c - 'a']--;
                if (i - slow + 1 == count) res.add(slow);
            } else {
                // 让最新一个上车则结束
                // 最新一个上不了车，那么车厢尾向前
                while (slow < i) {
                    char sc = s.charAt(slow);
                    if (sc == c) {
                        if (i - slow == count) res.add(slow + 1);
                        break;
                    }
                    table[sc - 'a']++;
                    slow++;
                }
                slow++;
            }
        }
        return res;
    }
}
