public class CountBinarySubstring {
	public static int findSubstring(String s) {
		int len = s.length();
		int[] group = new int[len];
		int t = 0;
		int count = 0;
		group[0] = 1;
		for(int i = 1; i < s.length(); i ++) {
			if(s.charAt(i) == s.charAt(i - 1)) {
				group[t] ++;
			} else {
				t ++;
				group[t] = 1;
			}
		}
		for(int i = 1; i <= t; i ++) {
			count += Math.min(group[i], group[i - 1]);
		}
        return count;
	}
	public static void main(String[] args) {
		String s = "0110001111";
        System.out.println("Count of valid substrings: " + findSubstring(s)); // Output: 6
	}
}
/**
 * "0110001111"
 * grouping strategy
 * 分成若干组，每个相邻组，谁比较小，那么count加上谁
 */