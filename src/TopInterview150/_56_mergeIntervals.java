package TopInterview150;
import java.util.*;

public class _56_mergeIntervals {
	/**
	 * 以数组 intervals 表示若干个区间的集合，
	 * 其中单个区间为 intervals[i] = [starti, endi] 。
	 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，
	 * 该数组需恰好覆盖输入中的所有区间 。
	 * */
	public int[][] merge0(int[][] intervals) {
		List<List<Integer>> re = new ArrayList<>();
		int label = intervals[0][0];
    	// if 前一个end >= 后一个start，那么就是有覆盖
		for(int i = 0; i < intervals.length - 1; i ++) {
			int end = intervals[i][1];
			int start = intervals[i + 1][0];
			if(end < start) {
				// 如果不重叠，就把前面的都叠加
				re.add(List.of(label, end));
				if(i == intervals.length - 2) re.add(List.of(end, intervals[i + 1][0]));
				label = intervals[i + 1][0];
			} else {
				// 继续接上
				if(i == intervals.length - 1) re.add(List.of(label, end));
			}
		}
		// list -> int[][]
		int[][] result = new int[re.size()][2];
		for(int i = 0; i < re.size(); i ++) {
			for(int j = 0; j < 2; j ++) {
				result[i][j] = re.get(i).get(j);
				System.out.println(result[i][j]);
			}
		}
		return result;
	}
	public int[][] merge(int[][] intervals) {
		List<int[]> re = new ArrayList<>();
		
		if(intervals.length == 1) return intervals;
		// 按照起始位置排序
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int label = intervals[0][0];
		// if 前一个end >= 后一个start，那么就是有覆盖
		for(int i = 0; i < intervals.length - 1; i ++) {
			int end = intervals[i][1];
			int start = intervals[i + 1][0];
			if(end < start) {
				// 如果不重叠，就把前面的都叠加
				re.add(new int[] {label, end});
				if(i == intervals.length - 2) re.add(new int[] {intervals[i + 1][0], intervals[i + 1][1]});
				label = intervals[i + 1][0];
			} else {
				if(end > intervals[i + 1][1]) {
					intervals[i + 1][1] = end;
				}
				// 继续接上
				if(i == intervals.length - 2) re.add(new int[] {label, intervals[i + 1][1]});
			}
		}
		// list -> int[][]
		int[][] result = re.toArray(new int[0][]);
		for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
		return result;
	}
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_56_mergeIntervals solution = new _56_mergeIntervals();
		System.out.println("测试结果：" + 
		solution.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}}));
		System.out.println("测试结果：" + 
		solution.merge(new int[][] {{1,4},{0,4}}));
		// [[1,6],[8,10],[15,18]]
	}
}
/**
 * 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
 * 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
 * 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值
 * 这样做相当于先把区间加入结果，然后再修改尾端，我是先确定尾端再把它加入结果
 * */
