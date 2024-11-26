package leetcode;
public class _27_removeElements {
	public int removeElement(int[] nums, int val) {
        int i = 0, j = 0, count = 0;
        while(i < nums.length && j < nums.length) {
            if(nums[i] != val && i > j) {
                nums[j] = nums[i];
                nums[i] = val;
            } else if(nums[i] == val) {
                count ++;
            }
            while(j < nums.length && nums[j] != val) {
                j ++;
            }
            i ++;
        }
        return nums.length - count;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_27_removeElements solution = new _27_removeElements();
    	System.out.println("测试结果：" + solution.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
	}
}
/*
 * 18min
 * 一开始没有考虑到i和j的位置关系，并且return写错了
 * /
 */