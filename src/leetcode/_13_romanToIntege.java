package leetcode;
import java.util.*;

public class _13_romanToIntege {
	public int romanToInt0(String s) {
        Map<String, Integer> map = new HashMap<>();
        if(s == null || s.length() == 0) return 0;
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int i = 0, ans = 0;
        while(i < s.length()) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i ++;
            }
        }
        return ans;
    }
	public int romanToInt(String s) {
		// 如果left < right 那么就减去left，否则就加上
		Map<String, Integer> map = new HashMap<>();	
		int n = s.length();
        if(s == null || s.length() == 0) return 0;
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int i = 0, ans = 0;
        while(i < n) {
        	if(i + 2 <= n && map.get(s.substring(i, i + 1)) < map.get(s.substring(i + 1, i + 2))) {
        		ans = ans - map.get(s.substring(i, i + 1)) + map.get(s.substring(i + 1, i + 2));
        		i += 2;
        	} else {
        		ans += map.get(s.substring(i, i + 1));
        		i ++;
        	}
        }
		return ans;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_13_romanToIntege solution = new _13_romanToIntege();
		System.out.println("测试结果：" + solution.romanToInt("MCMXCIV"));
	}
}
