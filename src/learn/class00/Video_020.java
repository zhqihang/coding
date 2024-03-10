package learn.class00;

/**
 * @author: qihang
 * @CreateDate: 2023/12/18/ 14:31
 * @Project: coding
 * @Description:
 *
 *  递归
 *      画递归决策图
 *      递归的中间参数会压入系统栈, 子过程返回后出栈
 *
 *  master公式  子过程等规模 直接 确定递归复杂度
 *      log(b,a) > c  ===> O(n^log(b,a))
 *      log(b,a) < c  ===> O(n^c)
 *      log(b,a) = c  ===> O(n^c * log n)
 *
 *      T(n) = 2*T(n/2) + O(n*log n)，时间复杂度是O(n * ((log n)^2))，证明过程比较复杂，记住即可
 */
public class Video_020 {
}
