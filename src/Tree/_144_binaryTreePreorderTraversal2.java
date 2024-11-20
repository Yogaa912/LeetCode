package Tree;

import java.util.*;
// 还没写完，感觉深度优先更方便，估计广度优先也可以
public class _144_binaryTreePreorderTraversal2 {
	class Pair {
		TreeNode node;
		boolean isVisited;
		Pair(TreeNode node, boolean isVisited) {
			this.node = node;
			this.isVisited = isVisited;
		}
	}
	List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	TreeNode node = q.poll();
        	list.add(node.val);
        	if(node.left != null) q.offer(node.left);
        	if(node.right != null) q.offer(node.right);
        }
        
        return list;
    }
    private void preOrder(TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
