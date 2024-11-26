package leetcode;
public class fastExponentiation {
	long power(long x, int n) {
	    long result = 1;
	    while (n > 0) {
	        if ((n & 1) == 1) {
	            result *= x;
	        }
	        x *= x;
	        n >>= 1;
	    }
	    return result;
	}
}
