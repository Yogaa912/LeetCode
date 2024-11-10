package _167_TwoSumII_InputArrayIsSorted;

public class _167_TwoSumII_InputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = {0,0};
		int right = numbers.length - 1;
		int left = 0;
		while(left < right) {
			int sum = numbers[right] + numbers[left];
			if(sum == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				return result;
			} else if(sum < target) {
				left++;
			} else {
				right --;
			}
		}
		return new int[0];
    }
}
