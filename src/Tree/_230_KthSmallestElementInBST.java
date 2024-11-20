package Tree;
import java.util.*;

public class _230_KthSmallestElementInBST {
	List<Integer> list = new ArrayList<>();
    public int kthSmallest0(TreeNode root, int k) {
        if(root == null) return 0;
        iter(root);
        if(k > list.size()) return 0;
        return list.get(k - 1);
    }
    private void iter(TreeNode root) {
        if(root == null) return;
        iter(root.left);
        list.add(root.val);
        iter(root.right);
    }
    // 另一种方法
    int count = 0;
	int result = 0;
    public int kthSmallest(TreeNode root, int k) { 	
        if(root == null) return 0;
        DFS(root, k);
        if(k > list.size()) return 0;
        return list.get(k - 1);
    }
    private void DFS(TreeNode root, int k) {
        if(root == null) return;
        DFS(root.left, k);
        count ++;
        if(count == k) {
        	result = root.val;
        	return;
        }
        DFS(root.right, k);
    }
}
