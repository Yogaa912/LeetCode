package leetcode;
import java.util.*;

public class _6_zigzagConversion {
	public String convert(String s, int numRows) {
		List<StringBuilder> rows = new ArrayList<>();
		for(int i = 0; i < numRows; i ++) rows.add(new StringBuilder());
		int i = 0, flag = -1;
		for(char c : s.toCharArray()) {
			rows.get(i).append(c);
			if(i == 0 || i == numRows - 1) flag = - flag;
			i += flag;
		}
		StringBuilder res = new StringBuilder();
		for(StringBuilder row : rows) res.append(row);
		return res.toString();
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_6_zigzagConversion solution = new _6_zigzagConversion();
		System.out.println("测试结果：" + solution.convert("PAYPALISHIRING", 5));
	}
}
