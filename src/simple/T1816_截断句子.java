package simple;

public class T1816_截断句子 {
    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k--;
            }

            if (i == s.length() - 1) {
                k = s.length();
                break;
            }

            if (k == 0) {
                k = i;
                break;
            }
        }

        return s.substring(0, k);
    }
}
