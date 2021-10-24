package medium;

import org.junit.Test;

import java.util.*;

/**
 * [4,3,2,9,8,8]
 * [[1,5,5,1,4,0,18],[3,3,6,6,4,2,32]]
 * [6,5,5,6,4,1]
 */
public class T638_大礼包 {
    @Test
    public void test() {
        List<Integer> price = new ArrayList<>(Arrays.asList(5));
        List<List<Integer>> special = new ArrayList<List<Integer>>();
        special.add(Arrays.asList(1,3));
        special.add(Arrays.asList(4,7));
        special.add(Arrays.asList(3,3));
        List<Integer> needs = new ArrayList<>(Arrays.asList(4));
        System.out.println(shoppingOffers(price, special, needs));

    }

    Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        // 过滤不需要计算的大礼包，价格小于单买价格
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        for (List<Integer> sp : special) {
            int totalPrice = 0;
            int totalCount = 0;
            boolean isAdd = true;
            for (int i = 0; i < n; i++) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
                if (sp.get(i) > needs.get(i)) {
                    isAdd = false;
                }
            }
            if (isAdd && totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }

        return dfs(price, needs, filterSpecial, n);
    }

    private int dfs(List<Integer> price, List<Integer> needs, List<List<Integer>> filterSpecial, int n) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int minPrice = 0;
        for (int i = 0; i < n; i++) {
            minPrice += price.get(i) * needs.get(i);
        }

        if (minPrice == 0) {
            return 0;
        }

        for (List<Integer> sp : filterSpecial) {
            List<Integer> nxtNeeds = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (sp.get(i) > needs.get(i)) {
                    break;
                }

                nxtNeeds.add(needs.get(i) - sp.get(i));
            }

            if (nxtNeeds.size() == n) {
                minPrice = Math.min(minPrice, dfs(price, nxtNeeds, filterSpecial, n) + sp.get(n));
                memo.put(needs, minPrice);
            }
        }

        return minPrice;
    }
}
