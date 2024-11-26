package leetcode;
public class _14_longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) return "";
		String ans = strs[0];
		for(int i = 1; i < strs.length; i ++) {
			int j = 0;
			for(; j < strs[i].length(); j ++) {
				if(ans.charAt(j) != strs[i].charAt(j)) break;
			}
			ans = ans.substring(0, j);
			if(ans == "") return "";
		}
		return ans;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_14_longestCommonPrefix solution = new _14_longestCommonPrefix();
		System.out.println("测试结果：" + solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));
	}
}
