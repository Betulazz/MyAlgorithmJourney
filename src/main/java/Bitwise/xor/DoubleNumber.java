package Bitwise.xor;

// 数组中有2种数出现了奇数次，其他的数都出现了偶数次
// 返回这2种出现了奇数次的数
// 测试链接 : https://leetcode.cn/problems/single-number-iii/

public class DoubleNumber {
    public static int[] singleNumber(int[] nums) {
        int xor1 = 0;
        for (int i = 0; i < nums.length; i++) {
            //xor = a ^ b
            xor1 ^= nums[i];
        }
        int xor2 = 0;
        //取最后出现的1 其余位均为0
        int rightOne = xor1 & (~xor1 + 1);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightOne) == 0) {
                xor2 ^= nums[i];
            }
        }
        return new int[]{xor2, xor2 ^ xor1};
    }
}
