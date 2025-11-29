package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.cn/problems/subsets-ii/
public class subsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);

        f(nums,0,new int[nums.length],0,ans);
        return ans;
    }

    public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            ans.add(cur);
        } else {
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            //当前数取0个
            f(nums, j, path, size, ans);
            //当前数依次取1，2，3......个
            for (; i < j; i++) {
                path[size++] = nums[i];
                f(nums, j, path, size, ans);
            }
        }
    }
}
