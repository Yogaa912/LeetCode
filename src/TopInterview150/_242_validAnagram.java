package TopInterview150;
import java.util.*;

public class _242_validAnagram {
	// 答题代码框架
	public boolean isAnagram1(String s, String t) {
		Map<Character, Integer> dic = new HashMap<>();
    	int len = s.length();
    	if(t.length() != len) return false;
		for(int i = 0; i < len; i ++) {
			char sChar = s.charAt(i);
			System.out.println(sChar);
			if(dic.containsKey(sChar)) {
				dic.put(sChar, dic.get(sChar) + 1);
			} else {
				dic.put(sChar, 1);
			}
		}
		System.out.println("end");
		for(int i = 0; i < len; i ++) {
			char tChar = t.charAt(i);
			System.out.println(tChar);
			if(dic.containsKey(tChar)) {
				dic.put(tChar, dic.get(tChar) - 1);
				if(dic.get(tChar) == 0) dic.remove(tChar);
			} else {
				return false;
			}
		}
		return true;
	}
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_242_validAnagram solution = new _242_validAnagram();
		String s = "anagram", t = "nagaram";
		System.out.println("测试结果：" + solution.isAnagram(s, t));
		s = "rat"; t = "car";
		System.out.println("测试结果：" + solution.isAnagram(s, t));
	}
}
