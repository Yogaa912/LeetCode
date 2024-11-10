import java.util.*;

/**
 * 描述：找到包含 t 中所有字符的最小窗口子串。
 * 技巧：使用滑动窗口扩大或收缩窗口，找到包含 t 所有字符的最小子串。
 * 滑动窗口本质上是长度固定，收缩或者夸大窗口的条件需要单独罗列
 * */
public class _76_MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		if(t.length() > s.length()) return "";
		Map<Character,Integer> map = new HashMap<>();
		Map<Character,Integer> require = new HashMap<>();
		// 记录t中元素的频率
		for(char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c,0) + 1);
		}
		System.out.println("map is " + map);
		int left = 0, right = 0;
		int count = 0;
		int[] result = {0,s.length() + 1}; // 设置一开始的最长长度
		while(right < s.length()) {
			// 增加right
			char curr = s.charAt(right);
			System.out.println("now curr is " + curr);
			if(map.containsKey(curr)) {
				require.put(curr, require.getOrDefault(curr, 0) + 1);
				// 检查频率是否对应
				if(map.get(curr).equals(require.get(curr))) count ++;
				System.out.println("add to require" + require + " and count is " + count);
			}
			right ++;
			System.out.println("right is " + right);
			// right增加完了之后呢，当窗口内所有字符频率都达到要求，调整left的
			while(count == map.size()) {
				// 减小窗口
				System.out.println("success " + (right - left));
				if(right - left < result[1] - result[0]) {
					result[0] = left;
					result[1] = right;
					System.out.println("result now is " + s.substring(result[0],result[1]));
				}
				// 减少left
				char leftChar = s.charAt(left);
				System.out.println("left is " + leftChar);
				if(map.containsKey(leftChar)) {
					if(map.get(leftChar).equals(require.get(leftChar))) count --;
					require.put(leftChar, require.getOrDefault(leftChar, 0) -1);
					if(require.get(leftChar) == 0) require.remove(leftChar);
					System.out.println("require cut " + require);
				}
				left ++;
			}
		}
		if(result[1] == s.length() + 1) return "";
		return s.substring(result[0],result[1]);
    }
	public static void main(String[] args) {
		System.out.println(minWindow("acbbaca","aba")); //baca
		System.out.println(minWindow("ab","b"));
	}
}
/**
 * 注意边界条件，比如t长度大于s；"a","a";还有完全不存在等等情况
 */
