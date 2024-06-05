package leetcode.everyday.June;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhqihang
 * @Date: 2024/06/05
 * @Project: coding
 * @Description: 将两个元素分配到两个数组中 2
 * https://leetcode.cn/problems/distribute-elements-into-two-arrays-ii/
 */
public class Demo_0605 {

    public int[] resultArray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int n = nums.length;

        List<Integer> a = new ArrayList<>(n); // 预分配空间
        List<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);

        Fenwick t1 = new Fenwick(n + 1);
        Fenwick t2 = new Fenwick(n + 1);
        t1.add(Arrays.binarySearch(sorted, nums[0]) + 1);
        t2.add(Arrays.binarySearch(sorted, nums[1]) + 1);

        for (int i = 2; i < nums.length; i++) {
            int x = nums[i];
            int v = Arrays.binarySearch(sorted, x) + 1;
            int gc1 = a.size() - t1.pre(v); // greaterCount(a, v)
            int gc2 = b.size() - t2.pre(v); // greaterCount(b, v)
            if (gc1 > gc2 || gc1 == gc2 && a.size() <= b.size()) {
                a.add(x);
                t1.add(v);
            } else {
                b.add(x);
                t2.add(v);
            }
        }
        a.addAll(b);
        for (int i = 0; i < n; i++) {
            nums[i] = a.get(i);
        }
        return nums;
    }
}

class Fenwick {
    private final int[] tree;


    public Fenwick(int n) {
        tree = new int[n];
    }

    public void add(int i) {
        while (i < tree.length) {
            tree[i]++;
            i += i & -i;
        }
    }

    public int pre(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i &= i - 1;
        }
        return res;
    }
}