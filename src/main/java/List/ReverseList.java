package List;
//反转链表：https://leetcode.cn/problems/reverse-linked-list
public class ReverseList {
    public static void main(String[] args) {

    }
    //单链表
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;

        }
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next=next;
        }
    }
    //反转单链表
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //双链表
    public static class DoubleListNode{
        int val;
        DoubleListNode last;
        DoubleListNode next;
        DoubleListNode(int val){
            this.val=val;
            this.last=null;
            this.next=null;
        }
    }

    //反转双链表
    public static DoubleListNode reverseDoubleList(DoubleListNode head){
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            head.last = next;   //唯一区别
            pre = head;
            head = next;
        }
        return pre;
    }
}
