package leetcode;

public class _189_rotateArray {
	public void rotate0(int[] nums, int k) {
        int[] n = new int[k];
        if(nums == null || nums.length == 0) return;
        if(k >= nums.length) k = k%nums.length;
        for(int i = 0; i < k; i ++) {
            n[i] = nums[nums.length - k + i];
        }
        for(int i = nums.length - 1; i >= 0; i --) {
            if(i < k) {
                nums[i] = n[i];
            } else {
                nums[i] = nums[i - k];
            }
        }
    }
	public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        k = k%nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
        	int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}
/**
 * 13min
 * 直接阶段性反转数组
 */