package medium;

public class T371_两整数之和 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a & b << 1);
    }
    public int getSum(int a, int b) {
        while (b != 0) {
            a = a ^ b;
            b = a & b << 1;
        }
        return a;
    }
}
