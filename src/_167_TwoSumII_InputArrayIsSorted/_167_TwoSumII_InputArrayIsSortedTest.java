package _167_TwoSumII_InputArrayIsSorted;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class _167_TwoSumII_InputArrayIsSortedTest {

	@Test
    public void testTwoSum_TargetExists() {
        _167_TwoSumII_InputArrayIsSorted solution = new _167_TwoSumII_InputArrayIsSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 2};  // 因为索引是1-based
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

    @Test
    public void testTwoSum_NoSolution() {
        _167_TwoSumII_InputArrayIsSorted solution = new _167_TwoSumII_InputArrayIsSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 20;
        int[] expected = {};  // 没有符合条件的解时返回空数组
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

    @Test
    public void testTwoSum_NegativeNumbers() {
        _167_TwoSumII_InputArrayIsSorted solution = new _167_TwoSumII_InputArrayIsSorted();
        int[] numbers = {-3, 3, 4, 90};
        int target = 0;
        int[] expected = {1, 2};  // 因为索引是1-based
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

    @Test
    public void testTwoSum_DuplicateNumbers() {
        _167_TwoSumII_InputArrayIsSorted solution = new _167_TwoSumII_InputArrayIsSorted();
        int[] numbers = {1, 2, 2, 3, 4};
        int target = 4;
        int[] expected = {1, 3};  // 返回第一个符合条件的组合
        assertArrayEquals(expected, solution.twoSum(numbers, target));
    }

}
