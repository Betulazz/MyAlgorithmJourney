package StackandQueue;

import java.util.Stack;

//最小栈:https://leetcode.cn/problems/min-stack/
public class MinStack {

    //使用java内部的栈实现
    class MinStack1 {
        private Stack<Integer> data;
        private Stack<Integer> min;

        public MinStack1() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty() || (val <= min.peek())) {
                min.push(val);
            } else {
                min.push(min.peek());
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    class MinStack2 {
        private int[] data;
        private int[] min;
        private int size;
        private final int MAXN = 8000;

        public MinStack2() {
            data = new int[MAXN];
            min = new int[MAXN];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || (val <= min[size - 1])) {
                min[size] = val;
            } else {
                min[size] = min[size - 1];
            }
            //最后再统一让size加一
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }
    }
}
