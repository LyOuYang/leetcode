package medium;

import java.util.Arrays;

public class T911_在线选举 {
    int[] maxPersons;
    int[] times;
    int n;
    public T911_在线选举(int[] persons, int[] times) {
        n = persons.length;
        int[] table = new int[n];
        int maxCount = 0;
        int lastMaxPerson = 0;
        for (int i = 0; i < n; i++) {
            table[persons[i]]++;
            if (table[persons[i]] > maxCount) {
                maxCount = table[persons[i]];
                lastMaxPerson = persons[i];
            }
            persons[i] = lastMaxPerson;
        }
        System.out.println(Arrays.toString(persons));
        maxPersons = persons;
        this.times = times;
    }

    public int q(int t) {
        int l = 0;
        int r = n - 1;
        if (t <= times[0]) return maxPersons[0];
        if (t >= times[n - 1]) return maxPersons[n - 1];
        while (l < r) {
            int m = l + r >> 1;
            if (times[m] < t) l = m;
            else r = m + 1;
        }
        System.out.println("l = " + l);
        return maxPersons[l];
    }
}
