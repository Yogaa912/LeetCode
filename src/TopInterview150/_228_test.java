package TopInterview150;
import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;

public class _228_test {
	_228_summaryRanges solution = new _228_summaryRanges();
	
	@Test
	void testConsecutiveSequence() {
		assertEquals(List.of("0->2", "4->5", "7"), solution.summaryRanges(new int[] {0,1,2,4,5,7}));
		assertEquals(List.of("0","2->4","6","8->9"), solution.summaryRanges(new int[] {0,2,3,4,6,8,9}));
	}

}
