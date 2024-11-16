import java.util.*;

public class _20_validParentheses {
	// 答题代码框架
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')','(');
		map.put(']','[');
		map.put('}','{');
		Deque<Character> stack = new ArrayDeque<>();
		for(int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				if(stack.pollLast() != map.get(c)) {
					return false;
				}
			} else {
				stack.addLast(c);
			}
		}
    	return stack.isEmpty();
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_20_validParentheses solution = new _20_validParentheses();
    		System.out.println("测试结果：" + solution.isValid("(]"));
	}
}
