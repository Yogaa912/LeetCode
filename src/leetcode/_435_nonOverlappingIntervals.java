package leetcode;
import java.util.*;

public class _435_nonOverlappingIntervals {
	// 答题代码框架
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0, end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= end) { // interval的起始数字大于end
                count++;
                end = interval[1]; // 获得一个新的end，就是这个interval的终点
            }
        }
        return intervals.length - count;
    }
}
