package TopInterview150;
import java.util.*;

public class _49_groupAnagrams {
	// 字母异位词
	public List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		if(strs.length == 0) return list;
		list.add(new ArrayList<>(List.of(strs[0])));
		if(strs.length == 1) return list;
		System.out.println(list.get(0).get(0));
		for(int i = 1; i < strs.length; i ++) {
			// 每一个单词
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String temps = new String(temp);
			boolean flag = false;
			for(int j = 0; j < list.size(); j ++) {
				char[] tempe = list.get(j).get(0).toCharArray();
				Arrays.sort(tempe);
				String tempes = new String(tempe);
				if(temps.equals(tempes)) {
					list.get(j).add(strs[i]);
					flag = true;
					break;
				}
			}
			if(flag == false) {
				list.add(new ArrayList<>(List.of(strs[i])));
			}
		}
    	return list;
	}
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		if(strs.length == 0) return list;
		for(int i = 0; i < strs.length; i ++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String temps = new String(temp);
			if(!map.containsKey(temps)) {
				map.put(temps, new ArrayList<>(List.of(strs[i])));
			} else {
				map.get(temps).add(strs[i]);
			}
			
		}
		System.out.println(map);
		for(String key : map.keySet()) {
			list.add(map.get(key));
		}
		// 将 map 转为List<List<String>>
    	return list;
	}
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_49_groupAnagrams solution = new _49_groupAnagrams();
		String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println("测试结果：" + solution.groupAnagrams(strs));
		// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
	}
}
/**
 * 优化思路
 * 使用 HashMap 降低时间复杂度，产生排序后的字符串作为哈希表的键 
 * -- 我一开始也是这么想的，但是没想到通过哈希表来存储
 * **难点** 将排序后的字符串作为哈希表的键，未排序的原始字符串作为值存入哈希表
 * **难点** 将 map 转为List<List<String>>
 */