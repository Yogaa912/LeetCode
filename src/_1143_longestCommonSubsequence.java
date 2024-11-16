public class _1143_longestCommonSubsequence {
	// 答题代码框架
	public int longestCommonSubsequence(String text1, String text2) {
		if(text1.length() == 0 || text2.length() == 0) return 0;
		int len1 = text1.length(), len2 = text2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for(int i = 1; i <= len1; i ++) {
			for(int j = 1; j <= len2; j ++) {
				if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[len1][len2];
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_1143_longestCommonSubsequence solution = new _1143_longestCommonSubsequence();
    		System.out.println("测试结果：" + solution.longestCommonSubsequence("ezupkr", "ubmrapg"));
	}
}
