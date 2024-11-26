package leetcode;
public class _55_jumpGame {
	// 答题代码框架
	public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i <= maxReach; i++) {
	        maxReach = Math.max(maxReach, i + nums[i]);
	        if (maxReach >= nums.length - 1) {
	        	return true;
	        }
        }
        return false;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_55_jumpGame solution = new _55_jumpGame();
    		System.out.println("测试结果：" + solution.canJump(new int[] {2,3,1,1,4})); // true
	}
}
/**
 * 每一步选择当前最优解，最终得出全局最优解的问题，如活动选择问题、区间调度问题。
 * 贪心算法
 */