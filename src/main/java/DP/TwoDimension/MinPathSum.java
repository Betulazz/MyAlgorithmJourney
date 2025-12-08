package DP.TwoDimension;

public class MinPathSum {

    public static int minPathSum1(int[][] grid) {
        return f1(grid, grid.length - 1, grid[0].length - 1);
    }

    public static int f1(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            up = f1(grid, i - 1, j);
        }
        if (j - 1 >= 0) {
            left = f1(grid, i, j - 1);
        }
        return grid[i][j] + Math.min(up, left);
    }

    public static int minPathSum2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(grid, n - 1, m - 1, dp);
    }

    public static int f2(int[][] grid, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            up = f2(grid, i - 1, j, dp);
        }
        if (j - 1 >= 0) {
            left = f2(grid, i, j - 1, dp);
        }
        int ans = grid[i][j] + Math.min(up, left);
        dp[i][j] = ans;
        return ans;
    }

    public static int minPathSum3(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static int minPathSum4(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            dp[0]+=grid[i][0];
            for(int j=1;j<m;j++){
                dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[m-1];
    }
}
