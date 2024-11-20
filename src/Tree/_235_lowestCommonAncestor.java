package Tree;

public class _235_lowestCommonAncestor {
	public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		TreeNode node = new TreeNode();
		while(node != null) {
            if(p.val == root.val || q.val == root.val) {
                node = root;
                break;
            }
			if(p.val < root.val) {
				if(q.val > root.val) {
					node = root;
                    break;
				} else {
					// 都在root左
					root = root.left;
				}
			} else if(q.val < root.val) {
				node = root;
                break;
			} else {
				// 都在root右侧
				root = root.right;
			}
		}
		return node;
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		while(root != null) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if(p.val > root.val && q.val > root.val) {
				root = root.right;
            } else {
            	return root;
            }
		}
		return root;
	}
	public static void main(String[] args) {
		_235_lowestCommonAncestor solution = new _235_lowestCommonAncestor();
		TreeBuilder tb = new TreeBuilder();
		Integer[] nums = new Integer[] {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode root = tb.generateTree(nums);
		System.out.println("The result is " + solution.lowestCommonAncestor(root, null, null));
	}
}