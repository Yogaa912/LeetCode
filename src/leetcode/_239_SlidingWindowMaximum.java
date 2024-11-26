package leetcode;
import java.util.*;

public class _239_SlidingWindowMaximum {
	public static int[] maxSlidingWindow0(int[] nums, int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		int[] result = new int[nums.length + 1 - k];
		int max = 0;
		if(nums.length < k) return null;
		for(int i = 0; i < nums.length; i ++) {
			dq.addLast(nums[i]);
			System.out.println("add " + nums[i]);
			max = Math.max(max, nums[i]);
			System.out.println("temp "+max);
			if(dq.size() == k) {
				// 比较要调出去的元素和max，看是不是当前的max
				if(i == nums.length - 1) {
					result[i + 1 - k] = max;
					break;
				}
				if(dq.peekFirst() == max && nums[i + 1] < max) {
					result[i + 1 - k] = max;
					System.out.println("! max is " + max);
					max = nums[i + 1];
					System.out.println("new max is " + max);
					for(int j = i + 2 - k; j <= i; j ++) {
						max = Math.max(max, nums[j]);
						System.out.println("max is " + max);
					}
				} else {
					result[i + 1 - k] = max;
					System.out.println("max is " + max);
				}
				System.out.println("cut " + dq.pollFirst()); 
			}
		}
		return result;
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		int[] re = new int[nums.length - k + 1];
		for(int i = 0; i < nums.length; i ++) {
			// 窗口内的项目数量足够了，返回max
			if(!dq.isEmpty() && dq.peekFirst() == i - k) { // i >= k - 1
				dq.pollFirst();
			}
			// 最尾端进行排序
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			// 添加项目，只添加index
			dq.addLast(i);
			if(i >= k - 1) re[i - k + 1] = nums[dq.peekFirst()];
		}
		return re;
	}
	public static void main(String[] args) {
		int[] result = maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		for(int i : result) System.out.print(i); // [3,3,5,5,6,7] 6 = nums.length + 1 - k
		result = maxSlidingWindow(new int[] {1}, 1);
		for(int i : result) System.out.print(i);
		result = maxSlidingWindow(new int[] {9,8,9,8}, 3);
		for(int i : result) System.out.print(i);// [1]
	}
}
/**
 * 我们可以使用 双端队列（Deque） 来维护一个递减的序列，这样可以在 O(1) 的时间复杂度内获取窗口内的最大值。具体步骤如下：
 * 队列中仅存储索引：Deque 中的元素是当前窗口内的元素索引，而不是元素的值。通过索引，我们可以轻松判断元素是否已超出窗口范围。
 * 保持递减顺序：在加入新元素时，如果队列末尾的元素小于新元素，则将其移除，这样队列中始终保持从大到小的顺序。
 * 获取最大值：队首的索引对应的元素始终是当前窗口的最大值。
 * 
 * 关键点在于每次把max数值从窗口滑出的时候，需要得知second max，但是我没有想到维护一个递减的deque来保证它；
 * 所以双端队列的特性在于可以从队尾进行序列的维护，从队头获得结果
 */