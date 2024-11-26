package leetcode;
import java.util.*;

public class _16_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int distance = Integer.MAX_VALUE, re = 0, sum = 0;
		for(int i : nums) System.out.print(i+", ");
		System.out.println("\n");
		for(int i = 0; i < nums.length - 2; i ++) {
			int left = i + 1, right = nums.length - 1;
			while(left < right) {
				sum = nums[i] + nums[left] + nums[right];
				System.out.println("sum is " + sum);
				if(sum < target) {
					left ++;
				} else if(sum > target) {
					right --;
				} else {
					return target;
				}
				if(Math.abs(target - sum) < distance) {
					distance = Math.abs(target - sum);
					re = sum;
					System.out.println("min is " + distance);
				}
				// 比较|sum - target|
			}
		}
		return re;
	}
	public static void main(String[] args) {
		_16_3SumClosest solution = new _16_3SumClosest();
		System.out.println(solution.threeSumClosest(new int[] {-1,2,1,-4}, 1)); // 2
		System.out.println(solution.threeSumClosest(new int[] {1,2,3}, 6)); // 2
	}
}
