package StackandQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ConvertQueueAndStack {

    //用栈实现队列:https://leetcode.cn/problems/implement-queue-using-stacks/
    class MyQueue{

        private Stack<Integer> in;
        private Stack<Integer> out;

        // 1.in必须全部到out中
        // 2.out为空时才能从in中入栈
        public void inToOut(){
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
        }

        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        public void push(int x) {
            in.push(x);
            inToOut();
        }

        public int pop() {
            inToOut();
            return out.pop();
        }

        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    //用队列实现栈：https://leetcode.cn/problems/implement-stack-using-queues/
    class MyStack {

        private Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for(int i=0;i<n;i++){
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
