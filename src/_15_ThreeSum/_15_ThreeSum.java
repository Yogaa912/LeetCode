package _15_ThreeSum;
import java.util.*;

public class _15_ThreeSum {
	public static List<List<Integer>> threeSum0(int[] nums) {
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
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> re = new ArrayList<>();
		Arrays.sort(nums);
		for(int i : nums) System.out.print(i + " ");
		int sum = 0;
		for(int i = 0; i < nums.length - 2; i ++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;  // i也要记得跳过
			int left = i + 1;
			int right = nums.length - 1;
			System.out.println(" left + right " + left + right);
			while(left < right) {
				sum = nums[left] + nums[right] + nums[i];
				System.out.println("sum is " + sum);
				if(sum < 0) {
					left ++;
				} else if(sum > 0) {
					right --;
				} else {
					re.add(Arrays.asList(nums[i], nums[left], nums[right]));
					System.out.println("re " + nums[i] + nums[left] + nums[right]);
					// 跳过重复的 left 和 right 元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
					right --;
					left ++;
				}
			}
		}
		return re;
	}
	public static void main(String[] args) {
		System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
}
/**
 * 重复元素：当遇到重复元素时，可能会产生重复的三元组。i left right都要去重
 * 右指针初始化：你在每次迭代中没有重置右指针，因此在 while 循环时右指针的位置可能不对。
 * */
