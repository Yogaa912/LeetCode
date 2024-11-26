import java.util.*;

public class deleteString {
	public static String modifyString(String s) {
		if(s == null || s.length() == 0) return "";
		int len = s.length();
		// 统计字符出现的频率，判断是不是可以删除
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < len; i ++) {
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);
		}
		// 初始化栈和已使用的字符
		System.out.println(map);
		Deque<Character> stack = new ArrayDeque<>();
		Set<Character> used = new HashSet<>();
		for(int i = 0; i < len; i ++) {
			// 从map里面去掉
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) - 1);
			// 如果使用过，就直接去掉
			if(used.contains(s.charAt(i))) {
				continue;
			}
			// stack不为0，stack
			while(!stack.isEmpty() && stack.peek() < s.charAt(i) && map.get(stack.peek()) > 0) {
				char removed = stack.pop();
				used.remove(removed);
			}
			stack.push(s.charAt(i));
			used.add(s.charAt(i));
		}
		StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
	}
	public static void main(String[] args) {
		String s = "abcdc";
        System.out.println("Count of valid substrings: " + modifyString(s)); // Output: 6
	}
}
