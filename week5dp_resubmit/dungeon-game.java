/**
 * https://leetcode.com/problems/dungeon-game/
 * 
 * @siilar
 * @(M) Unique Paths
 * @(M) Minimum Path Sum
 * @麻烦之处在于：主角不能死在半路-也就是如果-1,-100, +10000的话，也得有-101的血。
 */
public class Solution {
	/**
	 * 抄答案……好难
	 * @https://leetcode.com/discuss/20829
	 * @time O(n^2)
	 * @space O(n^2) - 就像triangle sum一样，<br>
	 *        可以降低到 O(n) (一行)<br>
	 *        或者O(1) (修改input)
	 */
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		// hp[i][j] represents the min hp needed at position (i, j)
		// Add dummy row and column at bottom and right side (这样的话一个loop就可以搞定)
		int[][] hp = new int[m + 1][n + 1];
		for (int[] hpRow : hp)
			Arrays.fill(hpRow, Integer.MAX_VALUE);

		hp[m][n - 1] = 1;
		hp[m - 1][n] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int need = Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
				hp[i][j] = need <= 0 ? 1 : need;
			}
		}
		return hp[0][0];
	}

	
}