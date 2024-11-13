import java.util.*;

public class _26_RemoveDuplicatesSortedArray {
	public int removeDuplicates0(int[] nums) {
		List<Integer> list = new ArrayList<>();
		
		for(int i : nums) {
			list.add(i);
		}
//		System.out.println(list);
		int count = 0, left = 0, right = 1;
		while(right < list.size()) {
			if(list.get(left) == list.get(right)) {
				count ++;
				list.remove(right);
			} else {
				left = right;
				right ++;
			}
		}
		System.out.println(list);
		for(int i = 0; i < nums.length; i ++) {
			if(i < list.size()) {
				nums[i] = list.get(i);
			} else {
				nums[i] = 0;
			}
		}
		return nums.length - count;
	}
	public int removeDuplicates(int[] nums) {
		int left = 1, right = 1, len = nums.length;
		while(right < len) {
			if(nums[right] != nums[right - 1]) {
				nums[left] = nums[right]; 
				left ++;
			}
			right ++;
		}
		return left;
	}
	public static void main(String[] args) {
		_26_RemoveDuplicatesSortedArray solution = new _26_RemoveDuplicatesSortedArray();
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		System.out.println(solution.removeDuplicates(nums)); // 5, nums = [0,1,2,3,4]
		for(int i : nums) System.out.print(i);
	}
}
/**
 * 本质上这个解题方法是，如果不存在相同的数字，那么left和right将会一直是相同的，覆写前后没有差别
 * 但是一旦存在相同，那么left right就会存在差值，
 * 每当right和right - 1不同，说明相同的部分结束了，我们把首次不同的数字挪到前面的left处
 * 每次left覆写过一次，就可以移动left了，最后的int就是left移动的次数
 */