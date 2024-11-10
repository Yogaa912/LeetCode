public class _125_ValidPalindrome {
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		char[] ns = s.toLowerCase().toCharArray();
		int left = 0;
		int right = ns.length - 1;
		while(left < right) {
			if(ns[left] != ns[right]) return false;
			left ++;
			right --;
		}
		return true;
    }
	public static boolean isPalindrome2(String s) {
		int left = 0;
		int right = s.length() - 1;
		while(left < right) {
			while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left ++;
			while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right --;
			if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false; // 在比较的时候进行大小写转换
			left ++;
			right --;
		}
		return true;
    }
	public static void main(String[] args) {
		isPalindrome("A man, a plan, a canal: Panama");
	}
}
/**
 * 首先读题，是去掉字符，还是去掉数字
 * 其次是去掉字符，s = s.replaceAll("[^a-zA-Z0-9]","");
 * String直接转化成char[],toCharArray();
 */
