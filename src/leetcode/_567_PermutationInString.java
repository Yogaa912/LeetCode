package leetcode;
import java.util.*;

public class _567_PermutationInString {
    public static boolean checkInclusion0(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // 目标字符串的字符频率表
        Map<Character, Integer> dic = new HashMap<>();
        for (char c : s1.toCharArray()) {
            dic.put(c, dic.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < s2.length(); right++) {
            char curr = s2.charAt(right);

            // 当前字符在目标中
            if (dic.containsKey(curr)) {
                freq.put(curr, freq.getOrDefault(curr, 0) + 1);

                if (freq.get(curr).equals(dic.get(curr))) {
                    count++;
                }
            }

            // 如果窗口大小超过 s1.length()，调整左指针
            if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);

                if (dic.containsKey(leftChar)) {
                    if (freq.get(leftChar).equals(dic.get(leftChar))) {
                        count--;
                    }
                    freq.put(leftChar, freq.get(leftChar) - 1);
                }
                left++;
            }

            // 如果匹配的字符数量等于目标字典大小，则找到排列
            if (count == dic.size()) {
                return true;
            }
        }

        return false;
    }
    public static boolean checkInclusion(String s1, String s2) {
    	if(s1.length() > s2.length()) return false;
    	int left = 0, count = 0;
    	Map<Character,Integer> s1map = new HashMap<>();
    	Map<Character,Integer> s2map = new HashMap<>();
    	for(char c : s1.toCharArray()) {
    		s1map.put(c, s1map.getOrDefault(c, 0) + 1);
    	}
    	for(int right = 0; right < s2.length(); right ++) {
    		char curr = s2.charAt(right);
    		if(s1map.containsKey(curr)) {
    			s2map.put(curr, s2map.getOrDefault(curr, 0) + 1);
    			if(s1map.get(curr) == s2map.get(curr)) count ++;
    		}
    		if(right - left + 1 > s1.length()) {
    			char leftChar = s2.charAt(left);
    			if(s1map.containsKey(leftChar)) {
    				// 把leftChar从之前的记录里面删除
    				if(s1map.get(leftChar).equals(s2map.get(leftChar))) count --; // count的操作部分
					s2map.put(leftChar, s2map.get(leftChar) - 1);
					if(s2map.get(leftChar) == 0) s2map.remove(leftChar);
    			}
    			left ++;
    		}
    		if(count == s1map.size()) return true; // 检查部分
    	}
    	return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("hello", "ooolleoooleh")); // false
        System.out.println(checkInclusion("ab", "eidboaoo"));         // false
        System.out.println(checkInclusion("b", "ba"));               // true
    }
}

/**
 * 改进建议
 * 使用固定大小窗口：由于目标字符串 s1 的长度是固定的 s1.length()，
 * 我们可以直接在窗口长度大于 s1.length() 时移动 left 指针，而不需要在 while 循环中频繁检查和移动 left。
 * 简化逻辑：代码中 count 的更新逻辑稍显复杂，可以优化判断条件，使代码更简洁。
 * 当字符不匹配时不重置窗口：如果当前字符不在 dic 中，可以直接将窗口右移，不需要从头再来，这样可以提高效率。
 * */