package simple;

import tree.TreeNode;

public class T563_二叉树的坡度 {
    int total = 0;
    // 得到root树的和
    public int findTilt(TreeNode root) {
        dfs(root);
        return total;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = dfs(root.left);
        int rightValue = dfs(root.right);
        total += Math.abs(leftValue - rightValue);

        return leftValue + rightValue + root.val;
    }
}
