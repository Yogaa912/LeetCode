package Tree;

import java.util.*;

public class _112_pathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
        // use DFS 深度优先
        
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return false;
        queue.offer(root);
        return DFS(root, 0, targetSum);
    }
    private boolean DFS(TreeNode node, int currentSum, int targetSum) {
        if(node == null) return false;
        currentSum += node.val;
        // 如果是叶子节点，那么就检查当前路径和是否等于目标和
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }
        // 递归检查左右子树
        return DFS(node.left, currentSum, targetSum) || DFS(node.right, currentSum, targetSum);
    }
    public static void main(String[] args) {
    	_112_pathSum solution = new _112_pathSum();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	System.out.println("result is " + solution.hasPathSum(root, 5));
    }
}
