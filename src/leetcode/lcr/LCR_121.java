package leetcode.lcr;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: ...
 */
public class LCR_121 {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int i = plants.length - 1, j = 0;
        // 从左下角开始 往上游走 消除行列
        while(i >= 0 && j < plants[0].length){
            if(plants[i][j] > target) i--; // 消除行
            else if(plants[i][j] < target) j++; // 消除列
            else return true; // 相等
        }
        return false;
    }
}
