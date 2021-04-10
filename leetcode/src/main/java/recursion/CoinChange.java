package recursion;

public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) return 0;
		if (amount < 0) return -1;

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			int subProblem = coinChange(coins, amount - coins[i]);
			if (subProblem == -1) continue;
			res = Math.min(res, 1 + subProblem);
		}
		return res != Integer.MAX_VALUE ? res : -1;
	}

	public static void main(String[] args) {
		System.out.println(coinChange(new int[]{1, 2, 5}, 11));
		System.out.println(12 / 10);
	}
}