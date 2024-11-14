import java.util.*;
/**
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，
 * 所以返回答案 对 10^9 + 7 取模 后的值。
 * 
 * 思路
 * 第k个能被a或b整除的数字，最大是？，最小是min(a,b)
 * 最大max(a,b)*n
 * 找到mid = min + (max - min)/2;
 * check mid符合条件，符合就缩小，不符合就去另一边
 * 条件：是第k个，可以被a||b整除
 * 假设 mid 是答案的候选值，然后计算 mid 以下的神奇数字个数
 * 先假设一个可能的结果并验证它是否满足条件
 * */
public class _878_NthMagicalNumber {
	// 答题代码框架
	public int nthMagicalNumber(int n, int a, int b) {
		// 结果二分法
		int MOD = 1_000_000_007;
		int min = 1, max = Math.min(a, b)*n, mid = 0, re = 0;
		if (a == b) {
            return (int) ((long) a * n % MOD);
        }
		while(min <= max) {
			mid = min + (max - min)/2;
			if(isValid(n, a, b, mid)) {
				re = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		// 过大的时候取模
		return (int) (re % MOD);
	}
	private boolean isValid(int n, int a, int b, int mid) {
		// 1到mid这个范围里的数字是否满足n个
		long count = 0;
		count = mid/a + mid/b - mid/(lcm(a,b));
		return (count >= n);
	}
	// 求最小公倍数 (lcm)
	private long lcm(int a, int b) {
        return (long) a * (b / gcd(a, b));
    }
    // 求最大公约数 (gcd)
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
	public int check(int n, int a, int b) {
		int re = 0;
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 1; i <= n; i ++) {
			set.add(a*i);
			set.add(b*i);
		}
		for(int i = 0; i < n; i ++) {
			re = set.pollFirst();
		}
		return re;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_878_NthMagicalNumber solution = new _878_NthMagicalNumber();
		System.out.println(solution.check(4, 2, 3));
		System.out.println("测试结果：" + solution.nthMagicalNumber(1000000000,40000,40000)); // 2
		// 1.2;2.3;3.4;4.6;5.8;6.9......
		System.out.println("测试结果：" + solution.nthMagicalNumber(4,2,3)); // 6
	}
}
