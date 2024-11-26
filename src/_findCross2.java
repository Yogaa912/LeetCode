import java.util.*;

public class _findCross2 {
	// 答题代码框架
	public int method(int[][] nums) {
		int rows = 0, cols = 0, result = 0;
		if(nums == null || nums.length == 0) return 0;
		List<int[][]> notValid = new ArrayList<>();
		// 查找每行每列的不同数值，只要超过2就直接跳过，剩下的再遍历
		// 每行
		int[] rowUnique = new int[nums.length];
	    int[] colUnique = new int[nums[0].length];
		for(int i = 0; i < nums[0].length; i ++) {
			
		}
		for(rows = 0; rows < nums.length; rows ++) {
			for(cols = 0; cols < nums[0].length; cols ++) {
				int number1 ;
//				if(rowsValid(rows, cols, nums) == true && colsValic(rows, cols, nums) == true) result ++;
			}
		}
    	return result;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_findCross2 solution = new _findCross2();
    		System.out.println("测试结果：" + solution.method(
				new int[][] {
					{1,2,3},
					{2,3,4}
					}));
	}
}
