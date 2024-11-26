package leetcode;
import java.util.*;

public class _151_reverseWordsInString {
	public String reverseWords0(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int start = 0;
        List<String> words = new ArrayList<>();
        while(start < len && s.charAt(start) == ' ') start ++;
        for(int i = start; i < len; i ++) {
            if(s.charAt(i) == ' ' || i == len - 1) {
                if(s.charAt(i) != ' ') {
                    words.add(s.substring(start, i + 1));
                } else {
                    words.add(s.substring(start, i));
                }
                start = i;
                while(start < len && s.charAt(start) == ' ') {
                    start ++;
                }
                if(i != len - 1) i = start - 1;
            }
        }
        for(int i = words.size() - 1; i >= 0; i --) {
            sb.append(words.get(i));
            if(i != 0) sb.append(" ");
        }
        return sb.toString();
    }
	public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        int len = s.length();
        int start = 0;
        List<String> words = new ArrayList<>();
        while(start < len) {
            while(start < len && s.charAt(start) == ' ') start ++;
            if(start >= len) break;
            int end = start;
            while(end < len && s.charAt(end) != ' ') end ++;
            words.add(s.substring(start, end));
            start = end;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = words.size() - 1; i >= 0; i --) {
            sb.append(words.get(i));
            if(i != 0) sb.append(" ");
        }
        return sb.toString();
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_151_reverseWordsInString solution = new _151_reverseWordsInString();
		System.out.println("测试结果：" + solution.reverseWords("t "));
	}
}
/**
 * 
1. 先理清问题的核心逻辑
在写代码之前，花几分钟理清问题的核心逻辑和特殊边界情况，有助于减少后续的修改和调整。可以尝试以下步骤：
（1）从高层次拆解问题
将问题分解成几个关键步骤，并确保每一步的目标清晰。
比如在你的问题中，核心逻辑就是：
- 跳过多余空格；
- 提取单词；
- 将单词按倒序拼接。
（2）写出伪代码
用简单的伪代码描述逻辑，而不是直接写具体实现。
（3）识别边界条件
在实现代码前，思考可能的边界条件：
- 空字符串或全空格字符串。
- 字符串以空格开头或结尾。
- 连续多个空格。

2. 遵循清晰的逻辑分层
混乱的代码通常是因为“多层逻辑交织在一起”，比如在一段代码里同时处理跳过空格、提取单词和边界条件。清晰的逻辑应该像“搭积木”一样，一步步构建。
建议：将代码分成独立的功能块，每个功能块只负责完成一个目标。
改进你的代码的逻辑分层
你原来的代码混乱的原因是，每次遇到某个特殊情况（比如连续空格或字符串末尾），就在循环中加入一个 if 条件。可以通过以下方式改善：
- 跳过前导空格和处理空格逻辑独立分开。
- 提取单词和拼接单词分开。
- 尽量避免手动调整指针。

3. 逐步调试而非“临时补丁”式修改
当逻辑不清晰时，调试往往变成“临时补丁”——在运行结果出错时增加 if 条件或改逻辑。这种方式虽然能快速修正问题，但长远看效率低且代码变得越来越乱。
如何避免？
使用小规模测试用例：
- 写代码时，不要直接用复杂输入测试。
- 比如输入 " hello world " 或 "a b "，每次修改后逐步验证逻辑是否正确。
调试时打印中间状态：
- 打印出关键变量的值，帮助你理解代码的运行状态。
- 例如在你的代码中，打印每次提取的单词和当前指针位置：
 * 
 */