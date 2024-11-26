package leetcode;

public class _53_MaximumSubarray {
	public int maxSubArray0(int[] nums) {
		// 维护一个截止在i的substring里面最大的结果
		int len = nums.length, max = Integer.MIN_VALUE;
		if(len == 1) return nums[0];
		if(len == 0) return 0;
		int[] imax = new int[len];
		for(int i = 0; i < len; i ++) {
			imax[i] = nums[i];
		}
		for(int i = 1; i < len; i ++) {
			imax[i] = Math.max(imax[i - 1] + nums[i], nums[i]);
		}
		for(int i : imax) max = Math.max(max, i);
		return max;
	}
	public int maxSubArray(int[] nums) {
	    int max = nums[0];  // Initialize the max with the first element.
	    int currentMax = nums[0];  // Also initialize the current max with the first element.
	    for (int i = 1; i < nums.length; i++) {
	        currentMax = Math.max(currentMax + nums[i], nums[i]);
	        max = Math.max(max, currentMax);
	    }
	    return max;
	}
	public static void main(String[] args) {
		_53_MaximumSubarray solution = new _53_MaximumSubarray();
		System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4})); // 6
		System.out.println(solution.maxSubArray(new int[] {-1,-2})); // 6
	}
}
