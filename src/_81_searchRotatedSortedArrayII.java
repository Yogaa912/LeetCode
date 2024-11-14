public class _81_searchRotatedSortedArrayII {
	// 区别是有duplicate
	public boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1, mid = 0;
		while(left <= right) {
			mid = left + (right - left)/2;
			if(target == nums[mid]) return true;
			if(nums[mid] == nums[right]) {
				right --; 
				continue;
			}
			if(nums[mid] < nums[right]) {
				// right is in order
				if(nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if(nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return false;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_81_searchRotatedSortedArrayII solution = new _81_searchRotatedSortedArrayII();
    	System.out.println("测试结果：" + solution.search(new int[] {2,5,6,0,0,1,2}, 3)); // false
    	System.out.println("测试结果：" + solution.search(new int[] {2,2,2,2,0,1,2}, 0)); // true
	}
}
