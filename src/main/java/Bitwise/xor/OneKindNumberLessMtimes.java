package Bitwise.xor;

public class OneKindNumberLessMtimes {
    public static int singleNumber(int[] nums) {
        return find(nums, 3);
    }

    public static int find(int[] nums, int m) {
        //统计二进制每位上的1出现了几次
        //cnts[0] = 1 代表0位置上1出现了1次
        int[] cnts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                cnts[j] += (nums[i] >> j) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnts[i] % m != 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
