import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

	public static int findLength(String str, int k) {
		Map<Character, Integer> frequencies = new HashMap<>();
		int windowStart = 0, windowLength = 0;
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			frequencies.merge(str.charAt(windowEnd), 1, Integer::sum);
			while (frequencies.size() > k) {
				frequencies.put(str.charAt(windowStart), frequencies.get(str.charAt(windowStart)) - 1);
				if (frequencies.get(str.charAt(windowStart)) == 0) {
					frequencies.remove(str.charAt(windowStart));
				}
				windowStart++;
			}
			windowLength = Math.max(windowLength, windowEnd - windowStart + 1);
		}

		return windowLength;
	}

	public static void main(String[] args) {
		String str = "araaci"; // cbbebi
		int k = 2; // 3

		System.out.println(findLength(str, k));
	}
}