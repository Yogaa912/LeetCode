// Java文件：_162_findPeek.java
package leetcode;


public class _162_findPeek {
	// 答题代码框架
	public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while(left < right) {
            mid = left + (right - left)/2;
            if(nums[mid] > nums[mid + 1]) {
                // means target is at left
                right = mid;
            }
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_162_findPeek solution = new _162_findPeek();
    		System.out.println("测试结果：" + solution.findPeakElement(new int[] {1,2,3,1}));
	}
}
/**
 * 关键点在于两侧的nums都定义了绝对大于超过边框外侧的数字,说明必然存在一个peek
 * 所以把问题转为考察nums[i]和nums[i + 1]的大小问题,谁大就说明peek在谁那一侧
 */