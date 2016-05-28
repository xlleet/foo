public class Solution {
	/**
	 * 面试中建议DP soltuion O(n) space，然后再优化O(1) space
	 * 
	 * @交作业
	 * @https://leetcode.com/discuss/71354
	 */
	public int maxProfit(int[] prices) {
		/**
		 * sell / buy means the maxProfit at day i with the last transaction be
		 * buy / sell. They may be called maxProfitWithLastSell /
		 * maxProfitWithLastEnd.
		 * <p>
		 * previousSell / previousBuy stores the sell / buy values at day i - 1.
		 */
		int sell = 0;
		int previousSell = sell;
		int buy = Integer.MIN_VALUE;
		int previousBuy = buy;

		for (int price : prices) {
			previousBuy = buy;
			// buy today's price or do nothing today
			buy = Math.max(previousSell - price, previousBuy);

			previousSell = sell;
			// sell today or do nothing today.
			sell = Math.max(previousBuy + price, previousSell);
		}
		return sell; // assert that sell > buy
	}
}