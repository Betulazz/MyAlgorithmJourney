package DP.OneDimension;

import java.util.Arrays;
import java.util.Locale;

public class NumDecodings {

    public static int numDecodings1(String s) {
        return f1(s.toCharArray(), 0);
    }

    public static int f1(char[] s, int i) {
        if (i == s.length) {
            return 1;
        }
        int ans = 0;
        if (s[i] == '0') {
            return 0;
        } else {
            //i位置的一个字母
            ans = f1(s, i + 1);
            //i位置和i+1位置的两个字母组合
            if (i + 1 < s.length && (s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                ans += f1(s, i + 2);
            }
        }
        return ans;
    }

    public static int numDecodings2(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return f2(s.toCharArray(), 0, dp);
    }

    public static int f2(char[] s, int i, int[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = 0;
        if (s[i] == '0') {
            return 0;
        } else {
            //i位置的一个字母 这种情况是一定能成立的！ 因此下面的ans是+=
            ans = f2(s, i + 1, dp);
            //i位置和i+1位置的两个字母组合
            if (i + 1 < s.length && (s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                ans += f2(s, i + 2, dp);
            }
            dp[i] = ans;
        }
        return ans;
    }

    // 严格位置依赖的动态规划
    public static int numDecodings3(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length && (s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static int numDecodings4(String s) {
        // dp[n]
        // dp[i+1]
        int next = 1;
        // dp[n+1]不存在
        // dp[i+2]
        int nextNext = 0;
        int cur = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)=='0'){
                cur=0;
            }else{
                cur=next;
                if (i + 1 < s.length() && (s.charAt(i) - '0') * 10 + s.charAt(i+1) - '0' <= 26) {
                    cur+=nextNext;
                }
            }
            //      cur next nextNext
            //      next nextNext
            nextNext=next;
            next=cur;
        }
        return cur;
    }
}
