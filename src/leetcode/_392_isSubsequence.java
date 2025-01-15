package leetcode;
public class _392_isSubsequence {
	public boolean isSubsequence0(String s, String t) {
        if(t == null || t.length() == 0) return false;
        if(s == null || s.length() == 0) return true;
        int j = 0;
        for(int i = 0; i < s.length(); i ++) {
            if(j < t.length() && s.charAt(i) == t.charAt(j)) {
                j ++;
                if(i == s.length() - 1) return true;
                continue;
            } else {
                while(j < t.length() && s.charAt(i) != t.charAt(j)) {
                    j ++;
                }
                if(j < t.length() && s.charAt(i) == t.charAt(j)) {
                    j ++;
                    if(i == s.length() - 1) return true;
                    continue;
                }
            }  
        }
        return false;
    }
	public boolean isSubsequence(String s, String t) {
		// 这两行的前后顺序有意义，因为只要是s为0，那么t为0也一样是true，只有当s不为0但是t为0才是false
		if(s == null || s.length() == 0) return true;
		if(t == null || t.length() == 0) return false;
        
		int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i ++;
            } 
            j ++; // 不论发生什么情况都是 j ++;
        }
        return i == s.length(); // 如果s的指针来到了末尾，说明s都匹配到位了
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_392_isSubsequence solution = new _392_isSubsequence();
		System.out.println("测试结果：" + solution.isSubsequence("abc", "ahbgdc"));
	}
}
