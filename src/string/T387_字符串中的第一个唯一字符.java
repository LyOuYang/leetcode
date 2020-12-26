package string;

public class T387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        int[] charTable = new int[s.length()];
        for (char c : s.toCharArray()) {
            charTable[c - '0']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charTable[c - '0'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
