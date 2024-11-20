package Tree;

import java.util.*;

public class _144_binaryTreePreorderTraversal {
	List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return list;
        preOrder(root);
        return list;
    }
    private void preOrder(TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
