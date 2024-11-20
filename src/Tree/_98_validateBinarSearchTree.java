package Tree;

import java.util.*;

public class _98_validateBinarSearchTree {
	List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        DFS(root);
        for(int i = 1; i <= list.size() - 1; i ++) {
            if(list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }
    private void DFS(TreeNode node) {
        if(node == null) return;
        DFS(node.left);
        list.add(node.val);
        DFS(node.right);
    }
    public static void main(String[] args) {
    	// 测试样例
    	_98_validateBinarSearchTree solution = new _98_validateBinarSearchTree();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(1);
    	System.out.println("测试结果：" + solution.isValidBST(root));
	}
}
