package book.chapter1;

// Eye for detail: is ASCII or Unicode?
// Assuming it's ASCII -> 128 characters; extended ASCII -> 256 chars
public class UniqueChars {

	public static void main(String[] args) {
		System.out.println(isUniqueWithBitSet("uniqe"));
		System.out.println(isUniqueWithBitSet("unique"));
		System.out.println(isUniqueWithArrayOfBooleans("uniqe"));
		System.out.println(isUniqueWithArrayOfBooleans("unique"));
	}

	// time O(N) or O(1): doesn't iterate more than 128 chars; space O(128) -> O(1)
	private static boolean isUniqueWithArrayOfBooleans(String str) {
		if(str.length() > 128) return false;

		boolean[] charset = new boolean[128];

		for (int i = 0; i < str.length(); i++) {
			if (charset[str.charAt(i)]) {
				return false;
			}
			charset[str.charAt(i)] = true;
		}

		return true;
	}

	// time O(N) or O(1); space reduced by a factor of eight
	private static boolean isUniqueWithBitSet(String str) {
		if (str.length() > 128) return false;

		int checker = 0; // 32 bits -> lower case letters a -> z (26 bits used)

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			// e.g. 1 << 20 == 100000000000000000000;
			// first loop with 'u': checker & (1 << val)) == 000000000000000000000
			// checker |= (1 << val) ==
			// 		000000000000000000000 |
			// 		100000000000000000000
			// ==   100000000000000000000 ('u' is now set)
			if((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}

		return true;
	}

	// O(n^2) and O(1) space; inner loops
	// if it's allowed to modify the string, sort if first (O(nlog(n)) and linearly check the neighboring chars;
	// careful: many sorting algos take extra space;
	private static boolean noAdditionalSpace(String str) {
		return false;
	}
}