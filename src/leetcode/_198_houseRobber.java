package leetcode;
public class _198_houseRobber {
	public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        for (int i =  0; i < nums.length; i ++) {
            dp[i] = nums[i];
        }
        if(nums.length == 1) return dp[0];
        int max = Math.max(dp[0], dp[1]);
        dp[1] = max;
        if(nums.length == 2) return max;
        for(int i = 2; i < nums.length; i ++) {
            dp[i] += dp[i - 2];
            dp[i] = Math.max(dp[i], dp[i - 1]);
            max = dp[i];
        }
        return max;
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_198_houseRobber solution = new _198_houseRobber();
    		System.out.println("测试结果：" + solution.rob(new int[] {1,2,3,1})); // 4
	}
}
