public class SubsetSum {
    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int targetSum = 9;

        boolean[][] dp = subsetSumDP(set, targetSum);

        if (dp[set.length][targetSum]) {
            System.out.println("Subset with the given sum exists.");
            printSubset(set, dp, targetSum);
        } else {
            System.out.println("No subset with the given sum exists.");
        }
    }

    static boolean[][] subsetSumDP(int[] set, int targetSum) {
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (j < set[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }

        return dp;
    }

    static void printSubset(int[] set, boolean[][] dp, int targetSum) {
        int n = set.length;
        int i = n;
        int j = targetSum;

        while (i > 0 && j > 0) {
            if (dp[i][j] && !dp[i - 1][j]) {
                System.out.print(set[i - 1] + " ");
                j -= set[i - 1];
            }
            i--;
        }
        System.out.println();
    }
}
