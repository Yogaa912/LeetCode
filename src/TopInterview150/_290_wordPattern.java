package TopInterview150;
import java.util.*;

public class _290_wordPattern {
	// 答题代码框架
	public boolean wordPattern(String pattern, String s) {
    	String[] words = s.split(" ");
    	if(words.length != pattern.length()) return false;
    	int len = words.length;
    	Map<Character, String> p2s = new HashMap<>();
    	Map<String, Character> s2p = new HashMap<>();
    	for(int i = 0; i < len; i ++) {
    		char pChar = pattern.charAt(i);
    		String sWord = words[i];
    		System.out.println(pChar + " " +sWord);
    		if((p2s.containsKey(pChar) && !p2s.get(pChar).equals(sWord)) || (!p2s.containsKey(pChar) && s2p.containsKey(sWord))) {
    			return false;
    		} else {
    			p2s.put(pChar, sWord);
    			s2p.put(sWord, pChar);
    		}
    	}
		return true;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_290_wordPattern solution = new _290_wordPattern();
		String pattern = "abba", s = "dog cat cat dog";
		System.out.println("测试结果：" + solution.wordPattern(pattern, s));
	}
}
