package hard;

public class T458_可怜的小猪 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        double n = (Math.log(buckets) / Math.log(2)) / (Math.log(minutesToTest / minutesToDie + 1) / Math.log(2));
        if ((int)n == n) {
            return (int)n;
        }
        return (int)(n + 1);
    }
}
