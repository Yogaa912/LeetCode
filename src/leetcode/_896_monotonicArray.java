package leetcode;
public class _896_monotonicArray {
	// 答题代码框架
	public boolean isMonotonic(int[] nums) {
		boolean increasing = true;
		boolean decreasing = true;
		if(nums.length <= 1) return true;
		for(int i = 1; i < nums.length; i ++) {
			if(nums[i] < nums[i - 1]) increasing = false;
			if(nums[i] > nums[i - 1]) decreasing = false;
		}
		if(increasing == false && decreasing == false) return false;
    	return true;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_896_monotonicArray solution = new _896_monotonicArray();
    		System.out.println("测试结果：" + solution.isMonotonic(new int[] {1,2,3}));
	}
}
