package Bitwise.BitwiseOperation;

//计算一个数的二进制中有几个1
public class cntOnes {

    public int hammingDistance(int x, int y) {
        return (cntones(x ^ y));
    }

    public static int cntones(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(cntones(n));
    }
}
