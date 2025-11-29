package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrder {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode[] queue = new TreeNode[2001];
    public static int l, r;

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            boolean reverse = false;
            while (l < r) {
                int size = r - l;
                List<Integer> list = new ArrayList<>();
                for (int i = reverse ? r - 1 : l, j = reverse ? -1 : 1, k = 0; k < size; i += j, k++) {
                    list.add(queue[i].val);
                }
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
                reverse = !reverse;
            }
        }
        return ans;
    }
}
