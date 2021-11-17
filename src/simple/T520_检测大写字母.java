package simple;

public class T520_检测大写字母 {
    /**
     * 全部字母都是大写，比如 "USA" 。
     * 单词中所有字母都不是大写，比如 "leetcode" 。
     * 如果单词不只含有一个字母，只有首字母大写，比如"Google"
     */
    public boolean detectCapitalUse(String word) {
        char[] wc = word.toCharArray();
        int n = wc.length;


        for (int i = n - 1; i >= 2; i--) {
            if (wc[i] >= 'a' != wc[i - 1] >= 'a') {
                return false;
            }
        }

        return n <= 1 || wc[0] < 'a' || wc[n - 1] > 'Z';
    }
}


