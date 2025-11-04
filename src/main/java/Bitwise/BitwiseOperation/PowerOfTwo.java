package Bitwise.BitwiseOperation;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        //获取最右侧的1 n & (~n + 1)
        return n > 0 && (n == (n & (~n + 1)));
    }
}
