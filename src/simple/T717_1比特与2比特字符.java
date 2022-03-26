package simple;

public class T717_1比特与2比特字符 {
    private final int mod=1000000007;
    public int numberOfGoodSubsets(int[] nums) {
        long res = 0;
        int[] prime = {2,3,5,7,11,13,17,19,23,29};
        // long 防止溢出
        long[] dp = new long[1024];
        // dp数组初始化
        dp[0] = 1;
        int[] count = new int[31];
        for(int num : nums) count[num]++;
        // 遍历nums中的每一个数，除了1
        for(int num = 2; num <= 30; ++num){
            // 当前数不存在，当前数带有平方数 跳过
            if(count[num] == 0 || num % 4 == 0||num % 9 == 0 || num % 25 == 0) continue;

            // 对10个质数做处理，如果当前数能被质数整除，则记录进maskForNum
            int maskForNum = 0;
            for(int i = 0; i < 10; ++i){
                if(num % prime[i] == 0) maskForNum |= ( 1 << i);
            }

            // 遍历每一种状态
            for(int state = 0; state < 1024; ++state){
                // maskForNum中已经存在了其中一个质数，跳过
                if((maskForNum & state) > 0) continue;
                //这里可能会溢出，所以dp数组类型为long
                // 更新当前状态的的好子集个数
                dp[maskForNum|state] = (dp[maskForNum|state] + count[num] * dp[state])%mod;
                // System.out.println( num + " --- " + state + " --- " + dp[state]);
            }
        }
        // dp[0]不算进去
        for(int i = 1; i < 1024; ++i) res = (res + dp[i]) % mod;
        // 有多少个1，最后的结果就乘以2的多少次方
        for(int i = 0; i < count[1]; ++i) res = (res * 2) % mod;
        return (int)res;
    }
}
