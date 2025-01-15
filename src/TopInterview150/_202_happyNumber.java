package TopInterview150;
import java.util.*;

public class _202_happyNumber {
	// 答题代码框架
	public boolean isHappy1(int n) {
    	// 正整数19，每一次替换成为 1^2 + 9^2 = 82;
		Set<Integer> set = new HashSet<>();
		int a = n;
		while(a != 1) {
			List<Integer> list = new ArrayList<>();
			while(a > 9) {
				list.add(a % 10);
				a = a / 10;
			}
			System.out.println(a);
			System.out.println(list);
			a *= a;
			for(int i : list) {
				a += i * i;
			}
			System.out.println(a);
			if(set.contains(a)) {
				return false;
			} else {
				set.add(a);
			}
		}
		return true;
	}
	public int bitSquareSum(int n) {
		// 这一步是除余然后相乘构成新数
		int sum = 0;
		while(n > 0) {
			int bit = n % 10;
			sum += bit * bit;
			n = n / 10;
		}
		return sum;
	}
	public boolean isHappy(int n) {
		int fast = n, slow = n;
		do{
			slow = bitSquareSum(slow); // 慢指针
            fast = bitSquareSum(fast); // 快指针
            fast = bitSquareSum(fast);
            System.out.println(slow + " " + fast);
		} while (slow != fast); // 相等的时候就说明重复了
		return slow == 1; // 看最后能否来到1
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_202_happyNumber solution = new _202_happyNumber();
		int n = 2;
		System.out.println("测试结果：" + solution.isHappy(n));
	}
}
/**
 * 确实这道题给人一种似曾相识的感觉，有点像快慢指针
 * 跟快慢指针相似的地方，一直循环，直到来到之前来过的地方
 * “快指针” 每次走两步，“慢指针” 每次走一步，当二者相等时，即为一个循环周期
 */