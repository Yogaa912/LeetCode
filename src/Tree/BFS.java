package Tree;
import java.util.*;

public class BFS {

	public List<List<Integer>> levelOrder(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<>();
	    if (root == null) return result;

	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);

	    while (!queue.isEmpty()) {
	        List<Integer> level = new ArrayList<>();
	        int size = queue.size(); // 当前层的节点数

	        for (int i = 0; i < size; i++) {
	            TreeNode node = queue.poll(); // 取出当前层的节点
	            level.add(node.val);
	            if (node.left != null) queue.offer(node.left);
	            if (node.right != null) queue.offer(node.right);
	        }

	        result.add(level);
	    }
	    return result;
	}
	public static void main(String[] args) {
		BFS solution = new BFS();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(solution.levelOrder(root));
	}
}
/*
 * void dfs(Node node, Set<Node> visited) {
    if (node == null || visited.contains(node)) return;
    visited.add(node);
    for (Node neighbor : node.neighbors) {
        dfs(neighbor, visited);
    }
}
 */