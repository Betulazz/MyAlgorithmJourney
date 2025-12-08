package DP.OneDimension;

import java.util.Arrays;

public class NumDecodings2 {
    public static int numDecodings1(String s) {
        return f1(s.toCharArray(), 0);
    }

    public static int f1(char[] s, int i) {
        if (i == s.length) {
            return 1;
        }
        if (s[i] == '0') {
            return 0;
        }
        int ans = 0;
        // 1) i单独转
        ans = f1(s, i + 1) * (s[i] == '*' ? 9 : 1);
        // 2) i 和 i+1一起转
        if (i + 1 < s.length) {
            if (s[i] == '*') {
                // * num
                // i i+1
                if (s[i + 1] != '*') {
                    if (s[i + 1] <= '6') {
                        ans += 2 * f1(s, i + 2);
                    } else {
                        ans += f1(s, i + 2);
                    }
                } else {
                    // *  *
                    // i i+1
                    // 11 12 ... 19 21 22 ... 26 -> 一共15种可能
                    ans += 15 * f1(s, i + 2);
                }
            } else {
                if (s[i + 1] != '*') {
                    // num num
                    //  i  i+1
                    if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                        ans += f1(s, i + 2);
                    }
                } else {
                    // num  *
                    //  i  i+1
                    if (s[i] == '1') {
                        ans += 9 * f1(s, i + 2);
                    }
                    if (s[i] == '2') {
                        ans += 6 * f1(s, i + 2);
                    }
                }
            }
        }
        return ans;
    }

    public static long mod = 1000000007;

    public static int numDecodings2(String str) {
        char[] s = str.toCharArray();
        long[] dp = new long[s.length];
        Arrays.fill(dp, -1);
        return (int) f2(s, 0, dp);
    }

    public static long f2(char[] s, int i, long[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (s[i] == '0') {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        long ans = 0;
        ans = f2(s, i + 1, dp) * (s[i] == '*' ? 9 : 1);
        if (i + 1 < s.length) {
            if (s[i] != '*') {
                if (s[i + 1] != '*') {
                    if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                        ans += f2(s, i + 2, dp);
                    }
                } else {
                    if (s[i] == '1') {
                        ans += 9 * f2(s, i + 2, dp);
                    }
                    if (s[i] == '2') {
                        ans += 6 * f2(s, i + 2, dp);
                    }
                }
            } else {
                if (s[i + 1] != '*') {
                    if (s[i + 1] <= '6') {
                        ans += 2 * f2(s, i + 2, dp);
                    } else {
                        ans += f2(s, i + 2, dp);
                    }
                } else {
                    ans += 15 * f2(s, i + 2, dp);
                }
            }
        }
        ans %= mod;
        dp[i] = ans;
        return ans;
    }

    public static int numDecodings3(String str) {
        int n = str.length();
        char[] s = str.toCharArray();
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] != '0') {
                dp[i] = dp[i + 1] * (s[i] == '*' ? 9 : 1);
                if (i + 1 < s.length) {
                    if (s[i] != '*') {
                        if (s[i + 1] != '*') {
                            if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            if (s[i] == '1') {
                                dp[i] += 9 * dp[i + 2];
                            }
                            if (s[i] == '2') {
                                dp[i] += 6 * dp[i + 2];
                            }
                        }
                    } else {
                        if (s[i + 1] != '*') {
                            if (s[i + 1] <= '6') {
                                dp[i] += 2 * dp[i + 2];
                            } else {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            dp[i] += 15 * dp[i + 2];
                        }
                    }
                }
            }
            dp[i] %= mod;
        }
        return (int) dp[0];
    }

    public static int numDecodings4(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        //cur dp[n-1]
        //next dp[n]
        //nextNext目前不存在
        long cur = 0, next = 1, nextNext = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] != '0') {
                cur = next * (s[i] == '*' ? 9 : 1);
                if (i + 1 < n) {
                    if (s[i] != '*') {
                        if (s[i + 1] != '*') {
                            if ((s[i] - '0') * 10 + s[i + 1] - '0' <= 26) {
                                cur += nextNext;
                            }
                        } else {
                            if (s[i] == '1') {
                                cur += 9 * nextNext;
                            }
                            if (s[i] == '2') {
                                cur += 6 * nextNext;
                            }
                        }
                    } else {
                        if (s[i + 1] != '*') {
                            if (s[i + 1] <= '6') {
                                cur += 2 * nextNext;
                            } else {
                                cur += nextNext;
                            }
                        } else {
                            cur += 15 * nextNext;
                        }
                    }
                }
                cur %= mod;
            }
            //   cur next nextNext
            //   next nextNext
            nextNext = next;
            next = cur;
            cur=0;
        }
        return (int) cur;
    }
}
