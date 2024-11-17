import java.util.*;

class _380_RandomizedSet {
    private Map<Integer, Integer> map;
    private Random rand;
    private List<Integer> list;
    public _380_RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, list.size()); // index
            list.add(val);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);
            // [1] 0 用last来覆盖删除的元素
            int lastNum = list.get(list.size() - 1);
            list.set(index, lastNum);
            // 更新last的位置
            map.put(lastNum, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */