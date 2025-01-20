package TopInterview150;

import java.util.Arrays;
import java.util.*;

public class _128_longestConsecutiveSequence {
	// 答题代码框架
	public int longestConsecutive1(int[] nums) {
    	// 这里编写答题代码
		if(nums.length  <= 1) return nums.length;
		Arrays.sort(nums);
		for(int num : nums) System.out.println(num);
		int start = 0, maxLen = 0;
		for(int i = 1; i < nums.length; i ++) {
			while(nums[i] == nums[i - 1] && i < nums.length - 1) i++;
			if(nums[i] != nums[i - 1] + 1) {
				maxLen = Math.max(maxLen, nums[i - 1] - nums[start] + 1);
				start = i;
			} else {
				maxLen = Math.max(maxLen, nums[i] - nums[start] + 1);
			}
		}
		System.out.println(maxLen);
		return maxLen;
	}
	/**
	 * 优化思路: 如果你想提高效率，可以使用哈希集合（HashSet）来避免排序操作，时间复杂度可以优化到 O(n)
	 * 以下是优化版本的代码思路：将所有元素放入 HashSet。遍历数组，只从连续序列的起点开始计算长度。时间复杂度为 O(n),
	 * 因为每个元素最多被访问两次。
	 * */
	public int longestConsecutive(int[] nums) {
    	// 这里编写答题代码
		if(nums.length  <= 1) return nums.length;
		Set<Integer> set = new HashSet<>();
		for(int num : nums) System.out.println(num);
		int maxLen = 0;
		for(int i = 0; i < nums.length; i ++) {
			set.add(nums[i]);
		}
		// 遍历 HashSet 中的每个元素
	    for (int num : set) {
	        // 如果当前数字的前一个数字不存在，说明是一个序列的起点
	        if (!set.contains(num - 1)) {
	            int currentNum = num;
	            int currentLen = 1;

	            // 检查连续数字是否存在于 HashSet 中
	            while (set.contains(currentNum + 1)) {
	                currentNum++;
	                currentLen++;
	            }

	            // 更新最长序列长度
	            maxLen = Math.max(maxLen, currentLen);
	        }
	    }
		System.out.println(set);
		return maxLen;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_128_longestConsecutiveSequence solution = new _128_longestConsecutiveSequence();
		System.out.println("测试结果：" + solution.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
	}
}
/** 
 * 需要nums[?] = nums[i - 1] + 1
 * 记录开始的位置，nums[i]
 * 感觉像快慢指针
 */