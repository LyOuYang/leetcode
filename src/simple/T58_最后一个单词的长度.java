package simple;

public class T58_最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int l = s.length();
        int n = 0;
        for (int i = l - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if (n == 0 && c == ' ') {
                continue;
            }
            if (s.charAt(i) == ' ') {
                return n;
            }
            n++;
        }
        return n;
    }
}
