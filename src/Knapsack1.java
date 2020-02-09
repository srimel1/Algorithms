/* A Naive recursive implementation of 0-1 Knapsack1 problem */
class Knapsack11
{

    // A utility function that returns maximum of two integers 
    static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a Knapsack1 of capacity W 
    static int Knapsack1(int W, int wt[], int val[], int n)
    {
        // Base Case 
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack1 capacity W, then 
        // this item cannot be included in the optimal solution 
        if (wt[n-1] > W)
            return Knapsack1(W, wt, val, n-1);

            // Return the maximum of two cases: 
            // (1) nth item included 
            // (2) not included 
        else return max( val[n-1] + Knapsack1(W-wt[n-1], wt, val, n-1),
                Knapsack1(W, wt, val, n-1)
        );
    }


    // Driver program to test above function 
    public static void main(String args[])
    {
        int val[] = new int[]{2, 3, 5};
        int wt[] = new int[]{1, 3, 4};
        int W = 6;
        int n = val.length;
        System.out.println(Knapsack1(W, wt, val, n));
    }
}
/*This code is contributed by Rajat Mishra */
