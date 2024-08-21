package 左神算法.class00;


/**
 * @author: qihang
 * @CreateDate: 2023/12/14/ 9:17
 * @Project: coding
 * @Description: 二叉树 三序遍历递归实现
 * 先序: 中 左 右  第一次经过写入
 * 中序: 左 中 右  第二次经过写入
 * 后序: 左 右 中  第三次经过写入
 */
public class Video_017 {

    // 递归先序遍历
    public static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " "); // 打印
        preOrder(head.left); // 递归左子树
        preOrder(head.right); // 递归右子树
    }

    public static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }


    public static void posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        preOrder(head);
        System.out.println();
        System.out.println("先序遍历递归版");

        inOrder(head);
        System.out.println();
        System.out.println("中序遍历递归版");

        posOrder(head);
        System.out.println();
        System.out.println("后序遍历递归版");
    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
}
