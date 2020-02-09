import java.util.Map;

public class topDown {
    private int topDownWithMEmo(int[] price, Map<Integer, Integer> memo, int n) {

        if(n==0) return 0;
        if(memo.containsKey(n)) return memo.get(n);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, price[i] + recursiveTopDown(price, n - 1 - i));

        }
        memo.put(n, ans);
        return ans;
    }

    /***
     * Performance: O(n^2) huge improvement from bottom up
     * @param price
     * @param n is the length of the rod
     * @return answer
     */
    private int recursiveTopDown(int[] price, int n) {
        if( n== 0) return 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, price[i] + recursiveTopDown(price, n - 1 - i));
        }
        return ans;
    }
}
