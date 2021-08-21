package string;

import org.junit.Test;

/**
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 *
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 */
public class T443_压缩字符串 {
    @Test
    public void t443_Test() {
        char[] chars = {'a','a','b','b','c','c','c'};
        int compress = compress(chars);
        System.out.println(compress);
    }
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int cur = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i-1] == chars[i]) {
                cur++;
            } else {
                if (cur != 1) {
                    sb.append(cur);
                }
                cur = 1;
                sb.append(chars[i]);
            }
        }

        // 处理最后一个字符
        if (cur != 1) {
            sb.append(cur);
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
