package leetcode;
import java.util.*;

public class _135_candy {
	public int candy(int[] ratings) {
        int n = ratings.length;
        /**
        at least one
        相邻的孩子评分更高的更多
        最少的糖果
        [1,0,2]
        0,1,2
        [1,1]
        [1,0,2,5,6,2,3,8,2,5,7] len = 11
        [1,1,2,3,5,5,6,8,8,9]
         */
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i = 1; i < n; i ++) {
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }
        int count = left[n - 1];
        for(int i = n - 2; i >= 0; i --) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_135_candy solution = new _135_candy();
    		System.out.println("测试结果：" + solution.candy(new int[] {1,0,2,5,6,2,3,8,2,5,7}));
	}
}
