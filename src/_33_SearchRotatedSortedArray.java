public class _33_SearchRotatedSortedArray {
	// 答题代码框架
	public int search0(int[] nums, int target) {
		if(nums == null) return -1;
		if(target < nums[0]) {
			for(int i = 0; i < nums.length; i ++) {
				if(target == nums[nums.length - 1 - i]) return nums.length - 1 - i;
			}
		} else {
			for(int i = 0; i < nums.length; i ++) {
				if(target == nums[i]) return i;
			}
		}
		return -1;
    	// 这里编写答题代码
	}
	public int search(int[] nums, int target) {
		// 取中点
		int len = nums.length, left = 0, right = len - 1, mid = 0;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(nums[mid] == target) return mid;
			// 判断哪一侧是有序的
			if(nums[left] <= nums[mid]) { // 这里必须是小于等于，因为虽然项目的数字不相同，但是有可能mid = left，所以两个本质上一样
				// left is increasing
				if(nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				// if target > nums[mid] || target < nums[left] 
			} else {
				if(nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1; // 如果没有找到目标值，返回 -1
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_33_SearchRotatedSortedArray solution = new _33_SearchRotatedSortedArray();
    	System.out.println("测试结果：" + solution.search(new int[] {4,5,6,7,0,1,2}, 0)); //s
	}
}
/**
 * 因为他的无序断点只有一处，所以只要二分下去，剩下的都是有序的本质上
 */