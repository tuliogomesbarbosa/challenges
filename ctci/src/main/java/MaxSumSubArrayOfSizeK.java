public class MaxSumSubArrayOfSizeK {

	/**
	 * time complexity -> O(N)
	 * space complexity -> O(1)
	 */
	public static int findMaxSumSubArray(int k, int[] arr) {
		int max = 0, sum = 0, windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum += arr[windowEnd];
			if (windowEnd >= k - 1) { // wait until a sub-array of k is iterated -> window size
				max = Math.max(max, sum);
				sum -= arr[windowStart];
				windowStart++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
		System.out.println(findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
	}
}
