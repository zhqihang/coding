package leetcode.everyday.May;

import java.util.*;

/**
 * @Author: zhqihang
 * @Date: 2024/05/22
 * @Project: coding
 * @Description: 找出输掉零场或者一场比赛的玩家
 * 给你一个整数数组 matches 其中 matches[i] = [winner_i, loser_i] 表示在一场比赛中 winner_i 击败了 loser_i 。
 * 返回一个长度为 2 的列表 answer ：
 * - answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * - answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * 注意：
 * - 只考虑那些参与 至少一场 比赛的玩家。
 * - 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * 输出：[[1,2,10],[4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 */
public class Demo_0522 {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>(); //
        for (int[] m : matches) {
            if (!lossCount.containsKey(m[0])) {
                lossCount.put(m[0], 0);
            }
            lossCount.merge(m[1], 1, Integer::sum);
        }
        List<List<Integer>> ans = List.of(new ArrayList<>(), new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : lossCount.entrySet()) {
            int cnt = e.getValue();
            if (cnt < 2) {
                ans.get(cnt).add(e.getKey());
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
