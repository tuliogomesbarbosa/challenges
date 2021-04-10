package eip.java;

public class Trading {

	public int maxProfit(int[] s) {
		int maxProfit = 0;

		for (int i = 0; i < s.length - 1; i++) { // buy
			for (int j = i + 1; j < s.length; j++) { // sell
				int diff = s[j] - s[i];
				if (diff > maxProfit) maxProfit = diff;
			}
		}

		return maxProfit;
	}

	public int maxProfit2(int[] s) {
		int minPrice = Integer.MAX_VALUE, maxProfit = 0;
		for (int i = 0; i < s.length; i++) {
			maxProfit = Math.max(maxProfit, s[i] - minPrice);
			minPrice = Math.min(minPrice, s[i]);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] s = {45, 56, 40, 38, 60, 58};

		var trading = new Trading();
		// trading.maxProfit(s);
		System.out.println(trading.maxProfit2(s));
	}
}
