package List;

//分隔链表：https://leetcode.cn/problems/partition-list/
public class PartList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode partList(ListNode head,int x){
        ListNode leftHead = null , leftTail = null;
        ListNode rightHead = null , rightTail = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = null;
            if(head.val < x){
                if(leftHead == null){
                    leftHead = head;
                    leftTail = head;
                }
                else{
                    leftTail.next = head;
                    leftTail = head;
                }
            }
            else{
                if(rightHead == null){
                    rightHead = head;
                    rightTail = head;
                }
                else{
                    rightTail.next = head;
                    rightTail = head;
                }
            }
            head = next;
        }
        //如果head为空lefthead也为空，返回rightHead也为空
        //如果左链表为空则返回右链表
        //如果右链表为空其实左链表直接连null
        if(leftHead == null){
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
}
