package leetcode;
import java.util.*;

public class _438_FindAllAnagrams {
	public static List<Integer> findAnagrams0(String s, String p) {
		// 滑动窗口，寻找元素相同的substring
		int left = 0;
		List<Integer> result = new ArrayList<>();
		Map<Character,Integer> list = new HashMap<>();
		Map<Character,Integer> list2 = new HashMap<>();
		for(char c : p.toCharArray()) {
			list2.put(c, list2.getOrDefault(c,0) + 1);
		}
		System.out.println(list2);
		for(int right = 0; right < s.length(); right ++) {
			if(!list2.containsKey(s.charAt(right))) {
				left = right + 1;
				list.clear();
				System.out.println("skip");
				continue;
			}
			// 添加当前字符到窗口计数器中
			list.put(s.charAt(right), list.getOrDefault(s.charAt(right),0) + 1); // 存储substring
			System.out.println("添加完 " + list);
			// 如果窗口长度超过 p 的长度，调整左指针
			if(right - left + 1 > p.length()) {
				char leftChar = s.charAt(left);
				list.put(leftChar, list.get(leftChar) - 1); // 如果减到0
				if(list.get(leftChar) == 0) {
					list.remove(leftChar);
				}
			}
			System.out.println(list);
			// 如果频率超过了
			while(list.get(s.charAt(right)) > list2.get(s.charAt(right))) {
				System.out.println("进入删除模式， right = " + right);
				list.put(s.charAt(left), list.get(s.charAt(left)) - 1); // 如果减到0
				if(list.get(s.charAt(left)) == 0) {
					list.remove(s.charAt(left));
				}
				left ++;
				System.out.println(list);
			}
			if(list.equals(list2)) {
				result.add(left);
				System.out.println("success");
				list.put(s.charAt(left), list.get(s.charAt(left)) - 1); // 如果减到0
				if(list.get(s.charAt(left)) == 0) {
					list.remove(s.charAt(left));
				}
				left ++;
			}
		}
		return result;
    }
	public static List<Integer> findAnagrams(String s, String p) {
	    List<Integer> result = new ArrayList<>();
	    Map<Character, Integer> list2 = new HashMap<>();
	    // 初始化目标字符频率表
	    for (char c : p.toCharArray()) {
	        list2.put(c, list2.getOrDefault(c, 0) + 1);
	    }
	    Map<Character, Integer> list = new HashMap<>();
	    int left = 0, matchCount = 0; // 跟踪当前窗口中有多少字符频率符合 p 的要求
	    for (int right = 0; right < s.length(); right++) {
	        char currentChar = s.charAt(right);
	        // 更新当前字符频率
	        if (list2.containsKey(currentChar)) {
	            list.put(currentChar, list.getOrDefault(currentChar, 0) + 1);
	            // 当字符频率匹配时，增加 matchCount
	            if (list.get(currentChar).equals(list2.get(currentChar))) {
	                matchCount++;
	            }
	        }
	        // 确保窗口长度与 p 的长度一致
	        if (right - left + 1 > p.length()) {
	            char leftChar = s.charAt(left);
	            if (list2.containsKey(leftChar)) {
	                // 如果频率匹配，减少 matchCount
	                if (list.get(leftChar).equals(list2.get(leftChar))) {
	                    matchCount--;
	                }
	                // 减少窗口左端字符频率
	                list.put(leftChar, list.get(leftChar) - 1);
	                if (list.get(leftChar) == 0) {
	                    list.remove(leftChar);
	                }
	            }
	            left++;
	        }
	        // 如果 matchCount 等于 list2 的大小，说明找到一个异位词
	        if (matchCount == list2.size()) {
	            result.add(left);
	        }
	    }
	    return result;
	}
	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd","abc"));
		System.out.println(findAnagrams("abab","ab"));
		System.out.println(findAnagrams("abacbabc","abc"));
	}
}
/**
 * 当窗口内的某字符数量多了，该怎么检测到多这一点呢 √
 * 冗余的删除操作：在每次窗口调整时，你频繁地添加、删除字符，并对窗口进行 equals 判断。这种做法会导致重复计算。
 * 频繁的 equals 比较：list.equals(list2) 会逐个比较键值对，因此在 list 和 list2 大小相同时，直接比较可以避免不必要的计算。
 * 改进思路：
 * 使用一个计数器 matchCount 来跟踪当前窗口中有多少字符频率符合 p 的要求。这样可以避免频繁的 equals 判断。
 * 简化滑动窗口的调整逻辑，只在窗口大小超过 p 长度时调整左指针
 * 反思：
 * 1. 我感觉我的误区在于我使用了双指针而不是滑动窗口来解决问题，这导致了我left指针也在自由的移动，增加了很多运算量，实际上窗口可以是固定的，
 * 所以我只需要按照长度来调整left即可
 * 2. 在对比长度的时候我直接使用了equals，其实没必要，只需要把已经完成对比的频率count记下来
 */