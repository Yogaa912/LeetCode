package leetcode;
import java.util.*;

public class _992_SubarraysWithKDifferent {
	public int subarraysWithKDistinct(int[] nums, int k) {
		return atMost(nums,k) - atMost(nums,k - 1);
	}
	private int atMost(int[] nums, int k) {
		// sliding window
		int left = 0, right = 0, count = 0;
		Map<Integer, Integer> dic = new HashMap<>();
		while(right < nums.length) {
			dic.put(nums[right],dic.getOrDefault(nums[right], 0) + 1);
			while(dic.size() > k) {
				// move left until k - 1
				dic.put(nums[left], dic.get(nums[left]) - 1);
				if(dic.get(nums[left]) == 0) dic.remove(nums[left]);
				left ++;
			}
			count += (right - left + 1);
			right ++;
		}
		return count;
	}
	private int atMost2(int[] nums, int k) {
	    int left = 0, count = 0;
	    int[] freq = new int[nums.length + 1];  // 使用数组存储频率，index存储value，freq[index] = frequency
	    int distinctCount = 0;  // 窗口内不同整数的数量
	    for (int right = 0; right < nums.length; right++) {
	        if (freq[nums[right]] == 0) distinctCount++;
	        freq[nums[right]]++;
	        while (distinctCount > k) {
	            freq[nums[left]]--;
	            if (freq[nums[left]] == 0) distinctCount--;
	            left++;
	        }
	        count += right - left + 1;
	    }
	    return count;
	}
	public static void main(String[] args) {
		_992_SubarraysWithKDifferent sub = new _992_SubarraysWithKDifferent();
		System.out.println(sub.subarraysWithKDistinct(new int[] {1,2,1,2,3},2));
	}
}
/**
 * 首先是拆解问题，变成至多 K 个不同整数的子问题 -> exactly(K) = atMost(K) - atMost(K-1)
 * 实现 atMost 函数，这个我会，但是我没有想到该怎么把这个答案转化成最终答案
 * 
 * */
