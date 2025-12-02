package recursion;

public class NQueens {
    public static int totalNQueens1(int n) {
        if (n < 1) {
            return 0;
        }
        return f1(0, new int[n], n);
    }

    // i : 当前来到的行
    // path : 0...i-1行的皇后，都摆在了哪些列
    // n : 是几皇后问题
    // 返回 : 0...i-1行已经摆完了，i....n-1行可以去尝试的情况下还能找到几种有效的方法
    public static int f1(int i, int[] path, int n) {
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            //如果能放
            if (check(path, i, j)) {
                path[i] = j;
                ans += f1(i + 1, path, n);
            }
        }
        return ans;
    }

    public static boolean check(int[] path, int i, int j) {
        // 当行 i
        // 当列 j
        for (int k = 0; k < i; k++) {
            // 之前行 : k
            // 之前列 : path[k]
            if (path[k] == j || Math.abs(i - k) == Math.abs(j - path[k])) {
                return false;
            }
        }
        return true;
    }

    public static int totalNQueens2(int n) {
        if (n < 1) {
            return 0;
        }
        //n=5
        //limit=100000-1
        //limit=011111
        int limit = (1 << n) - 1;
        return f2(limit, 0, 0, 0);
    }

    public static int f2(int limit, int col, int left, int right) {
        if (limit == col) {
            return 1;
        }
        int ban = col | left | right;
        //候选的位置，与上limit获取有效位数
        //1代表能放 0代表不能放
        int candidate = limit & (~ban);
        int place = 0;
        int ans = 0;
        while (candidate != 0) {
            //获取最后一个1
            //0 0 1 1 1 candidate
            //0 0 0 0 1 place
            //0 0 1 1 0 异或后
            place = candidate & (-candidate);
            candidate ^= place;
            ans += f2(limit, col | place, (left | place) << 1, (right | place) >> 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
