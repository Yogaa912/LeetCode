package leetcode;
public class _28_findIndexFirstOccurrence {
	public int strStr0(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0) return -1;
        if(needle == null || needle.length() == 0) return 0;
        int len = haystack.length();
        int res = -1;
        int flag = 1;
        for(int i = 0; i < len; i ++) {
            char c = haystack.charAt(i);
            if(c == needle.charAt(0)) {
                for(int j = 1; j < needle.length(); j ++) {
                    if(i + j >= len || haystack.charAt(i + j) != needle.charAt(j)) {
                    	flag = 0;
                    	break;
                    }
                    flag = 1;
                }
                res = (flag == 1) ? i : -1;
                if(flag == 1) return res;
            }
        }
        return res;
    }
	public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0) return -1;
        if(needle == null || needle.length() == 0) return 0;
        int len = haystack.length();
        int len2 = needle.length();
        for(int i = 0; i <= len - len2; i ++) {
            int j = 0;
            while(j < len2 && haystack.charAt(i + j) == needle.charAt(j)) {
                j ++;
            }
            if(j == len2) return i;
        }
        return -1;
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_28_findIndexFirstOccurrence solution = new _28_findIndexFirstOccurrence();
//		System.out.println("测试结果：" + solution.strStr("leetcode", "leeto"));
		System.out.println("测试结果：" + solution.strStr("mississippi", "issip"));
	}
}
