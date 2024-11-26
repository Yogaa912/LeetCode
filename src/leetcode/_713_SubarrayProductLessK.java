package leetcode;
import java.util.*;

public class _713_SubarrayProductLessK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if(k <= 1) return 0;
		int result = 0, left = 0;
		int right = left;
		int product = 1;
		// 
		while(right < nums.length) {
			product = product*nums[right];
			System.out.println("product"+product);
			
			while(product >= k) {
				System.out.println("record "+right+left);
				product /= nums[left];
				left ++;
			}
			
			result += right - left + 1;
			System.out.println(result);
			right ++;
		}
		return result;
	}
	public static void main(String[] args) {
		_713_SubarrayProductLessK solution = new _713_SubarrayProductLessK();
		System.out.println(solution.numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100)); // 8
		System.out.println(solution.numSubarrayProductLessThanK(new int[] {1,2,3}, 0)); // 0
		System.out.println(solution.numSubarrayProductLessThanK(new int[] {1,3}, 1)); // 0
	}
}