package Bitwise.xor;

//获取最大值
//https://www.nowcoder.com/practice/d2707eaf98124f1e8f1d9c18ad487f76
public class GetMax {
    public static int flip(int a) {
        return a ^ 1;
    }

    //非负返回1
    //负数返回0
    public static int sign(int a) {
        return flip(a >>> 31);
    }

    //有溢出风险
    public static int getMax1(int a, int b) {
        int c = a - b;
        //c非负 returnA=1 returnB=0
        //c负数 returnA=0 returnB=1
        int returnA = sign(c);
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sc = sign(c);
        int sa = sign(a);
        int sb = sign(b);
        //如果ab符号相等 diffAB=0 sameAB=1
        //如果ab符号不等 diffAB=1 sameAB=0
        int diffAB = sa ^ sb;
        int sameAB = flip(diffAB);
        //a和b符号不等 && a非负 返回a
        //a和b符号相等 && c非负 返回a
        int returnA = sa * diffAB + sc * sameAB;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        System.out.println(getMax2(a, b));
    }
}
