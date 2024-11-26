package leetcode;
import java.util.*;

public class _169_majorityElement {
	public int majorityElement0(int[] nums) {
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		int j = 0;
		int n = nums.length;
		for(int i = 0; i < n; i ++) {
			if(nums[i] != nums[j]) {
				if(i - j > n/2) {
					list.add(nums[j]);
				}
				j = i;
			}
			if(i == n - 1) {
				if(i - j + 1> n/2) {
					list.add(nums[j]);
				}
			}
		}
		System.out.println(list);
    	return list.get(0);
	}
	public int majorityElement1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
		Arrays.sort(nums);
		return nums[(nums.length - 1)/2];
	}
	public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
	public static void main(String[] args) {
		_169_majorityElement solution = new _169_majorityElement();
		System.out.println("测试结果：" + solution.majorityElement(new int[] {2,2,1,1,1,2,2}));
	}
}
