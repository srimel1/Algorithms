public class dynamic {
    /***
     *
     * @param price
     * @param n length of rod
     * @n-1: how many times we can cut the rod
     * @return ans is the optimized price
     * performance 2^n
     */
    private int recursiveTopDown(int[] price, int n) {
        if(n== 0) return 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, price[i] + recursiveTopDown(price, n - 1 - i));
        }
        return ans;
     }

    private int bottomUpDP(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], price[j] + dp[i - 1 - j]);
            }
        }
        int ans = 0;
        return ans;
    }
}
