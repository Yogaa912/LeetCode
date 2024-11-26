package leetcode;
public class _134_gasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(gas == null || cost == null || n == 0) return -1;
        // drive from 0, cost[0]
        
        for(int i = 0; i < n; i ++) {
            if(gas[i] >= cost[i]) {
                if(isValid(i, gas, cost)) {
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean isValid (int start, int[] gas, int[] cost) {
        // car have xx gas at station i
        int n = gas.length;
        int[] carGas = new int[n];
        carGas[start] = gas[start];
        for(int i = start + 1; i <= start + gas.length; i ++) {
            carGas[i % n] = carGas[(i - 1) % n] - cost[(i - 1) % n];
            if(carGas[i % n] < 0) {
                return false;
            }
            carGas[i % n] += gas[i % n];
        }
        return true;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		int[] gas = new int[] {1,2,3,4,5};
		int[] cost = new int[] {3,4,5,1,2};
		_134_gasStation solution = new _134_gasStation();
//		System.out.println("测试结果：" + solution.canCompleteCircuit(gas, cost));
		System.out.println("测试结果：" + solution.canCompleteCircuit(new int[] {2}, new int[] {2}));
//		System.out.println("测试结果：" + solution.canCompleteCircuit(new int[] {4,5,3,1,4}, new int[] {5,4,3,4,2}));
	}
}
