package Bitwise.BitwiseOperation;

//https://leetcode.cn/problems/divide-two-integers/
public class BitOperation {
    public static int neg(int a) {
        return add(~a, 1);
    }

    public static int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            //b为进位
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    public static int minus(int a, int b) {
        return add(a, neg(b));
    }

    public static int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            //看b的最低位是否为0
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }

    //必须确保a和b都不是整数最小值
    public static int div(int a, int b) {
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >>> i) >= y) {
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }

    public static int MIN = Integer.MIN_VALUE;

    public static int divide(int a, int b) {
        if (a == MIN && b == MIN) {
            return 1;
        }
        if (a != MIN && b != MIN) {
            return div(a, b);
        }
        if (b == MIN) {
            return 0;
        }
        if (b == -1) {
            return Integer.MAX_VALUE;
        }
        a = add(a, b > 0 ? b : neg(b));
        int ans = divide(a, b);
        int offset = b > 0 ? -1 : 1;
        return add(ans, offset);
    }
}
