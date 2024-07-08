package leetcode.lcr;

/**
 * @Author: zhqihang
 * @Date: 2024/03/10
 * @Project: coding
 * @Description: https://leetcode.cn/problems/ti-huan-kong-ge-lcof/description/
 */
public class LCR_122 {
    public String pathEncryption(String path) {
        StringBuilder sb = new StringBuilder();
        for (Character c : path.toCharArray()) {
            if (c == '.')
                sb.append(' ');
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
