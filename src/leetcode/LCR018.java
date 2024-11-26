package leetcode;

public class LCR018 {
	public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]+","");
        // "\\W+" \是转义，W是所有非单词字符，+是匹配多次
        // [^...]表示相反，[a-z0-9]表示只算数字和字母，+表示匹配多次
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
	public static void main(String[] args) {
    	// 测试样例
		System.out.println("测试结果：" + isPalindrome("ab_a"));
	}
}
