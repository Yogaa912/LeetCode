#!/bin/bash

# 检查是否提供了文件编号
if [ -z "$1" ]; then
  echo "请提供一个文件名，例如：33_statement"
  exit 1
fi

# 文件编号
FILE_NUMBER=$1

# 文件名，例如：_33_statement.java
FILE_NAME="_${FILE_NUMBER}.java"

# Java 文件路径
FILE_PATH="/Users/yujiazhang/eclipse-workspace/LeetCode/src/$FILE_NAME"

# 检查文件是否已存在
if [ -f "$FILE_PATH" ]; then
  echo "文件已存在：$FILE_PATH"
  exit 1
fi

# 创建文件并写入基础代码
cat <<EOL > "$FILE_PATH"
public class _${FILE_NUMBER} {
	// 答题代码框架
	public void method(int[] nums, int target) {
    	// 这里编写答题代码
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_${FILE_NUMBER} solution = new _${FILE_NUMBER}();
    		System.out.println("测试结果：" + solution.method(new int[] {1,2,3}, 0));
	}
}
EOL
echo “已创建文件：$FILE_NAME”
