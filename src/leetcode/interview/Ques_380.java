package leetcode.interview;

import java.util.*;

/**
 * @Author: zhqihang
 * @Date: 2024/02/24
 * @Project: coding
 * @Description: Ques380
 * O(1)时间插入、删除和获取随机元素
 */
public class Ques_380 {
    /*
    变长数组 获取随机元素
    哈希表  插入和删除元素
    变长数组中存储元素，哈希表中存储每个 元素  在变长数组中的 下标
     */

    // 变长数组
    List<Integer> nums;
    // 哈希表
    Map<Integer, Integer> indices;
    // 随机数
    Random random;

    public Ques_380() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    // 插入操作
    public boolean insert(int val) {
        // 判断val是否在 hash 表中 存在返回false
        if (indices.containsKey(val)) {
            return false;
        }
        // 不存在 插入到末尾 返回true
        int index = nums.size(); // 插入位置索引（末尾）
        nums.add(val); // 插入到变长数组中
        indices.put(val, index); // 插入到哈希表中
        return true;
    }

    // 删除操作
    public boolean remove(int val) {
        // 判断val是否在hash表中 存在删除后返回true
        if (!indices.containsKey(val)) {
            return false;
        }
        // 删除操作
        int index = indices.get(val); // 删除元素的索引
        int last = nums.get(nums.size() - 1); // 变长数组的最后一位元素
        // 这里注意顺序
        nums.set(index, last); // 最后一位的值移动到要删除位置 进行覆盖
        indices.put(last, index); // 更新哈希表
        nums.remove(nums.size() - 1); // 变长数组删除
        indices.remove(val); // 哈希表删除
        return true;
    }

    public int getRandom() {
        // 数组长度范围内的随机数
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
