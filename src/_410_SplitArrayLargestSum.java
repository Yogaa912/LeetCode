public class _410_SplitArrayLargestSum {
	// 答题代码框架
	public int splitArray(int[] nums, int k) {
		int mid = 0, max = Integer.MIN_VALUE, sum = 0, re = 0;
		for(int i : nums) {
			max = Math.max(i, max);
			sum += i;
		}
		// if k = 1; = sum of all
		if(k == 1) return sum;
		// max <= mid <= sum
		while(max <= sum) {
			mid = max + (sum - max)/2;
			// 验证mid能不能满足当前条件：sum of substring <= mid, while the number of substring is k
			 if(isValid(nums, mid, k)) {
				re = mid; // maybe the answer
				sum = mid -1;
			} else  {
				max = mid + 1;
			}
			
		}
		 return re;
	}
	// 验证方法
	private boolean isValid(int[] nums, int mid, int k) {
		int currentSum = 0, count = 1;
		for(int i : nums) {
			if((currentSum + i) <= mid) {
				currentSum += i;
			} else {
				count ++;
				currentSum = i;
			}
		}
		return count <= k;
	}
	// calculate sum of left - left
	private int sumIs(int left, int right, int[] nums) {
		int sum = 0;
		while(left <= right) {
			sum += nums[left];
			left ++;
		}
		return sum;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_410_SplitArrayLargestSum solution = new _410_SplitArrayLargestSum();
    		System.out.println("测试结果：" + solution.splitArray(new int[] {7,2,5,10,8}, 2)); // 18
    		System.out.println("测试结果：" + solution.splitArray(new int[] {1,2,3,4,5}, 2)); // 9
	}
}
/**
 * 怎么保证substring的和是最小的，这个感觉有点类似sqtx，我感觉是要让两边的和最相近 
 * 同时nums还不是有序的
 * 最后k是分割的数量
 * tips
 * 其实可以把这个问题看作是一个“尝试不同子数组和的上限”的问题：给定一个“子数组和上限”，你可以验证是否可以将数组分成 k 个部分，使每个部分的和不超过这个上限。
 * 这种方法可以帮助我们逐步缩小范围，从而找到最小的可能上限。
 * 
 * 这种解题方法可以理解为“假设结果已知，围绕它构建解决方案”。这种思路有时被称为“二分答案”，它在很多优化问题中非常常用，尤其是当我们需要最小化或最大化某个值
 * 
 * 我们的目标是检查是否能够将数组分成 k 个或更少的子数组，使得每个子数组的和都不超过 mid。
 * 具体过程是遍历数组并累加元素到当前子数组的和 currentSum，一旦 currentSum 超过 mid，就开始一个新的子数组，并重置 currentSum。
 * 如果总的子数组数量超过了 k，说明当前的 mid 太小，无法满足条件。
 * 如果能成功分成 k 个或更少的子数组，说明当前的 mid 是满足条件的上限，可以继续缩小范围来尝试找到更小的上限。
 */