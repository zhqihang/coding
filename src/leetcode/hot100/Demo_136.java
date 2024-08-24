package leetcode.hot100;

/**
 * @description: 只出现一次的数字
 * @author: zhqihang
 * @date: 2024/08/24
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-100-liked
 */
public class Demo_136 {
    /*
    异或归零律：偶数为零 奇数为自身
     X ⊕ 0 = X
     X ⊕ X = 0
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) ans ^= num;
        return ans;
    }
}
