package Bitwise.xor;

// 数组中1种数出现了奇数次，其他的数都出现了偶数次
// 返回出现了奇数次的数
//https://leetcode.cn/problems/single-number/

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int xorAll = 0;
        for (int i = 0; i < nums.length; i++) {
            xorAll ^= nums[i];
        }
        return xorAll;
    }
}
