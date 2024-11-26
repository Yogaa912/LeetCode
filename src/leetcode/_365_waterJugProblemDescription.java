package leetcode;
import java.util.*;

public class _365_waterJugProblemDescription {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false; // z 超过两壶容量总和，肯定无法实现
        if (z == 0) return true;    // z 为 0，初始状态即满足

        // 用队列存储状态
        Queue<int[]> queue = new LinkedList<>();
        // 用 Set 存储访问过的状态，避免重复
        Set<String> visited = new HashSet<>();

        // 初始状态
        queue.offer(new int[]{0, 0});
        visited.add("0,0");

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int a = state[0]; // 第一个水壶的水量
            int b = state[1]; // 第二个水壶的水量

            // 如果某个状态满足目标条件
            if (a == z || b == z || a + b == z) {
                return true;
            }

            // 枚举所有可能的下一步状态
            List<int[]> nextStates = Arrays.asList(
                new int[]{x, b}, // 把第一个水壶装满
                new int[]{a, y}, // 把第二个水壶装满
                new int[]{0, b}, // 倒空第一个水壶
                new int[]{a, 0}, // 倒空第二个水壶
                new int[]{Math.max(0, a - (y - b)), Math.min(y, a + b)}, // 把第一个水壶的水倒入第二个水壶
                new int[]{Math.min(x, a + b), Math.max(0, b - (x - a))}  // 把第二个水壶的水倒入第一个水壶
            );

            for (int[] nextState : nextStates) {
                String stateKey = nextState[0] + "," + nextState[1];
                if (!visited.contains(stateKey)) {
                    queue.offer(nextState);
                    visited.add(stateKey);
                }
            }
        }

        return false; // 如果所有状态都无法满足，返回 false
    }
	public boolean canMeasureWater0(int x, int y, int target) {
        // (0,5)(3,2)(0,2)(2,0)(2,5)(3,4) // 整个步骤中有效的部分是x,y,当前装在管子里的差值
        // dp[i]是第i步两边的情况 (3,0)(0,3)(3,3)(1,5)(1,0)(3,1)(0,4)
        // 都是0 选多的倒，一个0一个不是 把水倒进多的然后在少的倒满，都不是0 倒掉某一边的
        if(x > y) {
        	int temp = x;
        	x = y;
        	y =temp;
        }
		if(target == x + y) return true; 
		int[] dpx = new int[20];
        int[] dpy = new int[20];
        Set<int[]> set = new HashSet<>();
        dpx[0] = dpy[0] = 0;
        int i = 1;
        while(i <= 10) {
        	// 每个瓶子有5种行为，往里面倒满，往里面倒另一个瓶子的全部，全部倒掉，倒进另一个瓶子把对方注满，自己还有剩
        	// 结束之后的状态：满，空，一部分(这个部分必然来自另一个杯子的状态)
        	// 记录两个杯子的状态
        	// 杯子现在的状态 dpy[i] = g1(dpx[i - 1], dpy[i - 1]), dpx[i] = g1(dpx[i - 1], dpy[i - 1])
        	int[] now = chageStatus(dpx[i - 1], dpy[i - 1], x, y, target);
        	dpx[i] = now[0];
        	dpy[i] = now[1];
        	if(set.contains(now)) {
        		return false;
        	} else {
        		set.add(now);
        	}
        	if(dpx[i] == target || dpy[i] == target || (dpx[i] + dpy[i]) == target) return true;	
            i ++;
        }
        return false;
    }
	private int[] chageStatus(int dpx, int dpy, int x, int y, int target) {
		/**
		 *  把第一个水壶装满：(x, b)。
			把第二个水壶装满：(a, y)。
			倒空第一个水壶：(0, b)。
			倒空第二个水壶：(a, 0)。
			把第一个水壶的水倒入第二个水壶：
			如果 a + b <= y，结果是 (0, a + b)。
			如果 a + b > y，结果是 (a + b - y, y)。
			把第二个水壶的水倒入第一个水壶：
			如果 a + b <= x，结果是 (a + b, 0)。
			如果 a + b > x，结果是 (x, a + b - x)。
		 * */
		int[] water = new int[2];
		if(dpx == 0) {
			if(dpy == 0) {
				water[0] = dpx;
				water[1] = y;
			} else if(dpy > x) {
				while(water[1] > target) {
					water[1] -= x;
				}
	        	water[0] = x;
			} else {
				// 0 < dpy < x
				water[0] = dpy;
				water[1] = 0;
			}
		} else if(dpx < x) {
			if(dpy == 0) {
				water[0] = dpx;
				water[1] = y;
			} else if(dpy == y) {
				water[1] = y - (x - dpx);
	        	water[0] = x;
			} else {
				water[0] = dpx;
				water[1] = 0;
			}
		} else if(dpx == x) {
			if(dpy == y) {
				water[0] = 0;
				water[1] = dpy;
			} else {
				water[0] = 0;
				water[1] = dpy;
			}
		}
        return water;
	}

	// 测试代码
	public static void main(String[] args) {
    	// 测试样例
		_365_waterJugProblemDescription solution = new _365_waterJugProblemDescription();
    		System.out.println("测试结果：" + solution.canMeasureWater(34,5,6)); // false
	}
}
