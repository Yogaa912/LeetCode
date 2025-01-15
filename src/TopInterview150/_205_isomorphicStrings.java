package TopInterview150;
import java.util.*;

public class _205_isomorphicStrings {
	/**
	 *  
	示例 1:
	
	输入：s = "egg", t = "add"
	输出：true
	示例 2：
	
	输入：s = "foo", t = "bar"
	输出：false
	 * */
	public boolean isIsomorphic1(String s, String t) {
        if(s.length() == 1) return true;
		HashMap<Character, Character> map = new HashMap<>();
		// 如果是26个字母，int[26] 存储出现过的
		int[] appear = new int[26];
		for(int i = 0; i < s.length(); i ++) {
			System.out.println(s.charAt(i)+ "和" +t.charAt(i));
			if(!map.containsKey(s.charAt(i))) {
				if(appear[t.charAt(i) - 'a'] == 0) {
					map.put(s.charAt(i), t.charAt(i));
				} else {
	 				return false;
				}
			} else {
				if(map.get(s.charAt(i)) != t.charAt(i)) return false;
			}
			appear[t.charAt(i) - 'a'] = 1;
		}
		return true;
    }
	public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            if(s2t.containsKey(s.charAt(i))) {
                if(!t2s.containsKey(t.charAt(i)) || s2t.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if(t2s.containsKey(t.charAt(i))) {
                    return false;
                } else {
                    s2t.put(s.charAt(i), t.charAt(i));
                    t2s.put(t.charAt(i), s.charAt(i));
                }
            }
        }
        return true;
    }
	public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_205_isomorphicStrings solution = new _205_isomorphicStrings();
    	System.out.println("测试结果：" + solution.isIsomorphic("egg", "add"));
    	System.out.println("测试结果：" + solution.isIsomorphic("foo", "bar"));
	}
}
/**
 * 一对一映射：
 * - 单向映射
 * - 双向约束：要确保一对一映射的关系，我们需要同时检查两个方向的约束
 * 
 */