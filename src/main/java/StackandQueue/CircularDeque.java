package StackandQueue;

import java.util.Deque;
import java.util.LinkedList;

//双端队列：https://leetcode.cn/problems/design-circular-deque/
public class CircularDeque {
    class MyCircularDeque1 {

        private Deque<Integer> deque = new LinkedList<>();
        private int size;
        private int limit;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerFirst(value);
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                deque.offerLast(value);
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                deque.pollFirst();
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                deque.pollLast();
                size--;
                return true;
            }
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekFirst();
            }
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            } else {
                return deque.peekLast();
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
