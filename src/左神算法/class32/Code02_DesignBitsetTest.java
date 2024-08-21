package 左神算法.class32;

/**
 * @Author: zhqihang
 * @Date: 2024/01/31
 * @Project: coding
 * @Description: ...
 */
public class Code02_DesignBitsetTest {


    public static class Bitset {

        private int[] set;
        private final int size;
        private int zeros;// 几个0
        private int ones;// 几个1
        private boolean reverse;// 有无进行翻转

        // 初始化
        public Bitset(int n) {
            set = new int[(n + 31) / 32]; // 除32向上取整
            size = n;
            zeros = n;
            ones = 0;
            reverse = false;
        }

        public void fix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            if (!reverse) {
                if ((set[index] & (1 << bit)) == 0) {
                    zeros--;
                    ones++;
                    set[index] |= (1 << bit);
                }
            } else {
                if ((set[index] & (1 << bit)) != 0) {
                    zeros--;
                    ones++;
                    set[index] ^= (1 << bit);
                }
            }
        }

        public void unfix(int idx) {
            int index = idx / 32;
            int bit = idx % 32;
            if (!reverse) {
                if ((set[index] & (1 << bit)) != 0) {
                    ones--;
                    zeros++;
                    set[index] ^= (1 << bit);
                }
            } else {
                if ((set[index] & (1 << bit)) == 0) {
                    ones--;
                    zeros++;
                    set[index] |= (1 << bit);
                }
            }
        }


        public void flip() {
            reverse = !reverse;
            int tmp = ones;
            ones = zeros;
            zeros = tmp;
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
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0, k = 0, number, status; i < size; k++) {
                number = set[k]; // 每个数
                for (int j = 0; j < 32 && i < size; j++, i++) {
                    status = (number >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    stringBuilder.append(status);
                }
            }
            return stringBuilder.toString();
        }
    }

}
