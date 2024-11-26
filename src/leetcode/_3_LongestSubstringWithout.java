package leetcode;
import java.util.*;

public class _3_LongestSubstringWithout {
	public static int lengthOfLongestSubstring0(String s) {
		/**
		 * 把String转化成char[]，或者直接用s.charAt(index)
		 * subString
		 * 准备一个HashMap储存
		 */ 
		Map<Character, Integer> list = new HashMap<>();
		int left = 0;
		int max = 0;
		for(int right = 0; right < s.length(); right ++) {
			while(list.containsKey(s.charAt(right)) && left < right) {
				max = Math.max(right - left, max);  // s.substring(left, right);
				list.remove(s.charAt(left));
				left ++;
			}
			list.put(s.charAt(right), 1); // 不需要list.get(s.charAt(right)) + 1，因为只要存在了就直接移动了
			max = Math.max(list.size(), max);
		}
		return max;
    }
	public static int lengthOfLongestSubstring(String s) {
	    Map<Character, Integer> map = new HashMap<>();
	    int left = 0;
	    int max = 0;
	    for (int right = 0; right < s.length(); right++) {
	        char currentChar = s.charAt(right);
	        // 如果字符已经存在于窗口中，移动左指针到重复字符的下一位置
	        if (map.containsKey(currentChar)) {
	            left = Math.max(left, map.get(currentChar) + 1);
	        }
	        // 更新字符的最新位置
	        map.put(currentChar, right);	        
	        // 计算并更新最大长度
	        max = Math.max(max, right - left + 1);
	    }
	    return max;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(""));
	}
} 
/**
 * 优化 while 循环：在你的实现中，每次遇到重复字符时都会进入 while 循环。可以通过直接更新 left 指针的方式来优化判断。
 * 去掉 list.size() 的计算：list.size() 的作用是计算窗口的大小，但实际上窗口大小可以直接通过 right - left + 1 来计算。
 * 哈希表的值可以省略：在这个问题中，Map<Character, Integer> 中的 Integer 值可以用来记录字符上一次出现的位置，从而简化代码逻辑。
 */