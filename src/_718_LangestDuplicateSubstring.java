public class _718_LangestDuplicateSubstring {
	public static int findLength(int[] nums1, int[] nums2) {
		int output = 0;
		int[][] dp = new int[nums1.length + 1][nums2.length + 1];
		for(int i = 1; i <= nums1.length; i ++) {
			for(int j = 1; j <= nums2.length; j ++) {
				if(nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					System.out.println("i: " + i + " j: " + j + " dp[i - 1][j - 1] " + dp[i - 1][j - 1] + " dp[i][j] " + dp[i][j]);
					output = Math.max(output, dp[i][j]);
				}
			}
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(findLength(new int[] {1,2,3,2,1}, new int[] {3,2,1,4,7}));
		System.out.println(findLength(new int[] {1,1,1,1,1}, new int[] {1,1,1,1,1}));
		System.out.println(findLength(new int[] {0,1,1,1,0}, new int[] {1,1,1,1,1}));
	}
}
/**
 * 应该使用动态规划 dynamic programming
 * define dp, dp[i][j] 表示以 nums1[i-1] 和 nums2[j-1] 结尾的最长公共子数组的长度。
 * 1. 当 nums1[i-1] == nums2[j-1] 时，dp[i][j] = dp[i-1][j-1] + 1。
 * 2. 否则，dp[i][j] = 0。
 * 3. 在过程中更新 output 变量，用来存储最长公共子数组的长度。
 * 所以动态规划的思想主要是把目标变成一个xy轴共同构成的表格，就好像九九乘法表一样
 * dp还适用于：
 * 1. 问题可以分解成多个子问题，且原问题的最优解可以由子问题的最优解推导得到。
 */