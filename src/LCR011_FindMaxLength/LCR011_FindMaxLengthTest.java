package LCR011_FindMaxLength;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LCR011_FindMaxLengthTest {

	@Test
	void LCR011_FindMaxLength() {
		LCR011_FindMaxLength solution = new LCR011_FindMaxLength();

        // 测试用例
        assertEquals(2, solution.findMaxLength(new int[] {0, 1}));
        assertEquals(2, solution.findMaxLength(new int[] {0, 1, 0}));
        assertEquals(4, solution.findMaxLength(new int[] {0, 1, 1, 0}));
        assertEquals(4, solution.findMaxLength(new int[] {0, 0, 1, 1, 0}));
	}

}
