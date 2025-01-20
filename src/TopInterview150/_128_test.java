package TopInterview150;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class _128_test {
	_128_longestConsecutiveSequence solution = new _128_longestConsecutiveSequence();
	
	@Test
	void testConsecutiveSequence() {
		assertEquals(4, solution.longestConsecutive(new int[] {100,4,200,1,3,2}));
		assertEquals(9, solution.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
		assertEquals(3, solution.longestConsecutive(new int[] {1,2,0,1}));
	}

}
