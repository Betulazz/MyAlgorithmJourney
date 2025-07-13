package List;

//合并两个链表：https://leetcode.cn/problems/merge-two-sorted-lists
public class MergeTwoLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode mergeTwoLists(ListNode head1,ListNode head2){
        //head节点为最小的节点
        ListNode head = head1.val<=head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head==head1 ? head2 : head1;
        //pre代表未排序的链表节点的前一个，即已排序链表的最后一个
        ListNode pre = head;
        //一旦遍历到一个链表的null后，只需要将这个链表连接到另一个链表就行了
        while(cur1!=null && cur2!=null){
            if(cur1.val<=cur2.val){
                pre.next = cur1;
                cur1 = cur1.next;
            }
            else{
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1==null ? cur2 : cur1;
        return head;
    }
}
