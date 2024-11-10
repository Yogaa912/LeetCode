1. 使用prefixSum方法来做平衡
2. 使用HashMap来储存prefixSum和第一次出现的index
3. Ternary Operator三元运算符，`:?`的优先级比`+= `低，也可以`prefixSum += (nums[i] == 0 ? -1 : 1);`
4. `map.containsKey(key)`这里c要小写
5. 别忘记最后没有出现过的prefix要添加到map上去
6. `int[] nums; nums.length;`
7. 一开始要规定`map.put(0,-1);`因为一开始的prefix是平衡的