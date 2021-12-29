package medium;

import org.junit.Test;

import java.util.Arrays;

public class T825_适龄的朋友 {
    @Test
    public void test() {
        int[] ages = {118,14,7,63,103};
        int r = numFriendRequests(ages);
        System.out.println(r);
    }
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int[] ageCount = new int[121];
        int age = ages[0];
        ageCount[age] = 1;
        for (int i = 1; i < ages.length; i++) {
            int lastAge = ageCount[ages[i - 1]];
            while (age + 1 < ages[i]) ageCount[++age] = lastAge;
            ageCount[ages[i]] = lastAge + 1;
        }

        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            int left = (int)(0.5 * ages[i] + 7);
            System.out.println(ages[i] + "-" + ageCount[ages[i]] + "-" + ageCount[left]);
            if (ages[i] >= left)
                res += ageCount[ages[i]] - ageCount[left] - 1;
        }

        return res;
    }
}
