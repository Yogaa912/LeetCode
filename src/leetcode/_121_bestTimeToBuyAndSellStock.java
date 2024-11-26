package leetcode;
public class _121_bestTimeToBuyAndSellStock {
	public int maxProfit0(int[] prices) {
        int max = 0;
        for(int i = 0 ; i < prices.length; i ++) {
            for(int j = i + 1; j < prices.length; j ++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
	public int maxProfit(int[] prices) {
        int max = 0, cost = Integer.MAX_VALUE;
        for(int price : prices) {
            cost = Math.min(cost, price);
            max = Math.max(max, price - cost);
        }
        return max;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_121_bestTimeToBuyAndSellStock solution = new _121_bestTimeToBuyAndSellStock();
    		System.out.println("测试结果：" + solution.maxProfit(new int[] {7,1,5,3,6,4}));
	}
}
// 10min