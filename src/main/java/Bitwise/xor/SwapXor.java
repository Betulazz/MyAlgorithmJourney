package Bitwise.xor;

public class SwapXor {
    public static void main(String[] args) {
        int a = -100;
        int b = 50;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
