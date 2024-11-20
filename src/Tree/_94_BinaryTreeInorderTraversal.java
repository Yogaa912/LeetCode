package Tree;
import java.util.*;

public class _94_BinaryTreeInorderTraversal {
	// 答题代码框架
	List<Integer> result = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null) return new ArrayList<>();
		// Queue<Integer> q = new ArrayDeque<>(); // queue的底层实现是什么
		// left mid right
		inorder(root);
    	return result;
	}
	public void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		result.add(root.val);
		inorder(root.right);	
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_94_BinaryTreeInorderTraversal solution = new _94_BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
    	System.out.println("测试结果：" + solution.inorderTraversal(root));
	}
}
