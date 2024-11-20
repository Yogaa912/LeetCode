package Tree;
import java.util.*;

public class _94_BinaryTreeInorderTraversal2 {	
	class Pair {
	    TreeNode node;
	    boolean visitedLeft;

	    Pair(TreeNode node, boolean visitedLeft) {
	        this.node = node;
	        this.visitedLeft = visitedLeft;
	    }
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		Queue<Pair> q = new LinkedList<>(); // queue的底层实现是什么
		// left mid right
		q.offer(new Pair(root, false));
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			TreeNode newNode = curr.node;
			boolean visitedLeft = curr.visitedLeft;
			if(newNode == null) continue;
			if(!visitedLeft) {
				if(newNode.left != null) {
					q.offer(new Pair(newNode.left, false));
				}
				q.offer(new Pair(newNode, true));
				if(newNode.right != null) {
					q.offer(new Pair(newNode.right, false));
				}
			} else {
				result.add(newNode.val);
			}
		}
    	return result;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_94_BinaryTreeInorderTraversal2 solution = new _94_BinaryTreeInorderTraversal2();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
    	System.out.println("测试结果：" + solution.inorderTraversal(root));
	}
}
