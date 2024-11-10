package LCR011_FindMaxLength;
import java.util.*;

class LCR011_FindMaxLength {
    public int findMaxLength(int[] nums) {
    	Map<Integer,Integer> prefixSumIndices = new HashMap<>();
    	int prefixSum = 0;
    	int maxLength = 0;
    	prefixSumIndices.put(0, -1);
    	for(int i = 0; i < nums.length; i ++) {
    		prefixSum += (nums[i] == 0) ? -1 : 1;
    		if(prefixSumIndices.containsKey(prefixSum)) {
    			maxLength = Math.max(maxLength, i - prefixSumIndices.get(prefixSum));
    		} else {
    			prefixSumIndices.put(prefixSum, i);
    		}
    	}
    	return maxLength;
    }
}