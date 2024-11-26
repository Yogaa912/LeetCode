package leetcode;
public class _704_BinarySearch {
	// 答题代码框架
	public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1, mid = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
    	// 测试样例
		_704_BinarySearch solution = new _704_BinarySearch();
    		System.out.println("测试结果：" + solution.search(new int[] {1,2,3}, 0));
	}
}
