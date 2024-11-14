public class _70_ClimbingStairs {
	// 答题代码框架
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // dp[1] -> stairs = 1 num of method;
        dp[0] = 0; dp[1] = 1;
        if(n < 2) return dp[n];
        dp[2] = 2;
        for(int i = 3; i < n + 1; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_70_ClimbingStairs solution = new _70_ClimbingStairs();
    		System.out.println("测试结果：" + solution.climbStairs(5));
	}
}
