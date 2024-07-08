package leetcode.lcr;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/description/
 * <p>
 * 仓库管理员以数组 stock 形式记录商品库存表。
 * stock[i] 表示商品 id，可能存在重复。
 * 原库存表按商品 id 升序排列。
 * 现因突发情况需要进行商品紧急调拨，管理员将这批商品 id 提前依次整理至库存表最后。
 * 请你找到并返回库存表中编号的 最小的元素 以便及时记录本次调拨。
 * <p>
 * 示例 1：
 * 输入：stock = [4,5,8,3,4]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：stock = [5,7,9,1,2]
 * 输出：1
 */

public class LCR_128 {
    // 二分搜索实现
    public int stockManagement(int[] stock) {
        int low = 0, high = stock.length - 1;
        while (low < high) {
            int mid = ((high - low) >> 1) + low;
            if (stock[mid] < stock[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return stock[low];
    }
}
