package recursion.nestification;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Caculate {

    public static int where;

    public static int solve(String s) {
        char[] str = s.toCharArray();
        where = 0;
        return f(str, 0);
    }

    // s[i....]开始计算，遇到字符串终止 或者 遇到)停止
    // 返回 : 自己负责的这一段，计算的结果
    // 返回之间，更新全局变量where，为了上游函数知道从哪继续！
    public static int f(char[] s, int i) {
        int cur = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        while (i < s.length && s[i] != ')') {
            if (s[i] >= '0' && s[i] <= '9') {
                cur = cur * 10 + s[i] - '0';
                i++;
            } else if (s[i] != '(') {
                //遇到运算符+ - * /
                push(nums, ops, cur, s[i]);
                i++;
                cur = 0;
            } else {
                //遇到 (
                cur = f(s, i + 1);
                i = where + 1;
            }
        }
        push(nums, ops, cur, '+');
        where = i;
        return compute(nums, ops);
    }

    public static void push(ArrayList<Integer> nums, ArrayList<Character> ops, int cur, char op) {
        int n = nums.size();
        if (n == 0 || ops.get(n - 1) == '+' || ops.get(n - 1) == '-') {
            nums.add(cur);
            ops.add(op);
        } else {
            int topNum = nums.get(n - 1);
            int topOp = ops.get(n - 1);
            if (topOp == '*') {
                nums.set(n - 1, topNum * cur);
            } else {
                nums.set(n - 1, topNum / cur);
            }
            ops.set(n - 1, op);
        }
    }

    public static int compute(ArrayList<Integer> nums, ArrayList<Character> ops) {
        int n = nums.size();
        int ans = nums.get(0);
        for (int i = 1; i < n; i++) {
            ans += ops.get(i - 1) == '+' ? nums.get(i) : -nums.get(i);
        }
        return ans;
    }
}
