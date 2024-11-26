public class _findCross {
	// 答题代码框架
	public int method(int[][] nums) {
		int rows = 0, cols = 0, result = 0;
		if(nums == null || nums.length == 0) return 0;
		for(rows = 0; rows < nums.length; rows ++) {
			for(cols = 0; cols < nums[0].length; cols ++) {
				if(rowsValid(rows, cols, nums) == true && colsValic(rows, cols, nums) == true) result ++;
			}
		}
    	return result;
	}
	private boolean rowsValid(int row, int col, int[][] nums) {
		int sharedValue = -1; // 记录其他数值
		for(int i = 0; i < nums[0].length; i ++) {
			if(i != col) {
				if(sharedValue == -1) {
					sharedValue = nums[row][i];
				} else if(nums[row][i] != sharedValue) {
					return false;
				}
			}
		}
		return true;
	}
	private boolean colsValic(int row, int col, int[][] nums) {
		int sharedValue = -1; // 记录其他数值
		for(int i = 0; i < nums.length; i ++) {
			if(i != row) {
				if(sharedValue == -1) {
					sharedValue = nums[i][col];
				} else if(nums[i][col] != sharedValue) {
					return false;
				}
			}
		}
		return true;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_findCross solution = new _findCross();
		System.out.println("测试结果：" + solution.method(
				new int[][] {
					{1,2,3},
					{2,3,4}
					}));
	}
}
