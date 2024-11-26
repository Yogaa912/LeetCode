package leetcode;
import java.util.*;

public class _472_ConcatenatedWords {
	// 答题代码框架
	// 添加 dynamic programming -> 取代memo，因为现在的memo只能针对单个单词
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		if (words == null || words.length == 0) {
			return new ArrayList<>();
		}
	    List<String> result = new ArrayList<>();
		Set<String> wordSet = new HashSet<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            if (word.isEmpty()) continue;
            // 使用动态规划判断当前单词是否是连接词
            if (isConcatenated(word, wordSet)) {
                result.add(word);
            }
            // 将当前单词加入字典供后续使用
            wordSet.add(word);
        }
		return result;
	}
	private boolean isConcatenated(String word, Set<String> wordSet) {
		int len = word.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true; 
		// dp[i] 表示 word[0:i-1] 是否可以被分解
		// 如果 dp[j] 为 true 且 word[j:i] 在 wordSet 中，则 dp[i] 为 true
		for(int i = 1; i <= len; i ++) { // 外层循环：表示子字符串的终点
			for(int j = 0; j < i; j ++) { // 内层循环：表示子字符串的起点
				// 分割单词
				if (dp[j] && wordSet.contains(word.substring(j, i))) {
					 dp[i] = true;
		             break;
				 }
			}
		}
		return dp[len] && wordSet.size() > 0;
	}
	public List<String> findAllConcatenatedWordsInADict0(String[] words) {
		Set<String> wordSet = new HashSet<>();
		for(String s : words)  wordSet.add(s);
		System.out.println(wordSet);
		Map<String, Integer> memo = new HashMap<>();;
		List<String> result = new ArrayList<>();
	    for(String word : words) {
	        if (canForm(word, wordSet, memo, true)) {
	            result.add(word);
	        }
	    }
		return result;
		// 这里编写答题代码
	}
	private boolean canForm(String word, Set<String> wordSet, Map<String, Integer> memo, boolean is_original_word) {
		if(wordSet.contains(word) && !is_original_word) {
			memo.put(word, 1);
			return true;
		}
	    if(memo.containsKey(word)) {
			return memo.get(word) == 1;
		}
		for(int j = 1; j < word.length(); j ++) {
			// 分割单词
			if (wordSet.contains(word.substring(0, j)) 
		            && canForm(word.substring(j), wordSet, memo, false)) {
				 memo.put(word, 1);;
	             return true;
			 }
		}
		// 如果不能分解，缓存结果
	    memo.put(word, 0);
		return false;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_472_ConcatenatedWords solution = new _472_ConcatenatedWords();
    		System.out.println("测试结果：" + solution.findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
	}
}
/**
 * 你提到的思路是从某个单词开始尝试”减掉”它的组成部分，这其实是分解字符串的过程：
	1.	如果从某个单词的开头开始，可以找到一个前缀在数组中存在，则剩下的部分继续尝试。
	2.	如果能一直找到有效的组合，则这个字符串是一个符合条件的连接词。
	这是回溯搜索的基本思想。
	1.	如何快速判断一个前缀是否存在？
	•	为了加速前缀的查找，可以使用 哈希集合（Set） 来存储所有的单词，这样查找前缀是否存在只需要 O(1) 的时间。
	2.	如何避免重复计算？
	•	可以使用 动态规划（DP）或者记忆化搜索 来存储已经处理过的部分结果，避免对同一个子问题重复求解。
	3.	如何处理字符串本身？
	•	一个字符串不能由它本身作为组成部分，因此需要在检查时排除掉当前的字符串本身。
	
	Step 1: 构建基础的前缀查找

	•	使用一个哈希集合存储 words 中所有的单词。
	•	对于每个字符串 word，尝试从索引 0 开始依次检查它是否能被分解成其他单词。

	Step 2: 使用回溯进行分解  这一步不清楚

	•	从字符串的起始位置开始，逐步尝试用集合中的单词匹配前缀。
	•	如果匹配成功，递归地处理剩余部分，直到整个字符串被成功分解。
	•	如果当前路径不能成功分解，就回溯，尝试其他可能。

	Step 3: 添加记忆化来加速

	•	使用一个字典或者数组来存储子问题的结果，比如：dp[i] 表示从索引 i 到字符串末尾的部分是否能被分解。
 */