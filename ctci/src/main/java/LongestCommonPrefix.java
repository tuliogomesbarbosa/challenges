public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		StringBuilder longestPrefix = new StringBuilder();
		char[] firstWordChars = strs[0].toCharArray();

		for(int i = 0; i < firstWordChars.length; i++) {
			for(int j = 1; j < strs.length; j++) {
				if(i >= strs[j].length() || firstWordChars[i] != strs[j].toCharArray()[i]) {
					return longestPrefix.toString();
				}
			}
			longestPrefix.append(firstWordChars[i]);
		}

		return longestPrefix.toString();
	}

	/**
	 * S = O(m); T = O(m*n), where m = length of prefix, n = number of strings
	 */
	public static void main(String[] args) {

	}

}
