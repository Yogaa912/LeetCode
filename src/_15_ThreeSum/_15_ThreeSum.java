package _15_ThreeSum;
import java.util.*;

public class _15_ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums); // 排序
		for(int i = 0; i < nums.length - 2; i ++) {
			// skip the same value
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				int temp = nums[i] + nums[left] + nums[right];
				if(temp == 0) {
					list.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while(left < right && nums[left] == nums[left + 1]) left ++; // skip
					while(left < right && nums[right] == nums[right - 1]) right --; // skip
					left ++;
					right --;
				} else if(temp < 0) {
					left ++;
				} else {
					right --;
				}
			}
		}
		return list;
    }
	public static void main(String[] args) {
		int[] sum = {-1,0,1,2,-1,-4};
		threeSum(sum);
	}
}
