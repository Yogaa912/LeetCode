import java.util.*;
public class _322_CoinChange {
	// 答题代码框架
	public int coinChange(int[] coins, int amount) {
		if (coins.length <= 0) return -1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0]= 0;
		for (int i = 1; i <= amount; i ++) {
			for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
		}
		for(int i : dp) System.out.println(i);
		return dp[amount] > amount ? -1 : dp[amount];
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_322_CoinChange solution = new _322_CoinChange();
    	System.out.println("测试结果：" + solution.coinChange(
    			new int[] {2}, 3)); // 4
	}
}
