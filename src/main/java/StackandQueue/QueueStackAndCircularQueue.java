package StackandQueue;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


public class QueueStackAndCircularQueue {

    //直接用java内部的实现
    //其实内部就是双向链表，常数操作慢
    public static class Queue1 {

        //java中的双向链表LinkedList
        private Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        //向队列中加入num
        public void offer(int num) {
            queue.offer(num);
        }

        //从队列的头拿
        public int poll() {
            return queue.poll();
        }

        //返回队列头的元素但是不弹出
        public int peek() {
            return queue.peek();
        }

        //返回当前队列有几个数
        public int size() {
            return queue.size();
        }

    }

    //常数时间更好的队列
    public static class Queue2 {
        public int[] queue;
        public int l;
        public int r;

        public Queue2(int n) {
            queue = new int[n];
            l = 0;
            r = 0;
        }

        public void offer(int num) {
            queue[r++] = num;
        }

        public int poll() {
            return queue[l++];
        }

        public int head() {
            return queue[l];
        }

        public int tail() {
            return queue[r - 1];
        }

        public int size() {
            return r - l;
        }
    }

    //直接用java内部的实现
    public static class Stack1 {

        private Stack<Integer> stack = new Stack<>();

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void push(int num) {
            stack.push(num);
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public int size() {
            return stack.size();
        }
    }

    // 更常见的写法，常数时间好
    // 如果可以保证同时在栈里的元素个数不会超过n，那么可以用
    // 也就是发生弹出操作之后，空间可以复用
    public static class Stack2 {

        public int[] stack;
        public int size;

        public Stack2(int n) {
            stack = new int[n];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(int num) {
            stack[size++] = num;
        }

        public int pop() {
            return stack[--size];
        }

        public int peek() {
            return stack[size - 1];
        }

        public int size() {
            return size;
        }
    }

    //循环队列
    //循环队列：https://leetcode.cn/problems/design-circular-queue/
    class MyCircularQueue {

        public int[] queue;
        public int l, r, size, limit;

        MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean enQueue(int value) {
            if (size == limit) {
                return false;
            } else {
                queue[r] = value;
                r = r == limit - 1 ? 0 : (r + 1);
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if (size == 0) {
                return false;
            } else {
                l = l == limit - 1 ? 0 : (l + 1);
                size--;
                return true;
            }
        }

        public int Front() {
            if (size == 0) {
                return -1;
            } else {
                return queue[l];
            }
        }

        public int Rear() {
            if (size == 0) {
                return -1;
            } else {
                int last = r == 0 ? (limit - 1) : r - 1;
                return queue[last - 1];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
