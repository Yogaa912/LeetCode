package leetcode;
public class _80_removeDuplicatesFromSortedArrayII {
	public int removeDuplicates0(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = 1, count = 1;
        while(right < nums.length) {
            if(nums[left] != nums[right] && count >= 2) {
                nums[left + 1] = nums[left];
                left += 2;
                nums[left] = nums[right];
                count = 1;
            } else if(nums[left] != nums[right] && count < 2){
                left ++;
                nums[left] = nums[right];
                count = 1;
            } else if(nums[left] == nums[right]){
                count ++;
                if(right == nums.length - 1) {
                    left ++;
                    nums[left] = nums[right];
                }
            }
            right ++;
        }
        return left + 1;
    }
	public int removeDuplicates(int[] nums) {   
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0; 
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_80_removeDuplicatesFromSortedArrayII solution = new _80_removeDuplicatesFromSortedArrayII();
		System.out.println("测试结果：" + solution.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
}
/*
 * 数组是有序的，重复元素是连续的。
 * 重复次数最多允许为 k，所以可以通过检查距离当前位置 k 的元素，来决定是否保留当前元素。
 * 分解问题：
 * 如何判断元素isValid？
 * 1. 当前写入位置u < k，就是前k个元素直接保留（相同或不都不影响）
 * 2. 或者当前元素x不等于前k个位置的元素，（比如说k = 2的时候，x如果不等于前2个，说明x是一个新的数字了）
 * if(u < k || nums[u - k] != x) {
 * 	nums[u++] = x; 先执行nums[u] = x, 后执行u++
 * }
 * 
 * 先尝试构建一个基础逻辑，允许保留最多一个重复元素
 * 再修改k数值
 */