package simple;

import org.junit.Test;

public class T2000_反转单词前缀 {
    @Test
    public void test() {
        String s = reversePrefix("abcdefd", 'd');
        System.out.println(s);
    }

    public String reversePrefix(String word, char ch) {
        int i = word.indexOf(ch);
        if (i == -1) return word;
        StringBuffer rs = new StringBuffer(word.substring(0, i + 1));
        return rs.reverse() + word.substring(i + 1);
    }
}
