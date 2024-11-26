package leetcode;
public class _11_ContainerWithMost {
	public static int maxArea0(int[] height) {
		int left = 0;
		int right = height.length - 1;
		// calculate result
		int result = Math.min(height[left], height[right])*(right - left);
		while(left < right) {
			while(left < right) {
				right --;
				result = Math.max(Math.min(height[left], height[right])*(right - left), result);
			}
			right = height.length - 1;
			left ++;
			result = Math.max(Math.min(height[left], height[right])*(right - left), result);
		}
		return result;
    }
	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		// calculate result
		int result = Math.min(height[left], height[right])*(right - left);
		while(left < right) {
			if(height[left] < height[right]) {
				left ++;
			} else {
				right --;
			}
			result = Math.max(Math.min(height[left], height[right])*(right - left), result);
		}
		return result;
    }
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7})); // 49
		System.out.println(maxArea(new int[] {8,7,2,1})); // 7
		System.out.println(maxArea(new int[] {2,3,4,5,18,17,6})); // 17
	}
}
/**
 * 注意两根指针是如何移动的
 * 不需要循环while，因为每次只需要移动高度较小的指针即可
 * 少写while循环，用了double pointer就不需要while循环了
 */