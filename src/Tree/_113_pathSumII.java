package Tree;
import java.util.*;

public class _113_pathSumII {
	List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;
        List<Integer> list = new ArrayList<>();
        iter(root, 0, list, targetSum);
        return result;
    }
    private void iter(TreeNode node, int curr, List<Integer> list, int targetSum) {
        if(node == null) return;
        curr += node.val;
        list.add(node.val);
        if(node.left == null && node.right == null && curr == targetSum) {
            result.add(new ArrayList<>(list));  
            // 应该使用 new ArrayList<>(list)，将当前路径的副本存储到 result 中，而不是直接存储引用    
        }
        // 递归到左右子树
        iter(node.left, curr, list, targetSum);
        iter(node.right, curr, list, targetSum);
        // 回溯：移除当前节点
        list.remove(list.size() - 1);
    }
    public static void main(String[] args) {
    	_113_pathSumII solution = new _113_pathSumII();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	System.out.println("result is " + solution.pathSum(root, 3));
    }
}
