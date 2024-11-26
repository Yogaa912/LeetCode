package leetcode;
public class _58_lengthOfLastWord {
	public int lengthOfLastWord0(String s) {
        String[] word = s.split(" ");
        int len = word.length;
        return word[len - 1].length();
    }
	public int lengthOfLastWord1(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end --;
        if(end < 0) return 0;

        for(int i = end; i >= 0; i --) {
            char c = s.charAt(i);
            if(c == ' ') {
                String res = s.substring(i + 1, end);
                return end - i;
            }
        }
        return end + 1;
    }
	public int lengthOfLastWord(String s) {
        int len = s.length();
        int end = len - 1;
        while(end >= 0 && s.charAt(end) == ' ') end --;
        int stop = end;
        if(end < 0) return 0;
        while(end >= 0 && s.charAt(end) != ' ') end --;
        return stop - end;
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_58_lengthOfLastWord solution = new _58_lengthOfLastWord();
		System.out.println("测试结果：" + solution.lengthOfLastWord("   fly me   to   the moon  "));
	}
}
