package leetcode;
public class _26_removeDuplicatesFromSortedArray {
	public int removeDuplicates0(int[] nums) {
        int i = 0, j = 0;
        while(i < nums.length - 1){
            while(i < nums.length && nums[i] == nums[j]) {
                i ++;
            }
            if(i < nums.length && nums[j] != nums[i]) {
                j ++;
                nums[j] =nums[i];
            }
        }
        return j + 1;
    }
	public int removeDuplicates(int[] nums) {
	    if(nums == null || nums.length == 0) return 0;
	    int p = 0;
	    int q = 1;
	    while(q < nums.length){
	        if(nums[p] != nums[q]){
	            nums[p + 1] = nums[q];
	            p++;
	        }
	        q++;
	    }
	    return p + 1;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_26_removeDuplicatesFromSortedArray solution = new _26_removeDuplicatesFromSortedArray();
		System.out.println("测试结果：" + solution.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
}
/*
 * 每一次取整数数组的值的时候都要判断它的下标是否是valid	
 * 多写了一个while循环，没必要,直接让他在第一个大循环内部往右移动就可以了
 */