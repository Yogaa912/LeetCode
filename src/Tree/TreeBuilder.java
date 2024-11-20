package Tree;

import java.util.*;

public class TreeBuilder {
	public TreeNode generateTree(Integer[] nums) {
		if(nums == null|| nums.length == 0) return null;
		Queue<TreeNode> q = new ArrayDeque<>();
		TreeNode root = new TreeNode(nums[0]);
		q.offer(root);
		int i = 1;
		while(!q.isEmpty() && i < nums.length) {
			TreeNode node = q.poll();
			if(nums[i] != null) {
				node.left = new TreeNode(nums[i]);
				q.offer(node.left);
			}
			i ++;
			if(i < nums.length && nums[i] != null) {
				node.right = new TreeNode(nums[i]);
				q.offer(node.right);
			}
			i ++;
		}
		return root;
	}
}
