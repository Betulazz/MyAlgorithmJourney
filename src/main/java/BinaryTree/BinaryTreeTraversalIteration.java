package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.Stack;

//不用递归，用迭代实现二叉树的三种遍历
public class BinaryTreeTraversalIteration {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    //先序遍历
    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    //中序遍历
    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    //后序遍历
    //使用两个栈的方法
    public static void posOrderTwoStacks(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val + " ");
            }
        }
    }

    //后序遍历
    //只用一个栈
    public static void posOrderOneStack(TreeNode h) {
        if (h != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            // 如果始终没有打印过节点，h就一直是头节点
            // 一旦打印过节点，h就变成打印节点
            // 之后h的含义 : 上一次打印的节点
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                //有左子树且没被处理过
                if (cur.left != null && h != cur.left && h != cur.right) {
                    stack.push(cur.left);
                }
                //有右子树且没被处理过
                else if (cur.right != null && h != cur.right) {
                    stack.push(cur.right);
                }
                //没有左右子树或者左右子树都已经处理完
                else {
                    System.out.print(cur.val+" ");
                    h = stack.pop();
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println("树的先序遍历：");
        preOrder(head);
        System.out.println();

        System.out.println("树的中序遍历：");
        inOrder(head);
        System.out.println();

        System.out.println("树的后序遍历：");
        posOrderTwoStacks(head);
        System.out.println();

        System.out.println("树的后序遍历(一个栈)：");
        posOrderOneStack(head);
        System.out.println();
    }
}
