package leetcode;
import java.util.*;

public class _88_mergeSortedArray {
    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] > nums2[j]) {
                list.add(nums2[j]);
                j ++;
            } else if(nums1[i] <= nums2[j]) {
                list.add(nums1[i]);
                i ++;
            }
        }
        if(i < m) {
            for(int k = i; k < m; k ++) {
                list.add(nums1[k]);
            }
        }
        if(j < n) {
            for(int k = j; k < n; k ++) {
                list.add(nums2[k]);
            }
        }
        System.out.print(list);
        for(int k = 0; k < m + n; k++) {
            nums1[k] = list.get(k);
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int len1 = m - 1, len2 = n - 1, len = nums1.length - 1;
    	while(len1 >= 0 && len2 >= 0) {
    		if(nums1[len1] >= nums2[len2]) {
    			nums1[len] = nums1[len1];
    			len1 --;
    			len --;
    		} else if(nums1[len1] < nums2[len2]) {
    			nums1[len] = nums2[len2];
    			len2 --;
    			len --;
    		}
    	}
    	if(len2 >= 0) {
    		// 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    	}
    	// 剩下一种情况不用管
    }
	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_88_mergeSortedArray solution = new _88_mergeSortedArray();
		int[] nums1 = new int[] {1,2,3,0,0,0};
		int[] nums2 = new int[] {2,5,6};
    	solution.merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
    	for(int i : nums1) {
    		System.out.print(i + " ");
    	}
	}
}
/*
 * 设置指针 len1 和 len2 分别指向 nums1 和 nums2 的有数字尾部，从尾部值开始比较遍历，同时设置指针 len 指向 nums1 的最末尾，每次遍历比较值大小之后，则进行填充
 * 当 len1<0 时遍历结束，此时 nums2 中海油数据未拷贝完全，将其直接拷贝到 nums1 的前面，最后得到结果数组
 * 数组可以直接从有空位的位置开始copy
 * 还有记得System.arraycopy(要拷贝的内容, 从哪开始, 拷贝到哪, 拷贝多长length)
 */