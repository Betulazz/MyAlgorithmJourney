package Bitwise.BitwiseOperation;
// 返回大于等于n的最小的2某次方
// 如果int范围内不存在这样的数，返回整数最小值
public class Near2power {
    public static int near2Power(int n) {
        if (n < 0) {
            return 1;
        } else {
            n--;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int n = 127;
        System.out.println(near2Power(n));
    }
}
