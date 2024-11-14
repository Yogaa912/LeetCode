public class _518_coinChangeII {
	// 答题代码框架
	public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // 凑成 0 的组合数是 1（不使用任何硬币）

        for (int coin : coins) { // 遍历每个硬币
            for (int i = coin; i <= amount; i++) {
            	System.out.println(dp[i - coin]);
                dp[i] += dp[i - coin]; // 状态转移
            }
        }
        return dp[amount];
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_518_coinChangeII solution = new _518_coinChangeII();
    		System.out.println("测试结果：" + solution.change(5, new int[] {1,2,5}));
	}
}
/**
 * 先遍历金额的弊端：先遍历 i 表示对于每个金额，我们逐步尝试每种硬币，这会导致同一金额的不同组合顺序被分别计算。例如在金额 i = 3 时，[1,1,2] 和 [2,1,1] 就会分别计算。
 * 在这道完全背包问题中，关键是遍历顺序：我们先遍历每种硬币 coin，再对每个金额 i 更新 dp[i]。这确保了在更新 dp[i] 时，只考虑当前和之前的硬币组合，不会重复计算相同组合。
 * 具体来说：
 * 先遍历硬币 coin：
 * 这一层遍历每次固定了一种面额的硬币。比如在 coin = 1 的第一轮中，我们仅使用面值 1 的硬币去更新 dp 数组。
 * 到 coin = 2 时，已经记录了只使用 1 元硬币来凑的所有组合数，这时我们将 2 元硬币的组合加入 dp 数组，以此类推。
 * 然后遍历每个金额 i：
 * 对于每个金额 i，用 dp[i - coin] 的组合数来更新 dp[i]，表示用当前硬币 coin 继续凑出金额 i 的新组合。
 * 具体过程：
 * 例如，对于 dp[3] 来说，当我们用 1 元硬币时，dp[3] 会更新为“用 1 元硬币组合凑出金额 3”的所有方式。
 * 当轮到 2 元硬币时，dp[3] 会进一步更新为“使用 1 元硬币和 2 元硬币组合”来凑出金额 3 的所有方式。
 * 第一轮（coin = 1）：
 * dp[1] += dp[1 - 1] = dp[1] + dp[0] → dp[1] = 1
 * dp[2] += dp[2 - 1] = dp[2] + dp[1] → dp[2] = 1
 * dp[3] += dp[3 - 1] = dp[3] + dp[2] → dp[3] = 1
 * 此时 dp = [1, 1, 1, 1]，即只使用 1 元硬币的组合数。
 * 第二轮（coin = 2）：
 * dp[2] += dp[2 - 2] = dp[2] + dp[0] → dp[2] = 2
 * dp[3] += dp[3 - 2] = dp[3] + dp[1] → dp[3] = 2
 * 最终 dp = [1, 1, 2, 2]，即凑出金额 3 的所有组合数。
 * 
 * 1. f(i)=min(g(f(i−coin1),f(i−coin2),...,f(i−coink))
 * 2. 在完全背包问题中，先遍历物品再遍历容量是最佳选择
 * */

