
# 常用算法与数据结构技巧总结

## 1. 双指针
### **适用场景**：
- **数组或字符串问题**，如查找子序列、滑动窗口、排序问题。

### **常用模板**：
1. **左右指针**（如判断回文、对撞指针）：
   ```java
   int left = 0, right = arr.length - 1;
   while (left < right) {
       if (arr[left] == arr[right]) {
           // 处理逻辑
           left++;
           right--;
       }
   }
   ```

2. **滑动窗口**（如找到满足条件的子串/子数组）：
   ```java
   int left = 0, sum = 0;
   for (int right = 0; right < arr.length; right++) {
       sum += arr[right];
       while (sum > target) {
           sum -= arr[left];
           left++;
       }
       // 判断是否满足条件
   }
   ```

---

## 2. 哈希表
### **适用场景**：
- 统计频率、快速查找、两数之和等。

### **常用模板**：
1. **两数之和**：
   ```java
   Map<Integer, Integer> map = new HashMap<>();
   for (int i = 0; i < nums.length; i++) {
       int complement = target - nums[i];
       if (map.containsKey(complement)) {
           return new int[]{map.get(complement), i};
       }
       map.put(nums[i], i);
   }
   ```

2. **统计字符频率**：
   ```java
   Map<Character, Integer> freq = new HashMap<>();
   for (char c : s.toCharArray()) {
       freq.put(c, freq.getOrDefault(c, 0) + 1);
   }
   ```

---

## 3. 栈与队列
### **适用场景**：
- 括号匹配、单调栈、广度优先搜索（BFS）等。

### **常用模板**：
1. **括号匹配**：
   ```java
   Stack<Character> stack = new Stack<>();
   for (char c : s.toCharArray()) {
       if (c == '(') {
           stack.push(c);
       } else if (c == ')') {
           if (stack.isEmpty() || stack.pop() != '(') {
               return false;
           }
       }
   }
   return stack.isEmpty();
   ```

2. **单调栈（找下一更大元素）**：
   ```java
   Stack<Integer> stack = new Stack<>();
   int[] result = new int[nums.length];
   for (int i = nums.length - 1; i >= 0; i--) {
       while (!stack.isEmpty() && stack.peek() <= nums[i]) {
           stack.pop();
       }
       result[i] = stack.isEmpty() ? -1 : stack.peek();
       stack.push(nums[i]);
   }
   ```

---

## 4. 二分查找
### **适用场景**：
- 查找特定值、最优解（如最小值或最大值）。

### **常用模板**：
1. **标准二分查找**：
   ```java
   int left = 0, right = arr.length - 1;
   while (left <= right) {
       int mid = left + (right - left) / 2;
       if (arr[mid] == target) {
           return mid;
       } else if (arr[mid] < target) {
           left = mid + 1;
       } else {
           right = mid - 1;
       }
   }
   return -1;
   ```

2. **变种（如查找左边界/右边界）**：
   ```java
   int left = 0, right = arr.length;
   while (left < right) {
       int mid = left + (right - left) / 2;
       if (arr[mid] < target) {
           left = mid + 1;
       } else {
           right = mid;
       }
   }
   return left;
   ```

---

## 5. 动态规划
### **适用场景**：
- 求解最优子结构问题，如最长公共子序列、背包问题等。

### **常用模板**：
1. **斐波那契数列（基本 DP 模板）**：
   ```java
   int[] dp = new int[n + 1];
   dp[0] = 0;
   dp[1] = 1;
   for (int i = 2; i <= n; i++) {
       dp[i] = dp[i - 1] + dp[i - 2];
   }
   return dp[n];
   ```

2. **背包问题（01 背包）**：
   ```java
   int[] dp = new int[capacity + 1];
   for (int i = 0; i < items.length; i++) {
       for (int j = capacity; j >= items[i]; j--) {
           dp[j] = Math.max(dp[j], dp[j - items[i]] + values[i]);
       }
   }
   return dp[capacity];
   ```

3. **最长公共子序列**：
   ```
   java
   int[][] dp = new int[m + 1][n + 1];
   for (int i = 1; i <= m; i++) {
       for (int j = 1; j <= n; j++) {
           if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1] + 1;
           } else {
               dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
           }
       }
   }
   return dp[m][n];
   ```

---

## 6. 贪心算法
### **适用场景**：
- 每一步选择当前最优解，最终得出全局最优解的问题，如活动选择问题、区间调度问题。

### **常用模板**：
1. **跳跃游戏**：
   ```java
   int maxReach = 0;
   for (int i = 0; i <= maxReach; i++) {
       maxReach = Math.max(maxReach, i + nums[i]);
       if (maxReach >= nums.length - 1) {
           return true;
       }
   }
   return false;
   ```

2. **区间调度问题**：
   ```java
   Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
   int count = 0, end = Integer.MIN_VALUE;
   for (int[] interval : intervals) {
       if (interval[0] >= end) {
           count++;
           end = interval[1];
       }
   }
   return count;
   ```

---

## 7. 深度优先搜索（DFS）与广度优先搜索（BFS）
### **适用场景**：
- 图遍历、树的递归操作、求最短路径等。

### **DFS 模板**：
```java
void dfs(Node node, Set<Node> visited) {
    if (node == null || visited.contains(node)) return;
    visited.add(node);
    for (Node neighbor : node.neighbors) {
        dfs(neighbor, visited);
    }
}
```

### **BFS 模板**：
```java
Queue<Node> queue = new LinkedList<>();
Set<Node> visited = new HashSet<>();
queue.add(start);
visited.add(start);

while (!queue.isEmpty()) {
    Node node = queue.poll();
    for (Node neighbor : node.neighbors) {
        if (!visited.contains(neighbor)) {
            queue.add(neighbor);
            visited.add(neighbor);
        }
    }
}
```

---

## 8. 数学技巧
### **适用场景**：
- 快速计算、整除问题、素数等。

1. **快速幂**：
   ```java
   long power(long x, int n) {
       long result = 1;
       while (n > 0) {
           if ((n & 1) == 1) {
               result *= x;
           }
           x *= x;
           n >>= 1;
       }
       return result;
   }
   ```

2. **求最大公约数（辗转相除法）**：
   ```java
   int gcd(int a, int b) {
       return b == 0 ? a : gcd(b, a % b);
   }
   ```
