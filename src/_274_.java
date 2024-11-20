import java.util.*;

public class _274_ {
	public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        // 0, 1, 3, 5, 6
        // 我感觉这道题要先假设出一个结果，再用结果去论证
        /*
        有n篇论文
        citation.length >= n; citation
         */
        int left = 0, right = citations.length - 1, mid = 0;
        if(citations.length == 0) return 0;
        if(citations.length == 1) return citations[0] == 0 ? 0 : 1;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(citations[mid] >= citations.length - mid) { //113
                // 说明mid是符合的，有可能还要比mid大
            	// 尝试更大的 H-Index
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }
	public static void main(String[] args) {
    	// 测试样例
		System.out.println("测试结果：" + hIndex(new int[] {3,0,6,1,5}));
	} // 0 1 3 5 6
}
/*
 * 在二分查找过程中，left 和 right 的范围始终包围不满足条件的区域。我们通过不断调整 left 和 right，逐步缩小这个“不满足条件的区域”，最终找到满足条件的最小索引。
 * 
 */