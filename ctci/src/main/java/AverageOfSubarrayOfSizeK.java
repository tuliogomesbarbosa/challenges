import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

	public static double[] findAverages(int k, int[] arr) {
		double[] result = new double[arr.length - k + 1];
		double sum = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum += arr[windowEnd];
			if (windowEnd >= k - 1) {
				result[windowStart] = sum / k;
				sum -= arr[windowStart];
				windowStart++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2})));
	}

}
