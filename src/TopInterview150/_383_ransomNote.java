package TopInterview150;
import java.util.HashMap;

public class _383_ransomNote {
	public boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character,Integer> dic = new HashMap<>();
        for(int i = 0; i < magazine.length(); i ++) {
        	if(dic.containsKey(magazine.charAt(i))) {
        		dic.put(magazine.charAt(i), dic.get(magazine.charAt(i)) + 1);
        	} else {
        		dic.put(magazine.charAt(i), 1);
        	}
        }
        for(int i = 0; i < ransomNote.length(); i ++) {
        	char tempChar = ransomNote.charAt(i);
        	if(dic.containsKey(tempChar)) {
        		dic.put(tempChar, dic.get(tempChar) - 1);
        		if(dic.get(tempChar) == 0) {
        			dic.remove(tempChar);
        		}
        	} else {
        		return false;
        	}
        }
		return true;
    }
	/**
	 * 题目要求使用字符串 magazine 中的字符来构建新的字符串 ransomNote
	 * 且ransomNote 中的每个字符只能使用一次，
	 * 只需要满足字符串 magazine 中的每个英文字母 (’a’-’z’) 的统计次数
	 * 都大于等于 ransomNote 中相同字母的统计次数即可。
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		if(magazine.length() > ransomNote.length()) return false;
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
		return true;
	}
}