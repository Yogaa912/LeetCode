public class _424_LongestRepeatingCharacterReplacement {
	public int characterReplacement0(String s, int k) {
        int[] freq = new int[26];  // To store frequency of each character in the current window
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update the frequency of the current character
            freq[s.charAt(right) - 'A']++;
            // Find the max frequency character in the current window
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            // Check if we need to shrink the window
            if ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;  // Remove the leftmost character from the window
                left++;  // Move the left boundary of the window
            }

            // Calculate the max length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
	}
	public int characterReplacement(String s, int k) {
		int maxCount = 0, left = 0, result = 0;
		int[] freq = new int[26]; // store frequency
		// freq[s.charAt(i) - 'A']
		for(int i = 0; i < s.length(); i ++) {
			freq[s.charAt(i) - 'A'] ++;
			maxCount = Math.max(maxCount, freq[s.charAt(i) - 'A']);
			if((i - left + 1 - maxCount) > k) {
				freq[s.charAt(i) - 'A'] --;
				left ++;
			}
			result = Math.max(result, i - left + 1);
		}
		return result;
	}
	public static void main(String[] args) {
		_424_LongestRepeatingCharacterReplacement solution = new _424_LongestRepeatingCharacterReplacement();
		System.out.println(solution.characterReplacement("AABABBA", 1)); // 5
		System.out.println(solution.characterReplacement("AABABBA", 1)); // 5
	}
}
/**
 * 这道题的主要思路是将一路上遇到的char的频率用最节省的方式记下来
 * 然后记住频率最大的char的频率，这就是我们要去修改为的目标，
 * 当这一段窗口内的数量 - maxCount就是窗口内待修改的char，如果这个数字大于k，就修改不成功了，就只能收缩left，一次只收缩一个
 * 
 * 1. 理解题目需求和条件
 * 题目要求找出字符串中最长的重复字符子串，允许最多进行 k 次字符替换。
 * 这类题目通常要求找到一个“最长的子串”，并且涉及替换的操作。这会提示我们可以考虑用“滑动窗口”这种动态调整窗口大小的方式。
 * 2. 识别可行的算法策略
 * 面对“最长子串”或“最小子串”这类题型，常用的策略是滑动窗口，因为它可以高效地找到一段连续区间内的最佳解。
 * 替换操作的限制（最多替换 k 次）表明，我们在窗口内允许一定的变化。这进一步提示我们可以在窗口内尝试记录最多的某个字符出现的次数，以此减少替换次数。
 * 3. 考虑具体的实现细节
 * 我们可以记录窗口中出现频率最高的字符。为什么？因为这样可以在窗口内只替换少量其他字符，就能使整个窗口内的字符都相同。
 * 每次增加窗口右边界时，计算当前窗口中最大频率的字符，看看在 k 次替换限制下，能否扩大窗口。
 * 4. 分解问题，尝试边界测试
 * 想象一下具体的例子，例如 "AABABBA" 和 k = 1，通过手动滑动窗口，你会发现只要知道窗口内的最大频率字符，就可以判断是否需要调整窗口边界。
 * 在这种模拟过程中，你会逐渐明白“滑动窗口 + 频率记录”可以简化计算，帮助找到最大长度。
 * 初次接触的思维难点
 * 初次接触时，要想到这种解法确实不容易，因为它要求：
 * 对滑动窗口的熟悉：能意识到用窗口来记录一个区间的属性。
 * 频率最大化的思路：直观上，我们会尝试直接替换字符，而不是找“最大频率的字符”。
 * 动态调整窗口的条件：很多人初次会在“何时收缩窗口”上犯迷糊。其实，这个问题的关键在于理解“窗口长度 - 最大频率字符 <= k”这一逻辑。
 */