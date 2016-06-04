package week6_dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/integer-break/
 * 
 * <pre>
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * Note: you may assume that n is not less than 2.
 * 
 * Hint:
 * 
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 * 
 * </pre>
 */

/**
 * 为什么是3呢？因为是求导得出的结果, 1-ln(x) = 0, x = e, e ≈ 3.
 * 
 * @http://www.wolframalpha.com/input/?i=d%5Bx%5E(n%2Fx)%5D%2Fdx
 * @https://leetcode.com/discuss/98276
 */
public class IntegerBreak {

	/**
	 * 分类讨论： base case + n%3 三种情况讨论
	 *
	 * @https://leetcode.com/discuss/98173/o-log-n-time-solution-with-explanation
	 */
	public int integerBreakLogn(int n) {
		if (n == 2)
			return 1;
		else if (n == 3)
			return 2;
		switch (n % 3) {
			case 0 :
				return (int) Math.pow(3, n / 3);
			case 1 :
				return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
			default : // case 2
				return 2 * (int) Math.pow(3, n / 3);
		}
	}

	/**
	 * @https://leetcode.com/discuss/102706/an-simple-explanation-of-the-math-part-and-a-o-n-solution
	 * @time O(n)
	 */
	public int integerBreakOn(int n) {
		if (n == 2)
			return 1;
		else if (n == 3)
			return 2;
		int product = 1;
		for (; n > 4; product *= 3, n -= 3); // do not write this in interview. 
		return product * n;
	}
}
