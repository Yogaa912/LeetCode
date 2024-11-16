import java.util.*;

public class DFS {
	public List<String> binaryTreePaths(TreeNode root) {
	    List<String> result = new ArrayList<>();
	    if (root == null) return result;

	    dfs(root, "", result);
	    return result;
	}

	private void dfs(TreeNode node, String path, List<String> result) {
	    if (node == null) return;

	    path += node.val; // 添加当前节点值
	    if (node.left == null && node.right == null) { // 如果是叶子节点
	        result.add(path); // 将路径加入结果
	    } else {
	        path += "->"; // 添加箭头表示路径
	        dfs(node.left, path, result);
	        dfs(node.right, path, result);
	    }
	}
	public static void main(String[] args) {
		DFS solution = new DFS();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(solution.binaryTreePaths(root));
	}
}
