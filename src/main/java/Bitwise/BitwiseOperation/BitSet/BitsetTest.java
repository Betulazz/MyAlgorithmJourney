package Bitwise.BitwiseOperation.BitSet;

public class BitsetTest {
    //    请你实现 Bitset 类。
//
//    Bitset(int n) 用 n 个位初始化 Bitset ，所有位都是 0 。
//    void fix(int idx) 将下标为 idx 的位上的值更新为 1 。如果值已经是 1 ，则不会发生任何改变。
//    void unfix(int idx) 将下标为 idx 的位上的值更新为 0 。如果值已经是 0 ，则不会发生任何改变。
//    void flip() 翻转 Bitset 中每一位上的值。换句话说，所有值为 0 的位将会变成 1 ，反之亦然。
//    boolean all() 检查 Bitset 中 每一位 的值是否都是 1 。如果满足此条件，返回 true ；否则，返回 false 。
//    boolean one() 检查 Bitset 中 是否 至少一位 的值是 1 。如果满足此条件，返回 true ；否则，返回 false 。
//    int count() 返回 Bitset 中值为 1 的位的 总数 。
//    String toString() 返回 Bitset 的当前组成情况。注意，在结果字符串中，第 i 个下标处的字符应该与 Bitset 中的第 i 位一致。
    public class Bitset {
        private int[] set;
        private int size;
        private int ones;
        private int zeros;
        private boolean reverse;

        public Bitset(int n) {
            set = new int[(n + 31) / 32];
            size = n;
            ones = 0;
            zeros = n;
            reverse = false;
        }

        public void fix(int i) {
            int index = i / 32;
            int bits = i % 32;
            if (!reverse) {
                //如果不存在这个数字
                if ((set[index] & (1 << bits)) == 0) {
                    set[index] |= (1 << bits);
                    zeros--;
                    ones++;
                }
            } else {
                //如果不存在这个数字
                if ((set[index] & (1 << bits)) != 0) {
                    set[index] ^= (1 << bits);
                    zeros--;
                    ones++;
                }
            }
        }

        public void unfix(int i) {
            int index = i / 32;
            int bits = i % 32;
            if (!reverse) {
                //如果存在这个数字
                if ((set[index] & (1 << bits)) != 0) {
                    set[index] ^= (1 << bits);
                    zeros++;
                    ones--;
                }
            } else {
                //如果存在这个数字
                //0存在 1不存在
                if ((set[index] & (1 << bits)) == 0) {
                    set[index] |= (1 << bits);
                    zeros++;
                    ones--;
                }
            }
        }

        public void flip() {
            reverse = !reverse;
            int temp = zeros;
            zeros = ones;
            ones = temp;
        }

        public boolean all() {
            return ones == size;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0, k = 0, number, status; i < size; k++) {
                number = set[k];
                for (int j = 0; j < 32 && i < size; j++, i++) {
                    status = (number >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    builder.append(status);
                }
            }
            return builder.toString();
        }
    }
}
