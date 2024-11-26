package leetcode;

public class _152_MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int len = nums.length, max = Integer.MIN_VALUE;
		int[] imax = new int[len];
		int[] imin = new int[len];
		for(int i = 0; i < len; i ++) {
			imax[i] = nums[i];
			imin[i] = nums[i];
		}
		for(int i = 1; i < len; i ++) {
			/**right = i数组的子数组最大的数值可能是：
			 * 1. 负的imin[i - 1]*负的nums[i]
			 * 2. 正的imax[i - 1]*正的nums[i]
			 * 3. 自己
			 **/
			imax[i] = Math.max(imax[i - 1]*nums[i], Math.max(imin[i - 1]*nums[i], nums[i])); 
			imin[i] = Math.min(imax[i - 1]*nums[i], Math.min(imin[i - 1]*nums[i], nums[i])); 
		}
		for(int i : imax) max = Math.max(max, i);
		return max;
	}
	public static void main(String[] args) {
		_152_MaximumProductSubarray solution = new _152_MaximumProductSubarray();
		System.out.println(solution.maxProduct(new int[] {2,3,-2,4}));
	}
}
