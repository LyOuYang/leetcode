package medium;

public class T172_阶乘后的零 {
    /**
     * [1-n] Math.min(2,5)
     * [1-n] k的分解个数
     * k的个数n/k
     * k^2的个数=n/k^2,因k^2 = k * k，故贡献n/k^2个k
     * ...
     * k^i >= n停止
     */
    public int trailingZeroes(int n) {
        int kc = 0;
        while (n != 0) {
            kc += n / 5;
            n /= 5;
        }
        return kc;
    }
}
