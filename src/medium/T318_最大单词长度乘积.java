package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T318_最大单词长度乘积 {
    public int maxProduct(String[] words) {
        // 设置字符数集合
        Map<Character, Set<String>> map = new HashMap<Character, Set<String>>(26);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) {
                    Set<String> set = new HashSet<>();
                    set.add(word);
                    map.put(c, set);
                }
                map.get(c).add(word);
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String a = words[i];
                String b = words[j];
                boolean match = false;
                for (Map.Entry<Character,Set<String>> entry : map.entrySet()) {
                    Set<String> set = entry.getValue();
                    if (set.contains(a) && set.contains(b)) {
                        match = true;
                        break;
                    }
                }
                if (!match) {
                    max = Math.max(max, a.length() * b.length());
                }
            }
        }
        return max;
    }
}
