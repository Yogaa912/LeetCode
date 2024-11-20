package Tree;

import java.util.*;
// 广度优先算法？
public class _103_BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        if(root == null) return result;
        while(!q.isEmpty()) {
            // 把root的
        	List<Integer> level = new LinkedList<>();
        	int size = q.size();
        	
        	for(int i = 0; i < size; i ++) {
        		TreeNode node = q.poll();
        		level.add(node.val);
        		if(node.left != null) q.offer(node.left);
        		if(node.right != null) q.offer(node.right);
        	}
        	result.add(level);
        }
        return result;
    }
}
