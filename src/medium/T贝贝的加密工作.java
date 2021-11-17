package medium;

import org.junit.Test;

public class T贝贝的加密工作 {
    @Test
    public void test() {
        System.out.println(encode("cmmmcefffg"));
    }
    public String encode(String code) {
        //bcaaaaaaef
        // 当没有相连小写字符的时候
        boolean hasJoinLowercase = true;
        while (hasJoinLowercase) {
            int n = code.length();
            hasJoinLowercase = false;
            for (int i = 0; i < n - 1; i++) {
                char c = code.charAt(i);
                if (c <= 'Z') {
                    continue;
                }
                // 相同小写字符个数
                int count = 0;
                int sampleIndex = i;
                while (sampleIndex < n && c == code.charAt(sampleIndex)) {
                    sampleIndex++;
                    count++;
                }

                if (count > 1) {
                    // 开始交换
                    hasJoinLowercase = true;

                    // 通过截取实现交换
                    code = (sampleIndex < n ? code.substring(sampleIndex) : "") + (char)(c - 32) + count +  code.substring(0, i);
                    break;
                }
            }
        }
        return code;
    }
}
