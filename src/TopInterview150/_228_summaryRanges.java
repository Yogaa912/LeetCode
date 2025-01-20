package TopInterview150;
import java.util.*;

public class _228_summaryRanges {
	// 答题代码框架
	public List<String> summaryRanges(int[] nums) {
    	// 这里编写答题代码
		List<String> list = new ArrayList<>();
		int start = 0, end = 0;
		if(nums.length == 0) return list;
		if(nums.length == 1) list.add(String.valueOf(nums[0]));
		for(int i = 1; i < nums.length; i ++) {
			if(nums[i] != nums[i - 1] + 1) {
				if(start == end) {
					list.add(String.valueOf(nums[start]));
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(nums[start]).append("->").append(nums[end]);
					list.add(sb.toString());
				}
				start = i;
				end = i;
				if(end == nums.length - 1) list.add(String.valueOf(nums[end]));
			} else {
				end ++;
				if(end == nums.length - 1) {
					StringBuilder sb = new StringBuilder();
					sb.append(nums[start]).append("->").append(nums[end]);
					list.add(sb.toString());
				}
			}
		}
		return list;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_228_summaryRanges solution = new _228_summaryRanges();
		System.out.println("测试结果：" + solution.summaryRanges(new int[] {0,1,2,4,5,7}));
	}
}
