package TopInterview150;
import java.util.*;

public class _209_containsDuplicateii {
	// 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k
	public boolean containsNearbyDuplicate(int[] nums, int k) {
    	// 窗口为k
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i ++) {
			int num = nums[i];
			if(map.containsKey(num) && Math.abs(i - (map.get(num))) <= k) {
				return true;
			} else {
				map.put(num, i);
			}
		}
		return false;
	}

	// 测试代码
//	public static void main(String[] args) {
//    	// 测试样例
//		_209_containsDuplicateii solution = new _209_containsDuplicateii();
//		int[] nums = {1,2,3,1,2,3};
//		int k = 2;
//		System.out.println("测试结果：" + solution.containsNearbyDuplicate(nums, k));
//	}
}
