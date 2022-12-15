public class SubArraySumEqualsK {

	// TODO broken -> sliding window is not entirely applied here; fix with prefix sum
	public static int subArraySum(int[] nums, int k) {
		if(nums.length != 0 && k == 0) return 0;
		int sum = 0, windowStart = 0, totalNumber = 0;
		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
			sum += nums[windowEnd];
			if(sum > k) {
				sum -= nums[windowStart];
			}
			if (sum == k) {
				totalNumber++;
				sum -= nums[windowStart];
				windowStart++;
			}
		}
		return totalNumber;
	}

	public static void main(String[] args) {
		System.out.println(subArraySum(new int[]{1, 1, 1, 1}, 2));
		System.out.println(subArraySum(new int[]{1}, 0));
		// System.out.println(subArraySum(new int[]{1, 2, 3}, 3));
	}
}