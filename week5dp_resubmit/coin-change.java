public class Solution {
	public static int coinChange(int[] coins, int amount) {

		int[] minCountOfCoinsForSomeAmountI = new int[amount + 1]; // 代表每一个amount的所需要的最小硬币数量

		/**
		 * // 之所以用fill(amount+1),是用了一个小把戏：int的非0最小值是1, 而coin里没有0。所以assert //
		 * min(coins) ≥ 1 // 所以达到某amount x (int x>0)所需要的硬币数量至多为x。（至少为1）。
		 * <p>
		 * 于是有 assert (amount+1) >max(需要用的最小数量的硬币). //
		 * 
		 * @mysteryInitValue :可以取任意值∈[amount+1, INT_MAX-1].
		 *                   之所以不能取INT_MAX是因为在写入那一行的会产生INT_MAX
		 *                   +1=INT_MIN(负数)的integer overflow情况.
		 * @为什么要mysteryInitValue ∈[amount+1, INT_MAX-1]? 因为这样可以制造矛盾，在最后一行判断是否会有
		 *                       {@return -1}<br>
		 *                       利用原理：dp[i]<=i)<br>
		 *                       ,相当于null了。
		 * @能写一个用null的？ （{2016-5-26 9.49 PM} 写完了，速度是这个的2X（因为Integer慢），就不po上来了）
		 * 
		 */
		int mysteryHighValue = Integer.MAX_VALUE - 1;
		Arrays.fill(minCountOfCoinsForSomeAmountI, mysteryHighValue);
		minCountOfCoinsForSomeAmountI[0] = 0;
		// 其实这里的int[]应该理解成HashMap<Integer, Integer>: amount => 最小的硬币数量
		for (int currentAmount = 1; currentAmount <= amount; currentAmount++)
			for (int coin : coins)
				if (coin <= currentAmount) { // 如果可以用这个coin兑换currentAmount：
					int previousAmount = currentAmount - coin;
					minCountOfCoinsForSomeAmountI[currentAmount] = Math.min(
							minCountOfCoinsForSomeAmountI[currentAmount],
							minCountOfCoinsForSomeAmountI[previousAmount] + 1);
				}
		return minCountOfCoinsForSomeAmountI[amount] > amount
				? -1
				: minCountOfCoinsForSomeAmountI[amount];
	}
}