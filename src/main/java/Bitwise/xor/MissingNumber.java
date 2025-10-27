package Bitwise.xor;

//丢失的数字
//https://leetcode.cn/problems/missing-number/
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int xorAll = 0;
        int xorHas = 0;
        for (int i = 0; i < nums.length; i++) {
            xorAll ^= i;
            xorHas ^= nums[i];
        }
        xorAll ^= nums.length;
        return xorAll^xorHas;
    }
}
