package leetcode;
public class _122_bestTimeToBuyAndSellStockII {
	public int maxProfit0(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2]; // 截止到第几天，然后目前的状态是：0 cash 1 stock
        if(len < 2) return 0;
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i ++) {
        	dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        	dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        	// 第i天时候处于无股票状态：可能是上一天就没买，或者是上一天买入今天卖出
        	// 第i天时候处于有股票状态：可能是上一天买了今天继续持有，或者是上一天没有今天买入
        }
        return dp[len - 1][0];
    }
	public int maxProfit1(int[] prices) {
        int len = prices.length;
        int cash = 0;
        int hold = -prices[0];
        int preCash = cash;
        int preHold = hold;
        if(len < 2) return 0;
        for(int i = 1; i < len; i ++) {
        	// 把原本的int[][]换成int
        	cash = Math.max(preCash, preHold + prices[i]);
        	hold = Math.max(preHold, preCash - prices[i]);
        	preCash = cash;
        	preHold = hold;
        }
        return cash;
    }
	// 贪心算法
	public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_122_bestTimeToBuyAndSellStockII solution = new _122_bestTimeToBuyAndSellStockII();
		System.out.println("测试结果：" + solution.maxProfit(new int[] {7,1,5,3,6,4}));
	}
}
/**
 * 1. 定义状态
 * dp[i][j]截止到i这一天，持股状态为j，0 cash 1 stock
 * 2. 思考状态转移方程
 * 每一天可以0 - 1或者1 - 0，也可以不动
 * 最后一天直接输出状态为0的数值
 * 3. 确定初始值
 * 一开始如果不买 dp[0][0] = 0
 * 如果持有股票 dp[0][1] = -prices[i];
 * 4. 确定输出值
 * 终止的时候输出 dp[len - 1][0]，肯定得卖了
 * 
 * time complexity: O(N) N = prices.length
 * Space complexity: O(N) 
 * 
 * 本质上本次数值只参考上一次数值变化
 * 所以可以使用滚动数组技巧
 * 
 */