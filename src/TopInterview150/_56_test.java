package TopInterview150;
import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;

public class _56_test {
	_56_mergeIntervals solution = new _56_mergeIntervals();
	
	@Test
	void test() {
		assertEquals(new int[][] {{1,6},{8,10},{15,18}}, solution.merge(new int[][] {{1,3},{2,6},{8,10},{15,18}}));
		assertEquals(new int[][] {{1,5}}, solution.merge(new int[][] {{1,4},{4,5}}));
	}

}
