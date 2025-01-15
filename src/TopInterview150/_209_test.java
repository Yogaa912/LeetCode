package TopInterview150;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class _209_test {
	_209_containsDuplicateii solution = new _209_containsDuplicateii();
	
	@Test
	void tesContainsNearbyDuplicate() {
		assertEquals(false, solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
		assertEquals(true, solution.containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
		assertEquals(false, solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
	}
}
