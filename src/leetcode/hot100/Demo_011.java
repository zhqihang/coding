package leetcode.hot100;

/**
 * @Author: zhqihang
 * @Date: 2024/05/04
 * @Project: coding
 * @Description: 盛最多水的容器
 */
public class Demo_011 {
    // 双指针
    public int maxArea(int[] height) {
        int ans = 0;
        for (int l = 0, r = height.length - 1; l < r;) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
