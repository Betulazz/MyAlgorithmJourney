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

    class MyCircularDeque2{
        private int[] deque;
        private int l, r, size, limit;

        public MyCircularDeque2(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    l = l == 0 ? (limit - 1) : l - 1;
                    deque[l] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    r = r == (limit - 1) ? 0 : r + 1;
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                //l++
                l = l == (limit - 1) ? 0 : l + 1;
                size--;
                return true;
            }
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                //r--
                r = r == 0 ? (limit - 1) : r - 1;
                size--;
                return true;
            }
        }

        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return deque[l];
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return deque[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
