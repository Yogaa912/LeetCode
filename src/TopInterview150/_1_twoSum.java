package TopInterview150;
import java.util.*;

public class _1_twoSum {
	// 答题代码框架
	public int[] twoSum(int[] nums, int target) {
		/**
		 * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，
		 * 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
		 * */
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < nums.length; i ++) {
    		int x = nums[i];
    		if(map.containsKey(target - x)) {
    			System.out.println(i + " " + map.get(target - x));
    			return new int[] {i, map.get(target - x)};
    		} else {
    			map.put(x, i);
    		}
    	}
		return new int[0];
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_1_twoSum solution = new _1_twoSum();
		int[] nums = {2,7,11,15};
		int target = 9;
		System.out.println("测试结果：" + solution.twoSum(nums, target));
	}
}
