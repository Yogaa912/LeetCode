public class _154_FindMinRotatedArrayII {
	// 答题代码框架
	public int findMin0(int[] nums) {
        // n is odd, recover, n is even, change
        // maybe duplicate
        
        int left = 0, right = nums.length - 1, mid = 0, min = Integer.MAX_VALUE;
        while(left <= right) { // = 
            mid = left + (right - left)/2;
            System.out.println(" " + nums[left] + nums[mid] + nums[right] + min);
            // duplicate elements
            // [2,2,2,2,0,1,2],如果 nums[mid] 和 nums[right] 相等时，直接将 right 左移一位 right--，以跳过重复元素。
            if(nums[left] == nums[mid] && nums[mid] == nums[right]) {
            	min = Math.min(min,nums[mid]); 
            	right --;
            	System.out.println("4");
            	continue;
            } 
        	// 旋转n次的设定要怎么处理，直接if(数组没变吗)
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
            	System.out.println("1");
                min = Math.min(min,nums[left]);
                System.out.println(min);
                break;
            }
            if(nums[left] < nums[mid] || nums[mid] > nums[right]) { // left is strictly increasing
                // [2,2,2,0,1] & [2,2,2,2,2] & [0,1,2,2,2]
            	System.out.println("2");
            	min = Math.min(min,nums[left]); // [4,5,6,7,0,1,4]
                left = mid + 1;
                continue;
            }
            if(nums[right] > nums[mid] || nums[left] > nums[mid]) {
            	System.out.println("3");
            	min = Math.min(min,nums[mid]);
                right = mid - 1;
                System.out.println(min);
                continue;
            }
        }
        return min;
    }
	public int findMin(int[] nums) {
	    int left = 0, right = nums.length - 1;
	    
	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        
	        // If nums[mid] is greater than nums[right], minimum is in the right half
	        if (nums[mid] > nums[right]) {
	            left = mid + 1;
	        }
	        // If nums[mid] is less than nums[right], minimum is in the left half (including mid)
	        else if (nums[mid] < nums[right]) {
	            right = mid;
	        }
	        // If nums[mid] == nums[right], we cannot determine which side is sorted, so we shrink the search range by moving right
	        else {
	            right--;
	        }
	    }
	    
	    return nums[left];  // left is the index of the minimum value
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_154_FindMinRotatedArrayII solution = new _154_FindMinRotatedArrayII();
    		System.out.println("测试结果：" + solution.findMin(new int[] {5,4,5,5,5,5})); // 0
	}
}
/**
 * 在分析旋转数组时，尽量先从大局上考虑：旋转后数组分成了两部分，一边始终比另一边大或小。这有助于把问题简化为“左半边 vs 右半边”的比较，而不需要一开始就考虑很多小的细节。
 * 比如在旋转排序数组中，我们可以快速确认：要么左边严格大于右边（因为存在旋转点），要么整体有序（没发生旋转）。
 * 比如在二分查找中，right 通常是一个很好的“锚点”，因为我们寻找的是最小值。所以可以多考虑 mid 和 right 的关系，利用这个“锚点”让逻辑更清晰。
 * 当 nums[mid] > nums[right] 时，最小值在右侧。这个思维方式会比考虑多种不同情况更简洁，因为只需关注一个锚点的变化即可。
 */