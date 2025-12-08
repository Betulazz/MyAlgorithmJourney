package DP.OneDimension;

import java.util.ArrayList;
import java.util.Arrays;

public class MincostTickets {

    public static int[] durations = {1, 7, 30};

    public static int mincostTickets1(int[] days, int[] costs) {
        return f1(days, costs, 0);
    }

    public static int f1(int[] days, int[] costs, int i) {
        if (i == days.length) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i, k = 0; k < 3; k++) {
            while (j < days.length && days[i] + durations[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + f1(days, costs, j));
        }
        return ans;
    }

    public static int mincostTickets2(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return f2(days, costs, 0, dp);
    }

    public static int f2(int[] days, int[] costs, int i, int[] dp) {
        if (i == days.length) {
            return 0;
        }
        if (dp[i] != Integer.MAX_VALUE) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i, k = 0; k < 3; k++) {
            while (j < days.length && days[i] + durations[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + f2(days, costs, j, dp));
        }
        dp[i] = ans;
        return ans;
    }

    public static int MAXN = 366;
    public static int dp[] = new int[MAXN];

    public static int mincostTickets3(int[] days, int[] costs) {
        return f3(days,costs);
    }

    public static int f3(int[] days, int[] costs) {
        int n = days.length;
        Arrays.fill(dp, 0, n + 1, Integer.MAX_VALUE);
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=i,k=0;k<3;k++){
                while (j < days.length && days[i] + durations[k] > days[j]) {
                    j++;
                }
                dp[i]=Math.min(dp[i],costs[k]+dp[j]);
            }
        }
        return dp[0];
    }
}
