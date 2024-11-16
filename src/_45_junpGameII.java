public class _45_junpGameII {
	// 答题代码框架
    public int jump(int[] nums) {
        int count = 0;
        int currEnd = 0;
        int maxL = 0;
        for(int i = 0; i < nums.length - 1; i ++) {
            maxL = Math.max(maxL, i + nums[i]);
            if(i == currEnd) {
                count ++;
                currEnd = maxL;
                if(currEnd >= nums.length - 1) break;
            }
        }
        return count ++;
    }

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_45_junpGameII solution = new _45_junpGameII();
    		System.out.println("测试结果：" + 
		solution.jump(new int[] {2,3,1,1,4})); // 2
	}
}
/**
 * 所以这道题的思路就是先设定一个currEnd，让他等于当前能达到的最大位置，然后在到达这个最大位置之前，
 * 不断的计算maxLength，等到达了这个位置之后，直接用maxLength取代currEnd，
 * 直到这个能达到的最远范围超过了目标距离
 */