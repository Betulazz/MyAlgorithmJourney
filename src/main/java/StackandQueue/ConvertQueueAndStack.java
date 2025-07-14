package StackandQueue;

import java.util.Stack;

//用栈实现队列:https://leetcode.cn/problems/implement-queue-using-stacks/
public class ConvertQueueAndStack {
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
}
