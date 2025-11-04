package Bitwise.BitwiseOperation.BitSet;

import java.util.HashSet;

// 位图的实现
// Bitset(int size)
// void add(int num)
// void remove(int num)
// void reverse(int num)
// boolean contains(int num)
public class Bitset {
    public int[] set;

    // n个数字 : 0~n-1
    public Bitset(int n) {
        //(a+b)向上取整：(a+b-1)/b
        set = new int[(n + 31) / 32];
    }

    public void add(int num) {
        set[num / 32] |= (1 << (num % 32));
    }

    public void remove(int num) {
        set[num / 32] &= ~(1 << (num % 32));
    }

    public void reverse(int num) {
        set[num / 32] ^= (1 << (num % 32));
    }

    public boolean contains(int num) {
        return (set[num / 32] >> (num % 32) & 1) == 1;
    }

    public static void main(String[] args) {
        //0-999
        int n = 1000;
        int testTimes = 10000;
        System.out.println("测试开始");
        Bitset bitset = new Bitset(n);
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("调用阶段开始");
        for (int i = 0; i < testTimes; i++) {
            double decide = Math.random();
            int number = (int) (Math.random() * n);
            if (decide < 0.333) {
                bitset.add(number);
                hashSet.add(number);
            } else if (decide < 0.666) {
                bitset.remove(number);
                hashSet.remove(number);
            } else {
                bitset.reverse(number);
                if (hashSet.contains(number)) {
                    hashSet.remove(number);
                } else {
                    hashSet.add(number);
                }
            }
        }
        System.out.println("调用阶段结束");
        System.out.println("验证阶段开始");
        for (int i = 0; i < n; i++) {
            if (bitset.contains(i) != hashSet.contains(i)) {
                System.out.println("出错了！");
            }
        }
        System.out.println("验证阶段结束");
        System.out.println("测试结束");
    }
}
