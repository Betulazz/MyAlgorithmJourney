package List;

//两数相加：https://leetcode.cn/problems/add-two-numbers/
public class AddTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    //
    public static ListNode AddTwoLists(ListNode h1, ListNode h2) {
        ListNode cur = null, ans = null;
        int carry = 0;
        //遍历到两个链表均为空则停止
        for (int val, sum;
             h1 != null || h2 != null;
             h1 = h1 == null ? null : h1.next,
                     h2 = h2 == null ? null : h2.next) {
            //如果一个遍历到链表为空则加0
            sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            val = sum % 10;
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(val);
                cur = ans;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ans;
    }
}

