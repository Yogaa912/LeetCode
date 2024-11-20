package Tree;

public class _98_validateBinarSearchTree2 {
	private long pre = Long.MIN_VALUE; 
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left) || root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.left);
    }
    public static void main(String[] args) {
    	// 测试样例
    	_98_validateBinarSearchTree2 solution = new _98_validateBinarSearchTree2();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(1);
    	System.out.println("测试结果：" + solution.isValidBST(root));
	}
}
