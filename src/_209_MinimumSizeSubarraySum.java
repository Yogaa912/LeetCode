public class _209_MinimumSizeSubarraySum {
	public static int minSubArrayLen(int target, int[] nums) {
		int left = 0, sum = 0, output = Integer.MAX_VALUE;
		for(int right = 0; right < nums.length; right ++) {
			sum += nums[right];
			System.out.println("right is " + right + " sum is " + sum);
			// move left
			while(sum >= target) { // 每次判断时进行多余的运算
				output = Math.min((right - left + 1), output);
				sum -= nums[left];
				left ++;
			}
		}
		return output != Integer.MAX_VALUE ? output : 0;
    }
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
		System.out.println(minSubArrayLen(4, new int[]{1,4,4})); // 1
		System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
		System.out.println(minSubArrayLen(3, new int[]{1,1,1}));
	}
}
/**
 * 可以直接使用 sum >= target 作为 while 循环的判断条件，
 * 这样不需要提前减去 nums[left]，从而减少运算次数。
 * 可以在每次更新 output 后立即减去 nums[left] 并右移 left，从而缩短窗口大小，这样能够避免多余的if判断
 */